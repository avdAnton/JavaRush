package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int[] houseArr = new int[15];
        int countOf1 = 0;
        int countOf2 = 0;
        for(int i = 0; i < houseArr.length; i++){
            houseArr[i] = Integer.parseInt(scan.nextLine());
            if (i%2 != 0){
                countOf1 += houseArr[i];
            }else{
                countOf2 +=houseArr[i];
            }
        }
        if (countOf1 > countOf2){
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
        if (countOf1 < countOf2){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }


    }
}
