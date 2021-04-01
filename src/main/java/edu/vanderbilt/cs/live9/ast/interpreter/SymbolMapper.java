package edu.vanderbilt.cs.live9.ast.interpreter;

import java.util.HashMap;
import java.util.Map;

import edu.vanderbilt.cs.live9.ast.LiteralNode;

public class SymbolMapper {
    private static final Map<String, ExpressionType> expressionNodeMap;

    private static final String DOUBLE_REGEX =
        "^(?:(?:-?\\d+\\.?\\d*)|(?:-?\\d*\\.?\\d+))$";
    private static final String ATTRIBUTE_VALUE_REGEX =
        "^:[\\$_a-zA-Z\\d\\-][\\$\\w\\d\\-]*$";

    static {
        expressionNodeMap = new HashMap<>();
        expressionNodeMap.put("<", ExpressionType.LESS_THAN);
        expressionNodeMap.put(">", ExpressionType.GREATER_THAN);
        expressionNodeMap.put("find", ExpressionType.FIND);
        expressionNodeMap.put("where", ExpressionType.WHERE);
        expressionNodeMap.put("and", ExpressionType.AND);
        expressionNodeMap.put("near", ExpressionType.NEAR);
    }

    public ExpressionType getType(LiteralNode node) {
        if (isDouble(node.getValue())) {
            Double value = Double.valueOf(node.getValue());
            return value == value.intValue()
                ? ExpressionType.INTEGER
                    : ExpressionType.DOUBLE;
        } else if (isAttributeValue(node.getValue())) {
            return ExpressionType.ATTRIBUTE;
        } else {
            return expressionNodeMap
                .getOrDefault(node.getValue(), ExpressionType.INVALID_EXPRESSION);
        }
    }

    private static boolean isDouble(String value) {
        return value.matches(DOUBLE_REGEX);
    }

    private static boolean isAttributeValue(String value) {
        return value.matches(ATTRIBUTE_VALUE_REGEX);
    }
}
