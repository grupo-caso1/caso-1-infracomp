public class Initial extends Thread{
    private final Box initialBox;
    private final int nMessages;

    public Initial(Box initialBox, int nMessages) {
        this.initialBox = initialBox;
        this.nMessages = nMessages;
    }

    public void produce(){

        for (int i = 0; i < nMessages ; i++) {

            while (initialBox.isFull()){
                Thread.yield();
            }
            initialBox.store("M" + i);
        }

        for (int i = 0; i < 3 ; i++) {

            while (initialBox.isFull()){
                Thread.yield();
            }
            initialBox.store("FIN");
        }
    }

    @Override
    public void run() {

        produce();

    }
}

