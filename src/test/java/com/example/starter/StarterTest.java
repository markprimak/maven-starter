package com.example.starter;

import org.junit.jupiter.api.Test;

import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StarterTest {
    @Test
    @SuppressWarnings("checkstyle:MagicNumber")
    void calcBasicFunc() {
        var random = new Random();
        int a = random.nextInt() * 100 + 1;
        int b = random.nextInt() * 100 + 1;
        Calculator calculator = new Calculator();
        assertThat(calculator.subtract(a, b)).isEqualTo(a - b);
        assertThat(calculator.multiply(a, b)).isEqualTo(a * b);
        assertThat(calculator.divide(a, b)).isEqualTo(a / b);
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.divide(a, 0))
            .withMessage("Division by zero is not allowed.");
    }
}
