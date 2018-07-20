package com.company;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PalindromeFinder {
    private final static String ONLY_EN_RU_WORDS_REGEX = "[a-zа-яё]+";

    private String inputString;
    private String palindrome;
    private ArrayList<String> words;
    private String wordsExtractPattern = ONLY_EN_RU_WORDS_REGEX;

    PalindromeFinder(String inputString){
        this.inputString = inputString;
        this.palindrome = new String();
        this.words = new ArrayList<>();
    }

    private boolean extractWords(){
        if (inputString.isEmpty()) {
            return false;
        }

        inputString = inputString.toLowerCase();

        Pattern pattern = Pattern.compile(wordsExtractPattern);
        Matcher matcher = pattern.matcher(inputString);

        while(matcher.find()){
            words.add(matcher.group());
        }

        return true;
    }


    private void concat(StringBuilder sb, int fromWord, int toWord){
        for(int i = fromWord; i <= toWord; i++){
            sb.append(words.get(i));
        }
    }

    private boolean isPalindromePossible(String firstWord, String lastWord){
        if (firstWord.isEmpty() || lastWord.isEmpty()) {
            return false;
        }

        char firstWordChar =  firstWord.charAt(0);
        char lastWordChar = lastWord.charAt(lastWord.length() - 1);

        if (firstWordChar == lastWordChar) {
            return true;
        }

        return false;
    }

    public boolean extractPalindrome(){
        if (!extractWords()){
            return false;
        }

        int endOfText = words.size() - 1;
        int startWordPointer = 0;
        int endWordPointer = endOfText;
        int endWordPointerOffset = 0;
        boolean found = false;

        StringBuilder originalString = new StringBuilder();

        do {
            startWordPointer = 0;
            endWordPointer = endWordPointer - endWordPointerOffset;

            while(endWordPointer <= endOfText){
                String firstWord = words.get(startWordPointer);
                String lastWord = words.get(endWordPointer);

                if (isPalindromePossible(firstWord, lastWord)){
                    concat(originalString, startWordPointer, endWordPointer);

                    StringBuilder reversedString = new StringBuilder(originalString).reverse();

                    if (originalString.toString().equals(reversedString.toString())) {
                        palindrome = originalString.toString();
                        found = true;
                        break;
                    }
                }

                startWordPointer++;
                endWordPointer++;
                originalString.setLength(0);
            }

            if (found){
                break;
            }

            endWordPointerOffset++;
        } while(startWordPointer != endOfText + 1);

        return found;
    }

    public void setInputString(String inputString) {
        this.inputString = new String(inputString).toLowerCase();
    }

    public String getPalindrome() {
        return palindrome;
    }
}