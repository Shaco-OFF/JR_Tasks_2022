package task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
C:/Users/Shaco/Desktop/first.txt
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {

            Map<String, Double> persons = new TreeMap<>();

            String secondName;
            double salary;

            String line;
            String[] elements;

            while ((line = reader.readLine()) != null) {
                elements = line.split(" ");
                secondName = elements[0];
                salary = persons.containsKey(secondName) ? persons.get(secondName) + Double.parseDouble(elements[1])
                                                            : Double.parseDouble(elements[1]);
                persons.put(secondName, salary);
            }

            persons.entrySet()
                    .stream()
                    .filter(x -> x.getValue().equals(Collections.max(persons.values())))
                    .map(Map.Entry::getKey)
                    .forEach(System.out::println);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
