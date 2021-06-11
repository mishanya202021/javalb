import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1.Завдання 1");
            System.out.println("2.Завдання 2");
            System.out.println("3.Exit");
            System.out.println("Введіть номер : ");
            int nomer = scanner.nextInt();
            switch (nomer){
                case 1:
                    System.out.println("first task");
                    Task1();
                    break;
                case 2:
                    System.out.println("second task");
                    menu();
                    break;
                case 3:
                    return;
                default:
                    System.err.println("Не вірно введене число! Введіть ще раз :");
                    break;
            }
        }
    }
    public static void Task1(){
        ArrayList<Info> list = new ArrayList<Info>();
        list.add(new Info(10, 3, 2020, 22, 100));
        list.add(new Info(30, 5, 2020, 15, 80));
        list.add(new Info(1, 4, 2020, 27, 88));
        list.add(new Info(15, 3, 2020, 12, 78));
        list.add(new Info(29, 4, 2020, 15, 83));
        System.out.println("Information : ");
        double midl = 0;
        int k = 0;
        for (Info inf : list) {
            System.out.println(inf.toString());
            midl += inf.getTempr();
            k++;
        }
        midl = midl / k;
        System.out.println("Midl temperature : " + midl);
        for (Info info : list) {
            if (info.getTempr() > midl) {
                System.out.println(info.toString());
            }
        }
    }
    public static void menu(){
        try {
            Scanner scanner = new Scanner(System.in);
            Task2 task = new Task2();
            for(;;){
                System.out.print("\nВведіть команду : ");
                String command = scanner.nextLine();
                switch (command){
                    case "add":
                        task.add();
                        break;
                    case "edit":
                        task.edit();
                        break;
                    case "print":
                        task.print();
                        break;
                    case "search":
                        task.search();
                        break;
                    case "sort":
                        task.sort();
                        break;
                    case "delete":
                        task.delete();
                        break;
                    case "exit":
                        return;
                    case "help":
                        System.out.println("\nadd - додати квиток" + "\n" +
                                "edit - редагувати квиток" + "\n" +
                                "print - висести список квитків" + "\n" +
                                "search - пошук квитка" + "\n" +
                                "sort - сортування квитків" + "\n" +
                                "delete - видалити квиток" + "\n" +
                                "exit - вихід");
                        break;
                    default:
                        System.err.print("Не вірно введена команда(help - допомога)! Введіть ще раз :");
                        break;
                }
            }
        }
        catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}
