import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    ArrayList<Lesson> lesson;

    public Task() throws IOException {
        lesson = read_from_file();
    }


    public void add() throws IOException {
        Lesson new_spam = new Lesson();
        System.out.println("\nВведіть інформацію :");
        new_spam.input();
        lesson.add(new_spam);

        System.out.println("\nІнформація додана!");

        this.write_to_file();
    }

    public void edit() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть порядковий номер курсу, який ви хочете редагувати : ");
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > lesson.size()) {
            System.err.println("Не вірно введений номер!");
            this.edit();
            return;
        }
        int nomer = Integer.parseInt(line);
        nomer--;

        System.out.println("\nВідредагуйте :");
        lesson.get(nomer).input();
        System.out.println("\nРедагування пройшло успішно!");

        this.write_to_file();
    }

    public void print() throws IOException {
        count_note();

        int i = 0;
        System.out.println("\n--------Інформація про курси :--------");
        for (var p :
                lesson) {
            System.out.println("\nКурс №" + (i + 1) + " :");
            p.output();
            i++;
        }
        System.out.println("\n---------------------------------------");
    }

    public void search() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        Date nowdate = new Date();
        System.out.println("\nВведіть назву курсу, який ви шукаєте : ");
        String temp = scanner.nextLine();
        boolean flag = false;
        int i = 0;
        for (var op :
                lesson) {
            if (op.getNcourse().equals(temp)) {
                if (flag == false) {
                    System.out.println("\nРезультат : ");
                    flag = true;
                }
                System.out.println("Курс №" + (i + 1) + " :");
                op.output();
                System.out.println();
                i++;
            }
        }

        if (flag == false) {
            System.out.println("Пошук не вдалий!");
        }
    }

    public void sort() throws IOException {
        count_note();
        ArrayList<Lesson> sortlesson = new ArrayList<Lesson>(lesson);
        Scanner scanner = new Scanner(System.in);
        for(;;) {
            System.out.print("\nВведіть параметр по якому відбудеться сортування : ");
            String commnd = scanner.nextLine();
            switch (commnd) {
                case "course":
                    sortlesson.sort(Comparator.comparing(Lesson::getNcourse));
                    break;
                case "cathedra":
                    sortlesson.sort(Comparator.comparing(Lesson::getNcathedra));
                    break;
                case "date":
                    Lesson[] arr = sort_date();

                    int i = 0;
                    System.out.println("\n--------Відсортований список :--------");
                    for (var p :
                            arr) {
                        System.out.println("\nФільм №" + (i + 1) + " :");
                        p.output();
                        i++;
                    }
                    System.out.println("\n--------------------------------------");
                    return;
                case "group":
                    sortlesson.sort(Comparator.comparing(Lesson::getGroup));
                    break;
                case "kilkist":
                    sortlesson.sort(Comparator.comparing(Lesson::getKilkist));
                    break;
                case "help":
                    System.out.println("\nemail - по E-mail " + "\n" +
                            "fullname - по ПІБ " + "\n" +
                            "date - по даті " + "\n" +
                            "amount - по кількості спам повідомлень " + "\n" +
                            "all amount - по загальній кількостей повідомлень");
                    continue;
                default:
                    System.out.println("Не вірно введений параметр сортування(help-допомога). Введіть ще раз :");
                    continue;
            }
            break;
        }

        int i = 0;
        System.out.println("\n--------Відсортований список :--------");
        for (var p : sortlesson) {
            System.out.println("\nСпам №" + (i + 1) + " :");
            p.output();
            i++;
        }
        System.out.println("\n--------------------------------------");
    }

    public void delete() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть порядковий номер, який ви хочете видалити : ");
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > lesson.size()) {
            System.err.println("Не вірно введений номер!");
            this.delete();
            return;
        }
        int nomer = Integer.parseInt(line);
        nomer--;

        lesson.remove(nomer);
        System.out.println("\nВидалення пройшло успішно!");

        this.write_to_file();
    }

    public void task() throws IOException {
        count_note();

        for (; ; ) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\n1.Завдання 1" + "\n" +
                    "2.Завдання 2" + "\n" +
                    "3.Завдання 3" + "\n" +
                    "4.Вернутись назад" + "\n" +
                    "Введіть число : ");
            int nomer = scanner.nextInt();

            if (nomer < 1 || nomer > 4) {
                System.out.println("Не вірно введене число!! Введіть ще раз :");
                continue;
            }

            switch (nomer) {
                case 1:
                    task_1();
                    break;
                case 2:
                    task_2();
                    break;
                case 3:
                    task_3();
                    break;
                case 4:
                    return;
            }
        }
    }

    private void task_1() {
        try {
            int count_student = 0;
            int count = 0;
            for (Lesson lesson : lesson) {
                        count_student += lesson.kilkist;
                        count++;
            }
            if (count == 0)
                throw new IOException("Студентів немає!");

            double result = (double) count_student / count;

            System.out.println("Середня кількість студентів"+ result);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void task_2() {
        int temp = 0;
        Lesson[] arr = sort_date();
        for (int i = 1; i < arr.length; i++)
            temp = arr[i].kilkist;

        for (Lesson lesson : lesson) {
            if (lesson.kilkist > temp){
                temp = lesson.kilkist;
            }
        }
        for (Lesson lesson : lesson) {
            if(lesson.kilkist>=temp){
            System.out.println(lesson);
            }
        }
    }

    private void task_3() {
        System.out.println();
        int k = 0;
        for (Lesson p : lesson) {
            String[] words = p.Ncathedra.split("[\\s]+");
            System.out.println(words.length);
        }
    }

    private Lesson[] sort_date() {
        Lesson[] arr = new Lesson[lesson.size()];
        arr = lesson.toArray(arr);
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j].getDate().better(arr[j + 1].getDate())) {
                    Lesson temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        return arr;
    }

    private void count_note() throws IOException {
        if (lesson.size() == 0)
            throw new IOException("Записів нема!");
    }

     private static void isFile(String filepath) throws IOException {
        File file = new File(filepath);
        if (!file.isFile()) throw new IOException("Файл не знайдено!");
        //file.createNewFile();
    }

     public void write_to_file() throws IOException {
        isFile("Course.txt");

        BufferedWriter output = new BufferedWriter(new FileWriter("Course.txt"));
        for (var p :
                lesson) {
            output.write(p.to_string());
        }
        output.flush();
        output.close();
        output.close();
    }

    private static ArrayList<Lesson> read_from_file() throws IOException {
        isFile("Course.txt");

        BufferedReader reader = new BufferedReader(new FileReader("Course.txt"));
        String text;
        ArrayList<Lesson> arrayList = new ArrayList<>();
        while ((text = reader.readLine()) != null) {
            arrayList.add(new Lesson(text, reader.readLine(), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine())));
        }
        reader.close();
        return arrayList;
    }

}
