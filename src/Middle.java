public class Middle extends Thread{
    private int id;
    private int level;
    private Box startBox;
    private Box endBox;
    private String message = "";

    public Middle(int id, int level, Box startBox, Box endBox) {
        this.id = id;
        this.level = level;
        this.startBox = startBox;
        this.endBox = endBox;
    }

    private void consume(){
        message += startBox.retrieve();
    }

    private void modifyAndSendMessage(){
        message += "T" + level + id;
        endBox.store(message);
    }

    @Override
    public void run() {
        try {
            sleep(1000); //sleeps thread for everything to work correctly
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < startBox.numElements(); i++) {
            consume();
            modifyAndSendMessage();
        }
    }
}
