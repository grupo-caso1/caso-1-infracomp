import java.util.concurrent.ThreadLocalRandom;

public class Middle extends Thread{
    private final int id;
    private final int level;
    private final Box startBox;
    private final Box endBox;

    public Middle(int id, int level, Box startBox, Box endBox) {
        this.id = id;
        this.level = level;
        this.startBox = startBox;
        this.endBox = endBox;
    }

    private String consume(){
        return startBox.retrieve();
    }

    private void modify(String received){
        String message = ""; //message has to be reset
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(50, 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        message += received + "T" + level + id;
        endBox.store(message);

    }

    @Override
    public void run() {
        boolean working = true;
        while (working) {
            String received = consume();
            if (received.equals("FIN")) {
                working = false;
                endBox.store(received);
            }
            else modify(received);
        }
    }
}
