public abstract class Course {
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
    public abstract void input() ;

    public abstract void output() ;

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
