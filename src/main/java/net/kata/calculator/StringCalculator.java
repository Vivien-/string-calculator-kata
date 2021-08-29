package net.kata.calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    private static final List<String> ALLOWED_SEPARATORS = Arrays.asList(",", "\n");

    public int add(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        String[] numbers = text.split(String.join("|", ALLOWED_SEPARATORS));
        int result = 0;

        for (String str : numbers) {
            result += parseIntOrZero(str);
        }
        return result;
    }

    private int parseIntOrZero(String str) {
        int parsed;
        try {
            parsed = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            parsed = 0;
        }
        return parsed;
    }

}
