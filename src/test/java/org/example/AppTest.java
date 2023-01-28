package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void test() {
        assertThat(true).isTrue();
    }

    @Test
    void addTwoNumbersReturnsSum() {
        var result = App.add(1,1);

        assertEquals(2, result);
    }

    @Test
    void givenOddNumberOddShouldReturnTrue() {
        assertTrue(App.odd(3));
    }

    @Test
    void givenEvenNumberOddShouldReturnFalse() {
        assertFalse(App.odd(2));
    }
}