import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );

        System.out.println("Número de subconjuntos a generar:");
        int nSubconjuntos = input.nextInt();

        System.out.println("Tamaño de buzones intermedios:");
        int sizeBuzonesIntermedios = input.nextInt();

        System.out.println("Tamaño de buzones extremos:"); // Debe ser >= nSubconjuntos + 3
        int sizeBuzonesExtremos = input.nextInt();


        Box box1 = new Box(sizeBuzonesExtremos);
        Box box2 = new Box(sizeBuzonesIntermedios);
        Box box3 = new Box(sizeBuzonesIntermedios);
        Box box4 = new Box(sizeBuzonesIntermedios);
        Box box5 = new Box(sizeBuzonesIntermedios);
        Box box6 = new Box(sizeBuzonesIntermedios);
        Box box7 = new Box(sizeBuzonesIntermedios);
        Box box8 = new Box(sizeBuzonesExtremos);

        Initial initialProcess = new Initial(box1,nSubconjuntos);
        Middle firstLevelProcess1 = new Middle(1,1,box1,box2);
        Middle firstLevelProcess2 = new Middle(2,1,box1,box3);
        Middle firstLevelProcess3 = new Middle(3,1,box1,box4);
        Middle secondLevelProcess1 = new Middle(1,2,box2,box5);
        Middle secondLevelProcess2 = new Middle(2,2,box3,box6);
        Middle secondLevelProcess3 = new Middle(3,2,box4,box7);
        Middle thirdLevelProcess1 = new Middle(1,3,box5,box8);
        Middle thirdLevelProcess2 = new Middle(2,3,box6,box8);
        Middle thirdLevelProcess3 = new Middle(3,3,box7,box8);
        Final finalProcess = new Final(box8,nSubconjuntos);
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
