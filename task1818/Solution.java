package task1818;

import java.io.*;

/* 
Два в одном
C:/Users/Shaco/Desktop/first.txt
C:/Users/Shaco/Desktop/second.txt
C:/Users/Shaco/Desktop/third.txt
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName.readLine(), true));
            BufferedReader readerFirst = new BufferedReader(new FileReader(fileName.readLine()));
            BufferedReader readerSecond = new BufferedReader(new FileReader(fileName.readLine()))) {

            String line;
            while ((line = readerFirst.readLine()) != null) {
                writer.append("\n").write(line);
            }

            while ((line = readerSecond.readLine()) != null) {
                writer.append("\n").write(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
