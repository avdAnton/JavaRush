package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer del = new StringTokenizer(query, delimiter);
        String[] resut = new String[del.countTokens()];
        int count = 0;
        while(del.hasMoreTokens()){
            resut[count] = del.nextToken();
            count++;
        }
        return resut;
    }
}
