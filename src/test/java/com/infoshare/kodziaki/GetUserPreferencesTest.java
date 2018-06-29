package com.infoshare.kodziaki;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetUserPreferencesTest {

    @Test
    void processParameter() {
        // given
        GetUserPreferences subject = new GetUserPreferences();
        String testInput = "gDANSK";
        String expected = "Gdansk";

        // when
        String actual = subject.processParameter(testInput);

        // then
        assertEquals(actual, expected);
    }
}