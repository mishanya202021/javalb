import java.util.Scanner;

public class Lesson extends Course {
    Dat date;
    int group;
    int kilkist;


    public Lesson () {
        date = new Dat();
        group = 0;
        kilkist = 0;
    }
    public Lesson (int d , int m , int y , int group , int kilkist) {
        this.date = new Dat(d,m,y);
        this.group = group;
        this.kilkist = kilkist;
    }
    public Lesson (String Ncouse, String Ncathedra , int d , int m , int y , int group , int kilkist){
        super(Ncouse , Ncathedra);
        this.date = new Dat(d,m,y);
        this.group = group;
        this.kilkist = kilkist;
    }
    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Назву курсу  : ");
        Ncourse = scanner.nextLine();
        System.out.print("Назву кафедри  : ");
        Ncathedra = scanner.nextLine();
        System.out.println("Дату : ");
        date.inputDate();
        System.out.print("Номер групи : ");
        group = scanner.nextInt();
        System.out.print("Кількість студентів : ");
        kilkist = scanner.nextInt();
    }


    @Override
    public void output() {
        System.out.println("Назву курсу  : " + Ncourse);
        System.out.println("Назву кафедри  : " + Ncathedra);
        System.out.println("Дату : " + date.toString());
        System.out.println("Номер групи : " + group);
        System.out.println("Кількість студентів : " + kilkist);
    }
    @Override
    public String toString() {
        return Ncourse + '\t' + Ncathedra + '\t' + date + '\t' + group + '\t' + kilkist;
    }

    public String to_string() {
        return Ncourse + '\n' + Ncathedra + '\n' + date.to_string() + '\n' + group + '\n' + kilkist + '\n';
    }
    public Dat getDate() {
        return date;
    }

    public int getGroup() {
        return group;
    }

    public int getKilkist() {
        return kilkist;
    }

    public void setDate(Dat date) {
        this.date = date;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setKilkist(int kilkist) {
        this.kilkist = kilkist;
    }
}
