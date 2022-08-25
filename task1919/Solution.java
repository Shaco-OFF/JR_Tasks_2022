package task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
C:/Users/Shaco/Desktop/first.txt
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader readerData = new BufferedReader(new FileReader(args[0]))) {

            Map<String, Double> persons = new TreeMap<>();

            String[] elements;
            String secondName;
            double salary;

            String line;
            while ((line = readerData.readLine()) != null) {
                elements = line.split(" ");
                secondName = elements[0];
                salary = persons.containsKey(secondName) ? persons.get(secondName) + Double.parseDouble(elements[1])
                                                            :Double.parseDouble(elements[1]);
                persons.put(secondName, salary);
            }

            for (String key : persons.keySet()) {
                System.out.println(key + " " + persons.get(key));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
