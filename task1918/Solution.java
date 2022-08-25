package task1918;

import org.jsoup.*;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* 
Знакомство с тегами
C:/Users/Shaco/Desktop/first.txt
*/

public class Solution {
    public static void main(String[] args) {

        try(BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader readerFileData = new BufferedReader(new FileReader(readerFileName.readLine()))) {

            String line;
            StringBuilder html = new StringBuilder();
            while ((line = readerFileData.readLine()) != null) {
                html.append(line);
            }
            Document document = Jsoup.parse(html.toString(), "", Parser.xmlParser());
            Elements elements = document.select(args[0]);

            for (Element element : elements) {
                System.out.println(element);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
