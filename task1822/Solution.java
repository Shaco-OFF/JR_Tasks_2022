package task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
C:/Users/Shaco/Desktop/first.txt
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(readerFileName.readLine()))) {

            int id = Integer.parseInt(args[0]);

            reader.lines()
                    .filter(s -> Integer.parseInt(s.substring(0, s.indexOf(" "))) == id)
                    .forEach(System.out::println);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
