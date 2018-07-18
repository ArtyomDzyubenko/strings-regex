package com.company;

public class Main {
    public static void main(String[] args) {
        //TASK: A:24 B:14 C:13

        //TASK 24
        System.out.println("#TASK 24#");
        String testText = "Lorem ipsum dolor sit 1amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +                       // 1
                "           ut labore10 et dolore magna aliqua. 15.1Ut enim ad minim veniam, quis nostrud А роза упала на лапу Азора" +         // 10, 15.1 + palindrome(26)
                "           exercitation ullamco " +
                "           laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehen derit  in volup20tate " +        // 20
                "           velit esse Madam, I’m Adam cillum  d13.4olore eu fugiat nulla pariatur. Excepteur sint " +                          // 13,4 + palindrome(15)
                "           occaecat 1, 2, 3 cupidatat non proident, " +                                                                        // 1, 2, 3
                "           sunt in culpa qui offici4a deserunt mollit anim id est laborum. 5 1,3";                                             // 4, 5*/


        IntegersFromString ifs = new IntegersFromString(testText);
        ifs.extractIntegers();
        ifs.calculateSum();

        for (Integer integer : ifs.getIntegers()) {
            System.out.println(integer);
        }

        System.out.println("sum: " + ifs.getSum());

        System.out.println();

        ////////////////////////////////////

        //TASK 14
        System.out.println("#TASK 14#");
        Palindrome palindrome = new Palindrome(testText);
        palindrome.extractPalindrome();
        System.out.println(palindrome.getPalindrome());

        System.out.println();

        ////////////////////////////////////

        //TASK 13
        System.out.println("#TASK 13#");
        String test = "VJAA";

        StringDecompression sd = new StringDecompression(test, 3);
        sd.decompress();

        System.out.println(sd.getDecompressedString());

        System.out.println();

        ////////////////////////////////////
    }
}
