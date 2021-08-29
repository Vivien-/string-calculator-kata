package net.kata.calculator;

public class StringCalculator {
    public int add(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        String[] numbers = text.split(",");

        int first = numbers.length > 0 ? parseIntOrZero(numbers[0]) : 0;
        int second = numbers.length > 1 ? parseIntOrZero(numbers[1]) : 0;
        return first + second;
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
