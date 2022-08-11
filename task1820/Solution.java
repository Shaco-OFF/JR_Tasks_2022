package task1820;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

/* 
Округление чисел
C:/Users/Shaco/Desktop/first.txt
C:/Users/Shaco/Desktop/second.txt
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));

        String firstFileName = readerFileName.readLine();
        String secondFileName = readerFileName.readLine();

        readerFileName.close();

        try(BufferedReader reader = new BufferedReader(new FileReader(firstFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(secondFileName))) {

            String numbers = reader.lines().flatMap(x -> Arrays.stream(x.split(" ")))
                            .map(x -> String.format("%s", Math.round(Double.parseDouble(x))))
                            .collect(Collectors.joining(" "));

            writer.write(numbers);

        }
    }
}
