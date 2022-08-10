package task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Объединение файлов
C:/Users/Shaco/Desktop/first.txt
C:/Users/Shaco/Desktop/second.txt
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();

        List<Integer> listBytes = new ArrayList<>();
        int data;

        try(BufferedReader readerFirst = new BufferedReader(new FileReader(firstFileName));
            BufferedReader readerSecond = new BufferedReader(new FileReader(secondFileName))) {

            while (readerSecond.ready()) {
                data = readerSecond.read();
                listBytes.add(data);
            }
            while (readerFirst.ready()) {
                data = readerFirst.read();
                listBytes.add(data);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(firstFileName))) {
            for (Integer b : listBytes) {
                writer.write(b);
            }
        }
    }
}
