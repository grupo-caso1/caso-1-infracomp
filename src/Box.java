import java.util.ArrayList;

public class Box {
    private final ArrayList<String> buff; // where the messages are stored
    private final int n; // buffer size

    public Box(int n) {
        this.buff = new ArrayList< > ();
        this.n = n;
    }

    public synchronized void store(String message){
        while(buff.size() == n){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        buff.add(message);
        notify();
        }


    public synchronized String retrieve() {
        while (buff.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String message = buff.remove(0);
        notify();
        return message;
    }

    public synchronized boolean isFull () {

        return buff.size() == n;
    }

    public synchronized boolean isEmpty () {

        return buff.size() == 0;
    }

    public synchronized Integer numElements () {

        return buff.size();
    }


}
