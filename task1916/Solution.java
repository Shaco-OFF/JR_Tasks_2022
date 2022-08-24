package task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
C:/Users/Shaco/Desktop/first.txt
C:/Users/Shaco/Desktop/second.txt
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) {
        try(BufferedReader rdFileName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader1 = new BufferedReader(new FileReader(rdFileName.readLine()));
            BufferedReader reader2 = new BufferedReader(new FileReader(rdFileName.readLine()))) {

            String line1;
            String line2;

            while (reader1.ready() || reader2.ready()) {
                reader1.mark(1000);
                reader2.mark(1000);

                line1 = reader1.readLine();
                line2 = reader2.readLine();

                if (line1.equals(line2)) {
                    lines.add(new LineItem(Type.SAME, line1));
                }else {
                    if (line1.equals(reader2.readLine())) {
                        reader2.reset();
                        lines.add(new LineItem(Type.ADDED, reader2.readLine()));
                        reader1.reset();
                    }else {
                        lines.add(new LineItem(Type.REMOVED, line1));
                        reader2.reset();
                    }
                }
            }
            lines.forEach(x -> System.out.println(x.type + " " + x.line));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
