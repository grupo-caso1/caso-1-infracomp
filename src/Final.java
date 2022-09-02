public class Final extends Thread {
    private final Box finalBox;
    private final int nMessages;
    private String message = "";

    public Final(Box finalBox, int nMessages) {
        this.finalBox = finalBox;
        this.nMessages = nMessages;
    }

    public void consume(){

        while (!(finalBox.numElements() == nMessages +3)){
            Thread.yield();

        }
        for (int i = 0; i < nMessages +3; i++) {
            String tempMessage = finalBox.retrieve();
            if (!tempMessage.equals("FIN")) {
                message += tempMessage;
            }
        }
        System.out.println(message);
    }

    @Override
    public void run() {

        consume();

    }
}
