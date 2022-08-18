package task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Считаем слово
C:/Users/Shaco/Desktop/first.txt
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(readerFileName.readLine()))) {

            int count = reader.lines()
                                .map(x -> x.split("\\bworld\\b"))
                                .mapToInt(s -> s.length)
                                .sum();
            System.out.println(count);

            /*
            String line;
            String[] words;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                words = line.split("world");
                count += words.length;
            }
            System.out.println(count);
             */
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
