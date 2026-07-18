package com.stock.notification.model;

public enum AlertConditionType {
    ABOVE,
    BELOW,
    EQUALS;

    public static AlertConditionType from(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Condition type is required");
        }
        return switch (value.trim().toLowerCase()) {
            case "above" -> ABOVE;
            case "below" -> BELOW;
            case "equals", "equal" -> EQUALS;
            default -> throw new IllegalArgumentException("Unsupported condition type: " + value);
        };
    }
}
