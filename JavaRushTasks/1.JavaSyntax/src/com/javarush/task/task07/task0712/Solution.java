package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
     List<String> list = new ArrayList<>();
     Scanner scan = new Scanner(System.in);
     for (int i = 0; i < 10; i++){
         list.add(scan.nextLine());//напишите тут ваш код
     }
     int numOfMin = 0;
     int numOfMax = 0;
     int minChars = list.get(0).length();
     int maxChars = list.get(0).length();
     for (int i = 0; i < list.size(); i++){
         if(minChars > list.get(i).length()){
             minChars = list.get(i).length();
             numOfMin = i;
         }
         if(maxChars < list.get(i).length()){
             maxChars = list.get(i).length();
             numOfMax = i;
         }
     }
    if (numOfMax < numOfMin) System.out.println(list.get(numOfMax));
    if (numOfMax > numOfMin) System.out.println(list.get(numOfMin));
    }
}
