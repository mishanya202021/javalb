import java.util.Scanner;

/*
Class
Навчальний курс
Назва курсу,
назва кафедри


Class
Лекція
Дата,
група,
кількість студентів
Zavdania
Середня кількість студентів,
лекції з найбільшою кількістю студентів,
кількість слів у назві кафедри
*/
public class Course {
    String Ncourse;
    String Ncathedra;



    public Course () {
        Ncourse = "";
        Ncathedra ="";
    }

    public Course (String Ncourse , String Ncathedra) {
        this.Ncourse = Ncourse;
        this.Ncathedra = Ncathedra;
    }
    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Назву курсу  : ");
        Ncourse = scanner.nextLine();
        System.out.print("Назву кафедри  : ");
        Ncathedra = scanner.nextLine();
    }

    //метод для виводу даних
    public void output() {
        System.out.println("Назву курсу  : " + Ncourse);
        System.out.println("Назву кафедри  : " + Ncathedra);
    }

    //перевизначення методу toString()
    @Override
    public String toString() {
        return "Назву курсу : " + Ncourse + "\n" + "Назву кафедри : " + Ncathedra ;
    }
    public String getNcourse() {
        return Ncourse;
    }

    public String getNcathedra() {
        return Ncathedra;
    }
    
    public void setNcourse(String Ncourse) {
        this.Ncourse = Ncourse;
    }

    public void setNcathedra(String Ncathedra) {
        this.Ncathedra = Ncathedra;
    }

}
