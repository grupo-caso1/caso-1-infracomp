public class Final extends Thread {
    private final Box finalBox;
    private final int nMessages;
    private String message = "";
    private int readMessage = 0;

    public Final(Box finalBox, int nMessages) {
        this.finalBox = finalBox;
        this.nMessages = nMessages;
    }

    @SuppressWarnings("StringConcatenationInLoop")
    public void consume(){


        while (readMessage < nMessages +3) {
            while (finalBox.isEmpty()) {
                Thread.yield();
            }
            for (int i = 0; i < finalBox.numElements(); i++) {
                String tempMessage = finalBox.retrieve();
                message += "\n" + tempMessage;
                readMessage++;
            }
        }
        System.out.println(message);
    }

    @Override
    public void run() {

        consume();

    }
}
