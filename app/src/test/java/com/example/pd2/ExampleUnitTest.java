package com.example.pd2;

import org.junit.Test;

import static org.junit.Assert.*;
import com.example.pd2.utils.TextCounter;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

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
    public void testGetWordsCount_Bug() {
         // This test is expected to fail with the current implementation
         assertEquals(0, TextCounter.getWordsCount(""));
         assertEquals(0, TextCounter.getWordsCount("   "));
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
