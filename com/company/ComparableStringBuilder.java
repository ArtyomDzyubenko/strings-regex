package com.company;

public class ComparableStringBuilder implements Comparable {
    private StringBuilder sb = new StringBuilder();

    public ComparableStringBuilder(){

    }

    public ComparableStringBuilder(StringBuilder sb){
        this.sb = sb;
    }


    public ComparableStringBuilder append(char c) {
        sb.append(c);
        return this;
    }

    public ComparableStringBuilder append(String s) {
        sb.append(s);
        return this;
    }

    public ComparableStringBuilder setLength(int l){
        sb.setLength(l);
        return this;
    }

    @Override
    public int compareTo(Object o) {
        ComparableStringBuilder s = (ComparableStringBuilder)o;
        return sb.toString().compareTo(s.toString());
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
