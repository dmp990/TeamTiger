package com.sparta.tt.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatValidator {

    public static final String dateFormat = "yyyy-MM-dd";

    public static boolean isValidDate(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);

        try {
            LocalDate.parse(date, dateTimeFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    };
}
