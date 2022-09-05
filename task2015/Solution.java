package task2015;

import java.io.*;

/* 
Переопределение сериализации
*/

public class Solution implements Serializable, Runnable{
    private transient Thread runner;
    private int speed;

    public Solution(){}
    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("Переопределенный writeObject");
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("Переопределенный readObject");
        in.defaultReadObject();
        new Thread(this).start();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("2011.txt"));
        Solution solution = new Solution(1);
        //неявно вызывается переопределенный метод
        oos.writeObject(solution);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("2011.txt"));
        //неявно вызывается переопределенный метод
        Solution newSolution = (Solution) ois.readObject();

        System.out.println(solution.hashCode() == newSolution.hashCode());
        System.out.println(solution.equals(newSolution));
    }
}
