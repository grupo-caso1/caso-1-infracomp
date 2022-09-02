import java.util.ArrayList;

public class Box {
    private final ArrayList<String> buff; // where the messages are stored
    private final int n; // buffer size

    boolean full = false;

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
        notifyAll();
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
        notifyAll();
        return message;
    }

    public synchronized boolean isFull () {

        if (buff.size() == n){
            full = true;
        }
        return full;
    }

    public synchronized boolean processEnded (int nMessages) {

        if (buff.size() == nMessages){
            full = true;
        }
        return full;
    }
}
