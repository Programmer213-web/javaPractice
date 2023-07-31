class Table {
    synchronized void printSomething(int n) {
        for(int i = 1; i < 6; i++) {
            System.out.println(n * i);
        }

        try {
            Thread.sleep(400);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

class firstThread extends Thread {
    public Table t;

    public firstThread(Table in) {
        this.t = in;
    }

    @Override
    public void run() {
        this.t.printSomething(5);
    }
}

class secondThread extends Thread {
    public Table t;

    public secondThread(Table in) {
        this.t = in;
    }

    @Override
    public void run() {
        this.t.printSomething(50);
    }
}

public class multi_threading_1 {
    public static void main(String[] args) {
        Table t = new Table();
        firstThread f = new firstThread(t);
        secondThread s = new secondThread(t);

        f.start();
        s.start();
    }
}