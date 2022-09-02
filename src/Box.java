import java.util.ArrayList;

public class Box {
    private ArrayList<String> buff; // where the messages are stored
    private int n; // buffer size
    private int id;

    public Box(int n, int id) {
        this.buff = new ArrayList<String>();
        this.n = n;
        this.id = id;
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
        System.out.println("Box " + this.id + " has " + buff.size() + " elements: " + buff.toString());
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

    public synchronized int numElements() {return  buff.size();};

}
