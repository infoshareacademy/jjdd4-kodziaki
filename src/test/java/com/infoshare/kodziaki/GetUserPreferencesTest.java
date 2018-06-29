package com.infoshare.kodziaki;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetUserPreferencesTest {

    GetUserPreferences subject;

    @BeforeEach
    void setup() {
        subject = new GetUserPreferences();
    }

    @Test
    @DisplayName("Method should test if we capitalize first letter and decapitalize others")
    void processParameter() {
        // given
        String testInput = "gDANSK";
        String expected = "Gdansk";

        // when
        String actual = subject.processParameter(testInput);

        // then
        assertEquals(actual, expected);
    }

    @Test
    void isCorrectInput() {
        // given
        String input = "-1";

        // when
        boolean actual = subject.isCorrectInput(input);

        // then
        assertFalse(actual);
    }

    @Test
    @DisplayName("Should return true on empty string")
    void isCorrectInputEmptyString() {
        // given
        String input = "";

        // when
        boolean actual = subject.isCorrectInput(input);

        // then
        assertTrue(actual);
    }

}