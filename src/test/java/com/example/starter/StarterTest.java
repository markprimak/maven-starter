package com.example.starter;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StarterTest {

    private final Calculator calculator = new Calculator();
    private final Random random = new Random();
    private final int a = random.nextInt(1, 1000);
    private final int b = random.nextInt(1, 1000);

    @Test
    void additionWithRandomInputs() {
        assertThat(calculator.add(a, b)).isEqualTo(a + b);
        System.out.println("Calculator: Addition Test passed");
    }

    @Test
    void subtractionWithRandomInputs() {
        assertThat(calculator.subtract(a, b)).isEqualTo(a - b);
        System.out.println("Calculator: Subtraction Test passed");
    }

    @Test
    void multiplicationWithRandomInputs() {
        assertThat(calculator.multiply(a, b)).isEqualTo(a * b);
        System.out.println("Calculator: Multiplication Test passed");
    }

    @Test
    void divisionAndDivisionByZero() {
        assertThat(calculator.divide(a, b)).isEqualTo(a / b);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> calculator.divide(a, 0))
            .withMessage("Division by zero is not allowed.");
        System.out.println("Calculator: Division Test passed");
    }
}
