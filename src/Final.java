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
            String message = finalBox.retrieve(); // no está sacando porque piensa que no hay nada y se pone a esperar!!
            System.out.println(message);
        }
    }

    @Override
    public void run() {
        if (finalBox.isEmpty()) {Thread.yield();}
        consume();
    }
}
