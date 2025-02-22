package com.demo.sortgeek.security.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static Long getAuthenticatedMemberId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !(authentication.getPrincipal() instanceof String)) {
            throw new IllegalArgumentException("Member not authenticated");
        }

        String principal = (String) authentication.getPrincipal();

        try {
            return Long.parseLong(principal);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid member ID format");
        }
    }
}
