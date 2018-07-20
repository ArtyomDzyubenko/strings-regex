package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class StringDecompressor {
    private String inputString;
    private char[] inputStringCharArray;
    private int stringNumberInOriginalTable; 
    private String decompressedString;
    ArrayList<ComparableStringBuilder> permutationTable = new ArrayList<>();

    public StringDecompressor(String inputString, int stringNumberInOriginalTable) {
        this.inputString = inputString;
        this.inputStringCharArray = new char[]{};
        this.stringNumberInOriginalTable = stringNumberInOriginalTable;
        this.decompressedString = new String();
        initialization();
    }

    private boolean initialization(){
        if (inputString.isEmpty()){
            return true;
        }

        inputStringCharArray = inputString.toCharArray();

        for(int i = 0; i < inputStringCharArray.length; i++){
            permutationTable.add(new ComparableStringBuilder());
        }

        return false;
    }

    private void add(){
        for(int i = 0; i < inputStringCharArray.length; i++) {
            ComparableStringBuilder s = permutationTable.get(i);
            String tmp = s.toString();
            s.setLength(0).append(inputStringCharArray[i]).append(tmp);
        }
    }

    private void sort() {
        Collections.sort(permutationTable);
    }

    public boolean decompress(){
        if (inputString.isEmpty()) {
            return false;
        }

        for(int i = 0; i < inputStringCharArray.length; i++ ) {
            add();
            sort();
        }

        decompressedString = permutationTable.get(stringNumberInOriginalTable - 1).toString();
        return true;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public void setStringNumberInOriginalTable(int stringNumberInOriginalTable) {
        this.stringNumberInOriginalTable = stringNumberInOriginalTable;
    }

    public String getDecompressedString() {
        return decompressedString;
    }
}
