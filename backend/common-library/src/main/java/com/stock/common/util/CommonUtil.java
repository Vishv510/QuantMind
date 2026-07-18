package com.stock.common.util;

import java.util.UUID;

/**
 * Utility class for common operations
 */
public class CommonUtil {

    private CommonUtil() {
        // Private constructor to prevent instantiation
    }

    /**
     * Generate a unique request ID
     */
    public static String generateRequestId() {
        return UUID.randomUUID().toString();
    }

    /**
     * Check if a string is empty or null
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Check if a string is not empty
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
