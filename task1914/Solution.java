package task1914;

import jdk.jshell.JShell;
import javax.script.ScriptException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws ScriptException {
        long time = System.currentTimeMillis();

        PrintStream defaultPrintStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String inputStr = outputStream.toString();
        String result = inputStr.replaceAll("[ =]", "");
        System.setOut(defaultPrintStream);

        try(JShell js = JShell.create()) {

            js.onSnippetEvent(snip -> {
                if (snip.status() == jdk.jshell.Snippet.Status.VALID) {
                    System.out.println(inputStr + snip.value());
                }
            });
            js.eval(js.sourceCodeAnalysis().analyzeCompletion(result).source());
        }
        System.out.println(System.currentTimeMillis() - time);

    }

    public static class TestString {
        public void printSomething() {
            System.out.print("900 / 100 = ");
        }
    }
}

