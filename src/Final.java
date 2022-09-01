public class Final extends Thread {
    private final Box finalBox;
    private final int nMessages;
    private String message = "";

    public Final(Box finalBox, int nMessages) {
        this.finalBox = finalBox;
        this.nMessages = nMessages;
    }

    public void consume(){

        while (!finalBox.isFull(nMessages)){
            Thread.yield();
        }
        for (int i = 0; i < nMessages; i++) {
            /**String tempMessage = finalBox.retrieve();
            if (!tempMessage.equals("FIN")) {
                message += tempMessage;
            }**/
            message += finalBox.retrieve();
        }
        System.out.println(message);
    }

    @Override
    public void run() {

        consume();
    }
}
