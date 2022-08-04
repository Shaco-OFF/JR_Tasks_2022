package task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Прайсы 2
C:/Users/Shaco/Desktop/first.txt
*/

public class Solution {
    public static String path;

    static {
        try {
            path = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> products = new ArrayList<>();

    public static class Product {
        String id;
        String name;
        String price;
        String quantity;

        public Product(String id, String name, String price, String quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
        public static void updateProduct(Product product) throws NullPointerException {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                String id;
                while (reader.ready()) {
                    line = reader.readLine();
                    id = line.substring(0, 8).trim();

                    if (product.id.equals(id)) {
                        products.add(product);
                    } else {
                        products.add(getProduct(line));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static Product getProduct(String line) {
            String id = line.substring(0, 8).trim();
            String name = line.substring(8, 38).trim();
            String price = line.substring(38, 46).trim();
            String quantity = line.substring(46, 50).trim();
            return new Product(id, name, price, quantity);
        }
        @Override
        public String toString() {
            return String.format("%-8s%-30s%-8s%-4s", id, name, price, quantity);
        }

        public static void writeInFile(List<Product> products) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
                for (Product product : products) {
                    if (product != null) {
                        writer.write(product.toString());
                        writer.append("\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws NullPointerException {
        if (args.length != 0) {

            String flag = args[0];
            String id = String.format(Locale.ENGLISH, "%-8.8s", args[1]);


            Product currentProduct;
            switch (flag) {
                case "-u":
                    String name = String.format(Locale.ENGLISH, "%-30.30s", args[2]);
                    String price = String.format(Locale.ENGLISH, "%-8.8s", args[3]);
                    String quantity = String.format(Locale.ENGLISH, "%-4.4s", args[4]);

                    currentProduct = new Product(id, name, price, quantity);
                    Product.updateProduct(currentProduct);
                    Product.writeInFile(products);
                    break;
                case "-d":
                    Product.updateProduct(null);
                    Product.writeInFile(products);
                    break;
            }
        }
    }
}
