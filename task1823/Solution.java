package task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
C:/Users/Shaco/Desktop/first.txt
C:/Users/Shaco/Desktop/second.txt
exit
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
        String filename;

        while (!(filename = readerFileName.readLine()).equals("exit")) {
            new ReadThread(filename);
        }
        readerFileName.close();

        System.out.println(resultMap.toString());
    }

    public static class ReadThread extends Thread {


        public ReadThread(String fileName) {
            super(fileName);
            start();
        }
        public void run() {
            Map<Integer, Integer> mapBytes = new HashMap<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(getName()))) {
                int data;
                int count;
                while ((data = reader.read()) > -1) {
                    count = mapBytes.containsKey(data) ? mapBytes.get(data) + 1 : 1;
                    mapBytes.put(data, count);
                }
                Integer resultKey = Collections.max(mapBytes.entrySet(), Map.Entry.comparingByValue()).getKey();

                resultMap.put(getName(), resultKey);

            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
