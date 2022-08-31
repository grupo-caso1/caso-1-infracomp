import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );

        System.out.println("Número de subconjuntos a generar:");
        int nSubconjuntos = input.nextInt();

        System.out.println("Tamaño de buzones intermedios:");
        int sizeBuzonesIntermedios = input.nextInt();

        System.out.println("Tamaño de buzones extremos:");
        int sizeBuzonesExtremos = input.nextInt();

    }
}
