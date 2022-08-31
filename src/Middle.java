public class Middle extends Thread{
    private final int id;
    private final int level;
    private final Box startBox;
    private final Box endBox;
    private String message;

    public Middle(int id, int level, Box startBox, Box endBox) {
        this.id = id;
        this.level = level;
        this.startBox = startBox;
        this.endBox = endBox;
    }

    private void readBox(){
        String message = startBox.retrieve();
    }

    private void modifyAndSendMessage(){
        message += "T" + level + id;
        endBox.store(message);
    }

}
