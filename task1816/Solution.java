package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
C:/Users/Shaco/Desktop/third.txt
*/

public class Solution {
    public static void main(String[] args) {

        int count = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            int data;

            while ((data = reader.read()) != -1) {
                if (Character.toString((char)data).matches("[a-zA-Z]")) {
                    count++;
                }
            }
            System.out.println(count);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
