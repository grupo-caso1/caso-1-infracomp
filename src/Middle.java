import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Middle extends Thread{
    private final int id;
    private final int level;
    private final Box startBox;
    private final Box endBox;
    private String message;
    public static CyclicBarrier barrier = new CyclicBarrier(3);

    public Middle(int id, int level, Box startBox, Box endBox) {
        this.id = id;
        this.level = level;
        this.startBox = startBox;
        this.endBox = endBox;
    }

    private void readBox(){

        message = startBox.retrieve();
        modifyAndSendMessage();
    }

    private void modifyAndSendMessage(){

        if (message.equals("FIN")){
            try {
                barrier.await();
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
            endBox.store(message);

        } else {
            message += "T" + level + id;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            endBox.store(message);
            readBox();
        }

    }

    @Override
    public void run() {

        readBox();

    }
}
