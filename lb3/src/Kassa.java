import java.util.Scanner;

public class Kassa {
String name;
DateTime vidprav;
DateTime pribyt;
double price;

    public Kassa(){
        name ="";
        vidprav = new DateTime();
        pribyt = new DateTime();
        price = 0;
    }
    public Kassa(String name, int day, int month, int year, int hour, int minute ,int day1, int month1, int year1, int hour1 , int minute1, double price){
        this.name = name;
        this.vidprav = new DateTime(day, month , year , hour , minute);
        this.pribyt = new DateTime(day1, month1, year1, hour1, minute1);
        this.price= price;
    }


    //----------------
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву пункту : ");
        name = scanner.nextLine();
        System.out.println("Введіть дату і час відправлення : ");
        vidprav.enterDateTime();
        System.out.println("Введіть дату і час прибуття : ");
        pribyt.enterDateTime();
        System.out.println("Введіть ціну");
        price = scanner.nextDouble();
        System.out.println("Інформація додана");
    }

    public void print() {
        System.out.println("Назва : " + name);
        System.out.println("Дата і час відправлення ");
        System.out.println("Дата : " + vidprav.toString());
        System.out.println("Дата і час прибуття ");
        System.out.println("Дата : " + pribyt.toString());
        System.out.println("Ціна : " + price);
    }

    @Override
    public String toString() {
        return "Квитки" + "Назва : " + name + "Дата і час відправлення" + vidprav.toString() + "Дата і час прибуття" + pribyt.toString() + "Ціна :" + price;
    }

    public String to_string() {
        return name + '\n' + vidprav.to_String() + '\n' + pribyt.to_String() + '\n' + price + '\n';
    }

    public String getName(){
        return  name;
    }
    public int getHours(){
        return vidprav.getHour();
    }
    public int getMitutes(){
        return vidprav.getMinute();
    }
    public void setName(String name) {
        this.name = name;
    }

    public DateTime getVidprav() {
        return vidprav;
    }

    public void setVidprav(DateTime vidprav) {
        this.vidprav = vidprav;
    }

    public DateTime getPribyt() {
        return pribyt;
    }

    public void setPribyt(DateTime pribyt) {
        this.pribyt = pribyt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
