package net.kata.calculator;

import net.kata.calculator.exceptions.NegativeNumberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    private static final List<String> ALLOWED_SEPARATORS = Arrays.asList(",", "\n");

    public int add(String text) throws NegativeNumberException {
        if (text == null || text.isBlank()) {
            return 0;
        }

        List<String> negatives = new ArrayList<>();
        String[] numbers = text.split(String.join("|", getDelimiters(text)));
        int result = 0;

        for (String str : numbers) {
            int value = parseIntOrZero(str);
            if (value < 0) {
                negatives.add(str);
            }
            result += value;
        }

        if (!negatives.isEmpty()) {
            throw new NegativeNumberException("negatives not allowed: " + String.join(" ", negatives));
        }
        return result;
    }

    private List<String> getDelimiters(String text) {
        List<String> separators = new ArrayList<>(ALLOWED_SEPARATORS);
        String[] tokens = text.split("\n");
        if (tokens.length > 0 && tokens[0].startsWith("//")) {
            separators.add(tokens[0].replace("//", ""));
        }
        return separators;
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
