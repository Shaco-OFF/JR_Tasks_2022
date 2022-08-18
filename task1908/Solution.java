package task1908;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/* 
Выделяем числа
C:/Users/Shaco/Desktop/first.txt
C:/Users/Shaco/Desktop/second.txt
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String inputFile;
        String outputFile;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFile = reader.readLine();
            outputFile = reader.readLine();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            String[] subs;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                subs = line.split(" ");
                for (String sub : subs) {
                    if (isNumeric(sub)) {
                        result.append(sub).append(" ");
                    }
                }
            }
            writer.write(result.toString().trim());
        }
    }
    public static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
        }catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
