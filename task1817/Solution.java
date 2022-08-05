package task1817;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            int data;
            int countGap = 0;
            int countChar = 0;
            while ((data = reader.read()) != -1) {
                if ((char)data == ' ') {
                    countGap++;
                }
                countChar++;
            }
            double ratio = (double) countGap / countChar * 100;
            System.out.printf("%.2f", ratio);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
