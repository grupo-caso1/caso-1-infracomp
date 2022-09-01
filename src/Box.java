import java.util.ArrayList;

public class Box {
    private final ArrayList<String> buff; // where the messages are stored
    private  final int n; // buffer size

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
        /**boolean run = true;
        int i = 0;
        String message = null;
        while (run && i < buff.size()) {
            message = buff.get(i);
            if (message.equals("FIN")) {
                System.out.println(message);
                if (i == buff.size()-1){
                message = buff.remove(i);
                run = false;
                } else {
                    i++;
                }
            } else {
                message = buff.remove(i);
                run = false;

            }
        }**/
        String message = buff.remove(0);
        notifyAll();
        return message;
    }

    public synchronized boolean isFull (int nMessages) {

        if (buff.size() == nMessages){
            full = true;
        }

        return full;
    }
}
