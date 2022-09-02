public class Final extends Thread {
    private final Box finalBox;
    private String message = "";

    public Final(Box finalBox) {
        this.finalBox = finalBox;
    }

    @SuppressWarnings("StringConcatenationInLoop")
    public void consume(){
        int threeEnds = 3;
        while (threeEnds != 0) {
            while (finalBox.isEmpty()) {Thread.yield();}
            String retrieved = finalBox.retrieve();
            if (retrieved.equals("FIN")){threeEnds--;}
            if (threeEnds == 0){message += retrieved;}
            else {message += retrieved + ",";}
            }
        }


    @Override
    public void run() {
        consume();
        System.out.println(message);
    }
}
