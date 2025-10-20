package com.example.pd2.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCounter {
    public static int getCharsCount(String userInput){
        return userInput.length();
    }
    public static int getWordsCount(String userInput){
        String[] words = userInput.trim().split("\\s+");
        return words.length;
    }
    public static int getSentencesCount(String userInput){
        Pattern pattern = Pattern.compile("\\s*[^.!?]*[.!?]");
        Matcher matcher = pattern.matcher(userInput);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}

