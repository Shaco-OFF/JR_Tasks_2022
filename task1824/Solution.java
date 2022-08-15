package task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));

        String filename;
        while (true) {
            filename = readerFileName.readLine();
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            }catch (FileNotFoundException e) {
                System.out.println(filename);
                break;
            }
        }
    }
}
