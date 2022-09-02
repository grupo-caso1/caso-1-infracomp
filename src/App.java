import java.util.Hashtable;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Hashtable<Integer, Box> boxes = new Hashtable<>();
        Hashtable<Integer, Middle> intermediates = new Hashtable<>();

        Scanner input = new Scanner( System.in );

        System.out.println("Number of subsets to generate:");
        int n = input.nextInt();

        System.out.println("Size of intermediate boxes:");
        int sizeIntermediate = input.nextInt();

        System.out.println("Size of outer boxes:");
        int sizeOuter = input.nextInt();

        //structure

        Box leftBox = new Box(sizeOuter);
        Box rightBox = new Box(sizeOuter);
        for (int i = 0; i < 6; i++) {
            boxes.put(i, new Box(sizeIntermediate));
        }

        Initial initial = new Initial(leftBox, n);
        Final finale = new Final(rightBox);
        for (int i = 0; i < 9; i++) {
            if (i/3 == 0) {
                intermediates.put(i,new Middle(i,i%3, leftBox, boxes.get(i)));
            } else if (i/3 == 1) {
                intermediates.put(i,new Middle(i,i%3, boxes.get(i-3), boxes.get(i)));
            } else if (i/3 == 2) {
                intermediates.put(i,new Middle(i,i%3, boxes.get(i-3), rightBox));
            }
        }

        //initialization

        initial.start();
        for (int i = 0; i < 9; i++) {
            intermediates.get(i).start();
        }
        finale.start();

    }
}
