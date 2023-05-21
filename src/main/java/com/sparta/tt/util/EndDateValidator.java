package com.sparta.tt.util;

import java.time.DateTimeException;
import java.time.LocalDate;

public class EndDateValidator {
    public static boolean dateValidator(String stDate, String enDate) {
        try {
            LocalDate startDate = LocalDate.parse(stDate);
            LocalDate endDate = LocalDate.parse(enDate);
            return endDate.isAfter(startDate);
        } catch (DateTimeException e) {
            return false;
        }
    }
}
