public class Initial extends Thread{
    private Box initialBox;
    private int nMessages;

    public Initial(Box initialBox, int nMessages) {
        this.initialBox = initialBox;
        this.nMessages = nMessages;
    }

    public void produce(){
        for (int i = 0; i < nMessages ; i++) {
            initialBox.store("M" + i);
        }
    }

    @Override
    public void run() {
        while (initialBox.isFull()) Thread.yield();
        produce();
    }
}

