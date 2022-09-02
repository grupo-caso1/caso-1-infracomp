public class Final extends Thread {
    private Box finalBox;
    private int nMessages;
    private String message;

    public Final(Box finalBox, int nMessages) {
        this.finalBox = finalBox;
        this.nMessages = nMessages;
    }

    public void consume(){
        for (int i = 0; i < nMessages; i++) {
            String message = finalBox.retrieve();
        }
    }

    @Override
    public void run() {
        while (finalBox.isEmpty()) {Thread.yield();}
        consume();
        System.out.println(message);
    }
}
