package com.company;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class IntegersFromString {
        private final static String INT_FROM_STRING_REGEX = "(^|[a-zа-яё]|^\\,.|\\s)\\d+(?=$|[a-zа-яё]|\\s|\\,\\s|\\.\\s)";
        private final static String INT_ONLY_REGEX = "[^\\d]";
       
        private String inputString;
        private  ArrayList<Integer> integers;
        private int sum;
     
        public IntegersFromString(String inputString){
            this.inputString = inputString;
            this.integers = new ArrayList<>();
        }

        public boolean extractIntegers(){
            if (inputString.isEmpty()){
                return false;
            }
            
            inputString = inputString.toLowerCase();
            Pattern pattern = Pattern.compile(INT_FROM_STRING_REGEX);
            Matcher matcher = pattern.matcher(inputString);

            while(matcher.find()){
                int parsed = Integer.parseInt(matcher.group().replaceAll(INT_ONLY_REGEX, ""));
                integers.add(parsed);
            }
            
            return true;
        }

        public void calculateSum(){
            for (Integer integer : integers){
                sum+=integer;
            }
        }

        public void setInputString(String inputString) {
            this.inputString = new String(inputString).toLowerCase();
        }

        public ArrayList<Integer> getIntegers() {
            return integers;
        }

        public int getSum() {
            return sum;
        }
}
