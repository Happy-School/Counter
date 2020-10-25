package com.example.counter;

public class TextCounter {
    public static int getCharsCount(String text){
        return text.length();
    }
    public static int getWordsCount(String text){
        text = text.replace("\n"," ");
        text = text.replace(","," ");
        text = text.replace("."," ");
        String[] textArray = text.split(" ");
        return textArray.length;
    }
}
