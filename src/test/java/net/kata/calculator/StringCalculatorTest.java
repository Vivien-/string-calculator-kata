package net.kata.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    @Test
    void step1Tests() {
        assertEquals(0, calculator.add(""));
        assertEquals(0, calculator.add("0"));
        assertEquals(63, calculator.add("63"));
        assertEquals(63, calculator.add("63,"));
        assertEquals(63 + 54, calculator.add("63,54"));
        assertEquals(63, calculator.add("63,foo"));
        assertEquals(63, calculator.add(",63,foo"));
        assertEquals(0, calculator.add(",bar,foo"));
    }
}