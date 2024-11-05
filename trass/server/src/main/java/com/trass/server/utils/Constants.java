package com.trass.server.utils;

public final class Constants {
    public static String getAuthValue(String token) {
        return "Bearer ".concat(token);
    }
}
