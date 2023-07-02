package Services;

public class AnimalCounter implements AutoCloseable{
    static int counter;

    public static void setCounter(int count) {
        counter = count;
    }

    public static int getCounter() {
        return counter;
    }

    static void add() {
        counter++;
    }

    static void sub() {
        counter--;
    }

    @Override
    public void close() throws Exception {

    }
}
