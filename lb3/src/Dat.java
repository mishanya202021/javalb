import java.util.Date;
import java.util.Scanner;
public class Dat {
int day;
int month;
int year;
    public Dat() {
        day = 0;
        month = 0;
        year = 0;
    }
    public Dat(int day , int month , int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public void enterDat(){
        Date nowdate = new Date();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть день : ");
        String line = scanner.nextLine();
        if(Integer.parseInt(line)<0||Integer.parseInt(line)>31||line.isEmpty()){
            System.err.println("Не вірно введений день");
            this.enterDat();
            return;
        }
        day = Integer.parseInt(line);
        System.out.println("Введіть місяць : ");
        line = scanner.nextLine();
        if(Integer.parseInt(line)<0||Integer.parseInt(line)>12||line.isEmpty()){
            System.err.println("Не вірно введений місяць");
            this.enterDat();
            return;
        }
        month = Integer.parseInt(line);
        System.out.print("Введіть рік : ");
        line = scanner.nextLine();
        if (line.isEmpty() || Integer.parseInt(line) > (nowdate.getYear() + 1000)) {
            System.err.println("Не вірно введений рік!");
            this.enterDat();
            return;
        }
        year = Integer.parseInt(line);

        if ((year == (nowdate.getYear() + 1000))
                && ((month > nowdate.getMonth() + 1)
                || ((month == nowdate.getMonth() + 1) && (day > nowdate.getDate())))) {
            System.err.println("Не вірно введений рік!");
            this.enterDat();
            return;
        }

        switch (month) {
            case 2:
                if (day > 28) {
                    System.err.println("В Лютому тільки 28 днів!");
                    this.enterDat();
                    return;
                }
            case 4:
                if (day > 30) {
                    System.err.println("В Квітні тільки 30 днів!");
                    this.enterDat();
                    return;
                }
            case 6:
                if (day > 30) {
                    System.err.println("В Червні тільки 30 днів!");
                    this.enterDat();
                    return;
                }
            case 9:
                if (day > 30) {
                    System.err.println("В Вересні тільки 30 днів!");
                    this.enterDat();
                    return;
                }
            case 11:
                if (day > 30) {
                    System.err.println("В Листопаді тільки 30 днів!");
                    this.enterDat();
                }
        }
    }
    public void printDat(){
        System.out.println("Дата : "+day);
        System.out.println("Місяць : "+month);
        System.out.println("Рік : "+year);
    }
    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYears(int years) {
        this.year = years;
    }
}
