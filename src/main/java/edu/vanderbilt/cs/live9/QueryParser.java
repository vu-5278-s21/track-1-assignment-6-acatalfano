package edu.vanderbilt.cs.live9;

import edu.vanderbilt.cs.live9.ast.ExpressionNode;
import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.Node;
import edu.vanderbilt.cs.live9.ast.RParenNode;
import edu.vanderbilt.cs.live9.ast.visitor.PrintVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class QueryParser {

    private static class UnexpectedTokenException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        private String token;

        public UnexpectedTokenException(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }

    private static List<String> tokenize(String input) throws UnexpectedTokenException {
        final String pattern = "(\\s|(?<=\\))|(?=\\))|(?<=\\()|(?=\\())";
        try {
            return Arrays
                .stream(input.split(pattern))
                .filter(e -> !e.trim().isEmpty())
                .collect(Collectors.toList());
        } catch(PatternSyntaxException ex) {
            if (ex.getIndex() != 0) {
                throw new UnexpectedTokenException(
                    String.valueOf(pattern.charAt(ex.getIndex()))
                );
            } else {
                throw new UnexpectedTokenException(ex.getDescription());
            }
        }
    }

    private static Node parseNode(Iterator<String> tokens) {
        String next = tokens.next();

        if ("(".equals(next)) {
            return parseExpression(tokens);
        } else if (!")".equals(next)) {
            return new LiteralNode(next);
        } else {
            return new RParenNode();
        }
    }

    private static LiteralNode parseLiteral(Iterator<String> tokens) {
        Node op = parseNode(tokens);
        return op instanceof LiteralNode ? (LiteralNode)op : null;
    }

    private static ExpressionNode parseExpression(Iterator<String> tokens) {
        LiteralNode op = parseLiteral(tokens);

        List<Node> arguments = new ArrayList<>();
        while(tokens.hasNext()) {
            Node arg = parseNode(tokens);
            if (arg instanceof RParenNode) {
                break;
            } else {
                arguments.add(arg);
            }
        }
        return new ExpressionNode(op, arguments);
    }

    public static ExpressionNode parse(String query) {
        Iterator<String> tokens = tokenize(query).iterator();

        tokens.next();

        return parseExpression(tokens);
    }

    public static void main(String[] args) {
        parse("(find (near 90.0 90.0 3) (where (> height 20))")
            .accept(new PrintVisitor());
        parse(
            "(find " +
                "     (near -45.0 -145.0 2) " +
                "     (where " +
                "          (> :height 8)" +
                "     )" +
                ")"
        ).accept(new PrintVisitor());
    }

}
