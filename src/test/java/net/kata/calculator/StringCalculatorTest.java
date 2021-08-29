package net.kata.calculator;

import net.kata.calculator.exceptions.NegativeNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    @Test
    void step1Tests() throws NegativeNumberException {
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
    void step2Tests() throws NegativeNumberException {
        assertEquals(3, calculator.add("1,1,1"));
        assertEquals(4, calculator.add("1,1,1,foo,1"));
        assertEquals(1, calculator.add("foo,bar,baz,1"));
        assertEquals(2, calculator.add("foo,bar,baz,1,foobar,1"));
    }

    @Test
    void step3Tests() throws NegativeNumberException {
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(4, calculator.add("1,\n2,1"));
    }

    @Test
    void step4Tests() throws NegativeNumberException {
        assertEquals(3, calculator.add("//;\n1;2"));
        assertEquals(2, calculator.add("//2\n1221"));
        assertEquals(1, calculator.add("//2\n122"));
        assertEquals(3, calculator.add("//2\n12\n1,1"));
    }

    @Test
    void step5Tests() {
        assertThrows(NegativeNumberException.class, () -> calculator.add("-1,1"));
        try {
            calculator.add("-1,-2,-3,4,-5");
        } catch (NegativeNumberException e) {
            assertEquals("negatives not allowed: -1 -2 -3 -5", e.getMessage());
        }
    }

}