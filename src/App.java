import java.util.Hashtable;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Hashtable<Integer, Box> boxes = new Hashtable<Integer, Box>();
        Hashtable<Integer, Middle> intermediates = new Hashtable<Integer, Middle>();

        Scanner input = new Scanner( System.in );

        System.out.println("Number of subsets to generate:");
        int n = input.nextInt();

        System.out.println("Size of intermediate boxes:");
        int sizeIntermediate = input.nextInt();

        System.out.println("Size of outer boxes:");
        int sizeOuter = input.nextInt();


        //testing
        Box buzonInicial = new Box(sizeOuter, 0);
        Initial producer = new Initial(buzonInicial, n);
        Box buzonFinal = new Box(sizeOuter, 1);
        Middle mitad = new Middle(1, 1, buzonInicial, buzonFinal);
        Final consumer = new Final(buzonFinal, n);

        producer.start();
        mitad.start();
        consumer.start();

        // structure definition

//        Box leftBox = new Box(sizeOuter);
//        Box rightBox = new Box(sizeOuter);
//        Initial initial = new Initial(leftBox, n);
//        Final finale = new Final(rightBox, n);
//
//        for (int i = 0; i < 6; i++) {
//            boxes.put(i, new Box(sizeIntermediate));
//        }
//
//        for (int i = 0; i < 9; i++) {
//            if (i/3 == 0) {
//                intermediates.put(i,new Middle(i,i%3, leftBox, boxes.get(i)));
//            } else if (i/3 == 1) {
//                intermediates.put(i,new Middle(i,i%3, boxes.get(i-3), boxes.get(i)));
//            } else if (i/3 == 2) {
//                intermediates.put(i,new Middle(i,i%3, boxes.get(i-3), rightBox));
//            }
//        }
//
//        //initialization
//        initial.start();
//        for (int i = 0; i < 9; i++) {
//            intermediates.get(i).start();
//        }
//        finale.start();

    }
}
