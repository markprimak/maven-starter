package com.example.starter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StarterTest {

    private final Calculator calculator = new Calculator();
    private final Random random = new Random();

    private int a;
    private int b;

    @BeforeEach
    @SuppressWarnings("checkstyle:MagicNumber")
    void setUp() {
        a = random.nextInt(1, 1000);
        b = random.nextInt(1, 1000);
    }

    @Test
    void testAdditionWithRandomInputs() {
        assertThat(calculator.add(a, b)).isEqualTo(a + b);
    }

    @Test
    void testSubtractionWithRandomInputs() {
        assertThat(calculator.subtract(a, b)).isEqualTo(a - b);
    }

    @Test
    void testMultiplicationWithRandomInputs() {
        assertThat(calculator.multiply(a, b)).isEqualTo(a * b);
    }

    @Test
    void testDivisionAndDivisionByZero() {
        assertThat(calculator.divide(a, b)).isEqualTo(a / b);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> calculator.divide(a, 0))
            .withMessage("Division by zero is not allowed.");
    }
}
