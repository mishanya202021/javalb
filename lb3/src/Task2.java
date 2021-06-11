import java.io.*;
import java.util.*;

public class Task2 {
    ArrayList<Kassa> kassa;

    public Task2() throws IOException {
        kassa = read_from_file("Kassa.txt");
    }

    public void add() throws IOException{
        Kassa new_kassa = new Kassa();
        System.out.println("\nВведіть інформацію :");
        new_kassa.input();
        kassa.add(new_kassa);

        System.out.println("\nІнформація додана!");

        this.write_to_file("Kassa.txt");
    }
    public void edit() throws IOException {
        count_note();
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть порядковий номер квитка, який ви хочете редагувати : ");
        String line = scanner.nextLine();
        if(!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > kassa.size()){
            System.err.println("Не вірно введений номер!");
            this.edit();
            return;
        }
        int nomer = Integer.parseInt(line);
        nomer--;

        System.out.println("\nВідредагуйте :");
        kassa.get(nomer).input();
        System.out.println("\nРедагування пройшло успішно!");

        this.write_to_file("Kassa.txt");
    }

    public void print() throws IOException {
        count_note();

        int i = 0;
        System.out.println("\nІнформація про квитки :");
        for (var p:
                kassa) {
            System.out.println("\nКвитки №" + (i + 1) + " :");
            p.print();
            i++;
        }
    }

    public void search() throws IOException {
        count_note();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведіть назву пункту для пошуку : ");
        String line = scanner.nextLine();
        int i = 0;
        for (var p:
                kassa) {
            if(p.getName().equals(line)) {
                    System.out.println("Квиток №" + (i + 1) + " :");
                    p.print();
                    System.out.println();
                    i++;
            }
        }
        if(i == 0){
            System.out.println("Такого квитка немає !");
        }
    }

    public void sort() throws IOException {
        count_note();
        ArrayList<Kassa> sortkassa = new ArrayList<Kassa>(kassa);
        sortkassa.sort(Comparator.comparing(Kassa::getHours));

        int i = 0;
        System.out.println("\nВідсортований список :");
        for (var p:
                sortkassa) {
            System.out.println("\nКвиток №" + (i + 1) + " :");
            p.print();
            i++;
        }
    }

    public void delete() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть порядковий номер квитка, який ви хочете видалити : ");
        String line = scanner.nextLine();
        if(line.isEmpty() || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > kassa.size()){
            System.err.println("Не вірно введений номер!");
            this.delete();
            return;
        }
        int nomer = Integer.parseInt(line);
        nomer--;

        kassa.remove(nomer);
        System.out.println("\nВидалення пройшло успішно!");

        this.write_to_file("Kassa.txt");
    }

    public void count_note() throws IOException {
        if(kassa.size() == 0)
            throw new IOException("Записів нема!");
    }
    private static void isFile(String filepath) throws IOException{
        File file = new File(filepath);
        if(!file.isFile()) throw new IOException("Файл не знайдено!");

    }

    public void write_to_file(String filepath) throws IOException{
        isFile(filepath);

        BufferedWriter output = new BufferedWriter(new FileWriter(filepath));
        for (var p: kassa) {
            output.write(p.to_string());
        }
        output.flush();
        output.close();
        output.close();
    }
    private static ArrayList<Kassa> read_from_file(String filepath) throws IOException {
        isFile(filepath);

        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String text;
        ArrayList<Kassa> arrayList = new ArrayList<>();
        Kassa kassa;
        while ((text = reader.readLine()) != null) {
            arrayList.add(new Kassa(text,
                    Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()),
                    Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()),
                    Double.parseDouble(reader.readLine())));
        }
        reader.close();
        return arrayList;
    }
}
