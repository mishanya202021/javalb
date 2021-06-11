import java.io.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Завдання 1");
        System.out.println("2.Завдання 2");
        System.out.println("3.Завдання 3");
        System.out.println("4.Вихід");
        System.out.println("Введіть число : ");
        int num = scanner.nextInt();

        while(num != 4){
            try {
                switch (num) {
                    case 1:
                            System.out.println("\nЗавдання 1 :");
                            Task.task1();
                            System.out.println();
                        break;
                    case 2:
                            System.out.println("\nЗавдання 2 :");
                            Task.task2("D:\\учоба\\GitHub Repository\\java\\lb2\\sport.txt");
                        break;
                    case 3:
                            System.out.println("\nЗавдання 3 :");
                            Task.task3("D:\\учоба\\GitHub Repository\\java\\lb2\\input.txt", "D:\\учоба\\GitHub Repository\\java\\lb2\\output.txt");
                        break;
                    default:
                        System.out.println("Не вірно введене число!Введіть ще раз :");
                        break;
                }
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
            System.out.println("1.Завдання 1");
            System.out.println("2.Завдання 2");
            System.out.println("3.Завдання 3");
            System.out.println("4.Вихід");
            System.out.println("Введіть число : ");
            num = scanner.nextInt();
        }
    }
}
