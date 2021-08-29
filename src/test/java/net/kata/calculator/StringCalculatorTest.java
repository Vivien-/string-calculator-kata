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

    @Test
    void step2Tests() {
        assertEquals(3, calculator.add("1,1,1"));
        assertEquals(4, calculator.add("1,1,1,foo,1"));
        assertEquals(1, calculator.add("foo,bar,baz,1"));
        assertEquals(2, calculator.add("foo,bar,baz,1,foobar,1"));
    }

    @Test
    void step3Tests() {
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(4, calculator.add("1,\n2,1"));
    }

}