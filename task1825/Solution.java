package task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
C:/Users/Shaco/Desktop/1825/Lion.avi.part3.txt
C:/Users/Shaco/Desktop/1825/Lion.avi.part1.txt
C:/Users/Shaco/Desktop/1825/Lion.avi.part2.txt
end
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> fileNames = new ArrayList<>();

        try(BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName;
            while (!(fileName = readerFileName.readLine()).equals("end")) {
                fileNames.add(fileName);
            }
        }
        Collections.sort(fileNames);
        String tmp = fileNames.get(1);
        String result = tmp.substring(0, tmp.lastIndexOf(".part"));


        try(BufferedWriter writer = new BufferedWriter(new FileWriter(result))) {
            for (String fileName : fileNames) {
                try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                    while (reader.ready()) {
                        writer.write(reader.read());
                    }
                }
            }
        }
    }
}
