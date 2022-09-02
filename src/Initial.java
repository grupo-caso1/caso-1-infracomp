public class Initial extends Thread{
    private final Box initialBox;
    private final int nMessages;

    public Initial(Box initialBox, int nMessages) {
        this.initialBox = initialBox;
        this.nMessages = nMessages;
    }

    public void produce(){
        for (int i = 0; i < nMessages ; i++) {
            initialBox.store("M" + i);
            //System.out.println("Message " + i + " has been stored in initial");
        }
        initialBox.store("FIN");
        initialBox.store("FIN");
        initialBox.store("FIN");
    }

    @Override
    public void run() {
        while (initialBox.isFull()) Thread.yield();
        produce();
    }
}