package com.example.pd2.utils;

import org.junit.Test;
import static org.junit.Assert.*;

public class TextCounterUnitTest {
    @Test
    public void testGetCharsCount() {
        assertEquals(5, TextCounter.getCharsCount("12345"));
        assertEquals(0, TextCounter.getCharsCount(""));
        assertEquals(6, TextCounter.getCharsCount("Hello "));
    }

    @Test
    public void testGetWordsCount() {
        assertEquals(3, TextCounter.getWordsCount("Hello world here"));
        assertEquals(1, TextCounter.getWordsCount("Hello"));
        assertEquals(3, TextCounter.getWordsCount("  Hello   world  here  "));
    }

    @Test
    public void testGetSentencesCount() {
        assertEquals(1, TextCounter.getSentencesCount("Hello world."));
        assertEquals(3, TextCounter.getSentencesCount("Hello world. How are you? I am fine!"));
        assertEquals(0, TextCounter.getSentencesCount("No punctuation"));
    }

    @Test
    public void testGetNumbersCount() {
        assertEquals(2, TextCounter.getNumbersCount("I have 2 apples and 3.5 oranges."));
        assertEquals(0, TextCounter.getNumbersCount("No numbers here"));
        assertEquals(3, TextCounter.getNumbersCount("-1, 200, +30"));
    }
}
