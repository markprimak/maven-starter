package com.example.starter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StarterTest {
    @Test
    @SuppressWarnings("checkstyle:MagicNumber")
    void calcBasicFunc() {
        int a = (int) (Math.random() * 100) + 1;
        int b = (int) (Math.random() * 100) + 1;
        Calculator calculator = new Calculator();
        assertThat(calculator.add(a, b)).isEqualTo(a + b);
        assertThat(calculator.subtract(a, b)).isEqualTo(a - b);
        assertThat(calculator.multiply(a, b)).isEqualTo(a * b);
        assertThat(calculator.divide(a, b)).isEqualTo(a / b);
        assertThatThrownBy(() -> calculator.divide(a, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Division by zero is not allowed.");
    }
}
