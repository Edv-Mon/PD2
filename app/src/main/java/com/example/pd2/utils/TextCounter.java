package com.example.pd2.utils;

public class TextCounter {
    public static int getCharsCount(String userInput){
        return userInput.length();
    }
    public static int getWordsCount(String userInput){
        String[] words = userInput.trim().split("\\s+");
        return words.length;
    }
}

