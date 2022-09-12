package EnumSingleton;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Singleton singleton = Singleton.INSTANCE;

        serialize(singleton);
        Singleton singleton1 = deserialize("2011.txt");

        System.out.println(singleton.hashCode() == singleton1.hashCode());
        System.out.println(singleton.equals(singleton1));
    }

    public static void serialize(Singleton INSTANCE) throws Exception {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("2011.txt"));
        oos.writeObject(INSTANCE);
        oos.close();
    }

    public static Singleton deserialize(String string) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(string));

        Singleton singleton1 = (Singleton) ois.readObject();
        System.out.println(singleton1.getString());

        return singleton1;
    }
}
