package task1923;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* 
Слова с цифрами
C:/Users/Shaco/Desktop/first.txt
C:/Users/Shaco/Desktop/second.txt
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {

            String result = reader.lines().flatMap(line -> Arrays.stream(line.split(" ")))
                                            .filter(splitStr -> Pattern.compile("[0-9]+").matcher(splitStr).find())
                                            .collect(Collectors.joining(" "));
            writer.write(result);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
