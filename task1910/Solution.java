package task1910;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

/* 
Пунктуация
C:/Users/Shaco/Desktop/first.txt
C:/Users/Shaco/Desktop/second.txt
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(readerFileName.readLine()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(readerFileName.readLine()))) {

            long time = System.currentTimeMillis();

            /*
            //regex решение
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.replaceAll("\\p{Punct}", ""));
            }
             */
            //функциональное решение
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(delNoDigOrLet(line));
            }

            System.out.println(System.currentTimeMillis() - time);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    //код без использования regex почти в 2 раза быстрее
    private static String delNoDigOrLet(String str) {
        return str.chars()
                .filter(Character::isLetterOrDigit)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());
    }
}
