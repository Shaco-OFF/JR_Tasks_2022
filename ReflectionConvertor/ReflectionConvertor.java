package ReflectionConvertor;

public class ReflectionConvertor {
    @FunctionalInterface
    public interface Converter<T, N> {
        N convert(T t);
    }
    public static void main(String[] args) {
        Converter<Integer, Double> converter = x -> Double.parseDouble(String.valueOf(x));
        Double doubleNum  = converter.convert(2);
        System.out.printf("%.2f", doubleNum);
    }
}
