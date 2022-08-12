package task1821;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
Встречаемость символов
C:/Users/Anton/Desktop/1.txt
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {

            Map<Integer, Integer> bytes = new TreeMap<>();
            int data;
            int count;

            while ((data = reader.read()) > -1) {
                count = bytes.containsKey(data) ? bytes.get(data) + 1 : 1;
                bytes.put(data, count);
            }
            bytes.forEach((x, y) -> System.out.println( (char) x.intValue() + " " + y));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}