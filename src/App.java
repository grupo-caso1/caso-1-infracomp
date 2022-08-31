import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );

        System.out.println("Number of subsets to generate:");
        int nSubconjuntos = input.nextInt();

        System.out.println("Size of intermediate boxes:");
        int sizeBuzonesIntermedios = input.nextInt();

        System.out.println("Size of outer boxes:");
        int sizeBuzonesExtremos = input.nextInt();

        //testing
        Box buzonInicial = new Box(sizeBuzonesExtremos);
        Initial producer = new Initial(buzonInicial, nSubconjuntos);
        Box buzonFinal = new Box(sizeBuzonesExtremos);
        Middle mitad = new Middle(1, 1, buzonInicial, buzonFinal);
        Final consumer = new Final(buzonFinal, nSubconjuntos);

        producer.start();
        mitad.start();
        consumer.start();


    }
}
