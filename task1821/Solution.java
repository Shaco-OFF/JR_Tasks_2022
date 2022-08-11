package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(readerFileName.readLine()))) {

            List<Integer> bytes = new ArrayList<>();
            int data;

            while ((data = reader.read()) > -1) {
                if (!bytes.contains(data)) {
                    bytes.add(data);
                }
            }
            Collections.sort(bytes);
            bytes.stream().collect(Collectors.joining(" "));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
