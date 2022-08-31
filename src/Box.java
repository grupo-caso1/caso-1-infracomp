import java.util.ArrayList;

public class Box {
    private ArrayList<String> buff; // where the messages are stored
    private int n; // buffer size

    public Box(int n) {
        this.buff = new ArrayList<String>();
        this.n = n;
    }

    public synchronized void store(String message){
        while(buff.size() == n){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        buff.add(message);
        this.notify();
    }

    public synchronized String retrieve(){
        while (buff.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String message = buff.remove(0);
        this.notify();
        return message;
    }

    public synchronized boolean isFull() {return buff.size() == n;};

    public synchronized boolean isEmpty() {return buff.size() == 0;};

    public synchronized String elements() {return buff.toString();};

    public synchronized int numElements() {return  buff.size();};

}
