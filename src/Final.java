public class Final extends Thread {
    private final Box finalBox;
    private final int nMessages;
    private String message;

    public Final(Box finalBox, int nMessages) {
        this.finalBox = finalBox;
        this.nMessages = nMessages;
    }

    public void consume(){
        for (int i = 0; i < nMessages; i++) {
            finalBox.retrieve();
        }
    }

    @Override
    public void run() {
        consume();
    }
}
