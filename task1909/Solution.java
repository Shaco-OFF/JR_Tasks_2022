package task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
C:/Users/Shaco/Desktop/first.txt
C:/Users/Shaco/Desktop/second.txt
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(readerFileName.readLine()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(readerFileName.readLine()))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.replaceAll("\\.", "!"));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
