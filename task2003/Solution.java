package task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
C:/Users/Shaco/Desktop/first.properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {

        Properties properties = new Properties();
        properties.putAll(runtimeStorage);
        properties.store(outputStream, null);
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);

        properties.forEach((key, value) -> runtimeStorage.put((String) key, (String) value));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        try(FileOutputStream fos = new FileOutputStream(fileName);
            FileInputStream fis = new FileInputStream(fileName)) {
            save(fos);
            load(fis);
        }
    }
}
