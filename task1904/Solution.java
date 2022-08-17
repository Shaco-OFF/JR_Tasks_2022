package task1904;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
И еще один адаптер
C:/Users/Shaco/Desktop/first.txt
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        File path = new File("C:/Users/Shaco/Desktop/first.txt");
        Scanner fileScanner = new Scanner(path);
        PersonScanner personScanner = new PersonScannerAdapter(fileScanner);
        Person person = personScanner.read();
        System.out.println(person.toString());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }

        @Override
        public Person read() throws IOException {

            String line = fileScanner.nextLine();
            String[] personData = line.split(" ");

            Date birthday = null;
            try {
                birthday = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH)
                        .parse(line.substring(line.length() - 10));
            }catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(personData[1], personData[2], personData[0], birthday);
        }
    }
}
