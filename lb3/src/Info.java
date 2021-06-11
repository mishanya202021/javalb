import java.util.Date;
import java.util.Scanner;

public class Info {
    Dat date;
    double tempr;
    double tisk;

    Date nowdate = new Date();

    public Info() {
        date = new Dat();
        tempr = 0;
        tisk = 0;
    }

    public Info(int day, int month, int year, double tempr, double tisk) {
        this.date = new Dat(day, month, year);
        this.tempr = tempr;
        this.tisk = tisk;
    }

    //--------------

    public void input() {
        Scanner scanner = new Scanner(System.in);
        date.enterDat();
        System.out.println("Введіть температуру");
        tempr = scanner.nextDouble();
        System.out.println("Введіть тиск");
        tisk = scanner.nextDouble();
        System.out.println("Інформація додана");
    }

    public void output() {
        date.printDat();
        System.out.println("Температура" + tempr);
        System.out.println("Тиск" + tisk);
    }

    @Override
    public String toString() {
        return date.toString() +
                "\t" + tempr + "\t" + tisk;
    }

    public Dat getDate() {
        return date;
    }

    public void setDate(Dat date) {
        this.date = date;
    }

    public double getTempr() {
        return tempr;
    }

    public void setTempr(double tempr) {
        this.tempr = tempr;
    }

    public double getTisk() {
        return tisk;
    }

    public void setTisk(double tisk) {
        this.tisk = tisk;
    }
}
