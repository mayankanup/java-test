package com.example;

public class StringEncoder {

    public void test() {
        char [][] wordList= {
            {'a','a','b','b','c','c','c'},
            {'a'},
            {'a','b'},
            {'a','b','b','b','b','b','b','b','b','b','b','b','b'}
        };

        for(int i=0; i< wordList.length; i++){
            System.out.println(Util.toString(wordList[i])+ " - > " + compress(wordList[i]) + " : "+ Util.toString(wordList[i]));
        }
    }

    public int compress(char[] chars) {
        if(chars == null || chars.length==0) return 0;
        if(chars.length==1) return 1;
        int curCharCount = 1;
        int curCharIndex = 0;
        char curChar = chars[0];
        for(int i=1; i<chars.length; i++){
            if(chars[i]==curChar){
                curCharCount++;
            } else {
                curCharIndex = writeCharAndCount(chars, curChar, curCharCount, curCharIndex);
                curChar = chars[i];
                curCharCount = 1;
            }
            if(i==chars.length-1){
                curCharIndex = writeCharAndCount(chars, curChar, curCharCount, curCharIndex);
            }
        }
        if(curCharIndex<chars.length){
            for(int i=curCharIndex; i<chars.length; i++){
                chars[i]=' ';
            }
        }
        return curCharIndex;
    }
    
    private int writeCharAndCount(char [] chars, char curChar, int curCharCount, int curCharIndex){
        chars[curCharIndex] = curChar;
        curCharIndex +=1;
        if(curCharCount > 1){
            String num = new String(""+curCharCount);
            char [] numchars = num.toCharArray();
            for(int j=0; j<numchars.length;j++, curCharIndex++){
                chars[curCharIndex]=numchars[j];
            }
        }
        return curCharIndex;
    }
}


/*
 * Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.

 

Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
Example 2:

Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.
Example 3:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 */