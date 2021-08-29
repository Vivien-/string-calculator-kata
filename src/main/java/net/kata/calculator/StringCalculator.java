package net.kata.calculator;

public class StringCalculator {
    public int add(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        String[] numbers = text.split(",");
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
