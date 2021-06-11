import java.util.Date;
import java.util.Scanner;

public class DateTime {
    int day;
    int month;
    int year;
    int hour;
    int minute;
    public DateTime() {
        day = 0;
        month = 0;
        year = 0;
        hour = 0;
        minute = 0;
    }
    public DateTime(int hour, int minute, int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }
    public void enterDateTime(){
        Date nowdate = new Date();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть день : ");
        String line = scanner.nextLine();
        if(Integer.parseInt(line)<0||Integer.parseInt(line)>31||line.isEmpty()){
            System.err.println("Не вірно введений день");
            this.enterDateTime();
            return;
        }
        day = Integer.parseInt(line);
        System.out.println("Введіть місяць : ");
        line = scanner.nextLine();
        if(Integer.parseInt(line)<0||Integer.parseInt(line)>12||line.isEmpty()){
            System.err.println("Не вірно введений місяць");
            this.enterDateTime();
            return;
        }
        month = Integer.parseInt(line);
        System.out.print("Введіть рік : ");
        line = scanner.nextLine();
        if (line.isEmpty() || Integer.parseInt(line) > (nowdate.getYear() + 1900)) {
            System.err.println("Не вірно введений рік!");
            this.enterDateTime();
            return;
        }
        year = Integer.parseInt(line);
        System.out.print("Введіть годину : ");
        line = scanner.nextLine();
        if (line.isEmpty() || Integer.parseInt(line) > 24) {
            System.err.println("Не вірно введена година!");
            this.enterDateTime();
            return;
        }
        hour = Integer.parseInt(line);
        System.out.print("Введіть хвилини : ");
        line = scanner.nextLine();
        if (line.isEmpty() || Integer.parseInt(line) > 60) {
            System.err.println("Не вірно введена хвилина!");
            this.enterDateTime();
            return;
        }
        minute = Integer.parseInt(line);
        if ((year == (nowdate.getYear() + 1000))
                && ((month > nowdate.getMonth() + 1)
                || ((month == nowdate.getMonth() + 1) && (day > nowdate.getDate())))) {
            System.err.println("Не вірно введений рік!");
            this.enterDateTime();
            return;
        }

        switch (month) {
            case 2:
                if (day > 28) {
                    System.err.println("В Лютому тільки 28 днів!");
                    this.enterDateTime();
                    return;
                }
            case 4:
                if (day > 30) {
                    System.err.println("В Квітні тільки 30 днів!");
                    this.enterDateTime();
                    return;
                }
            case 6:
                if (day > 30) {
                    System.err.println("В Червні тільки 30 днів!");
                    this.enterDateTime();
                    return;
                }
            case 9:
                if (day > 30) {
                    System.err.println("В Вересні тільки 30 днів!");
                    this.enterDateTime();
                    return;
                }
            case 11:
                if (day > 30) {
                    System.err.println("В Листопаді тільки 30 днів!");
                    this.enterDateTime();
                }
        }

    }
    public void printDateTime(){
        System.out.println("Дата : "+day);
        System.out.println("Місяць : "+month);
        System.out.println("Рік : "+year);
        if(hour<10) {
            System.out.print("Час" + "0" + hour + ":");
        }
        else
            System.out.print("Час" + hour + ":");
        if(minute<10) {
            System.out.println("0" + minute);
        }
        else
            System.out.println( minute);    }
    @Override
    public String toString() {
        return day + "." + month + "." + year + "\nЧас :  " + hour + ":" + minute;
    }
    public String to_String() {
        return day + "\n" + month + "\n" + year + "\n" + hour + "\n" + minute;
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

    public int getHour() {return  hour;}

    public void setHour(int hour){this.hour = hour;}

    public int getMinute(){return minute;}

    public void setMinute(int minute) { this.minute = minute; }
}
