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

        Box box1 = new Box(sizeBuzonesExtremos);
        Box box2 = new Box(sizeBuzonesIntermedios);
        Box box3 = new Box(sizeBuzonesIntermedios);
        Box box4 = new Box(sizeBuzonesExtremos);

        Initial initialProcess = new Initial(box1,nSubconjuntos);
        Middle firstLevelProcess1 = new Middle(1,1,box1,box2);
        Middle firstLevelProcess2 = new Middle(2,1,box1,box2);
        Middle firstLevelProcess3 = new Middle(3,1,box1,box2);
        Middle secondLevelProcess1 = new Middle(1,2,box2,box3);
        Middle secondLevelProcess2 = new Middle(2,2,box2,box3);
        Middle secondLevelProcess3 = new Middle(3,2,box2,box3);
        Middle thirdLevelProcess1 = new Middle(1,3,box3,box4);
        Middle thirdLevelProcess2 = new Middle(2,3,box3,box4);
        Middle thirdLevelProcess3 = new Middle(3,3,box3,box4);
        Final finalProcess = new Final(box4,nSubconjuntos);
        initialProcess.start();
        firstLevelProcess1.start();
        firstLevelProcess2.start();
        firstLevelProcess3.start();
        secondLevelProcess1.start();
        secondLevelProcess2.start();
        secondLevelProcess3.start();
        thirdLevelProcess1.start();
        thirdLevelProcess2.start();
        thirdLevelProcess3.start();
        finalProcess.start();
    }
}
