package block2.Prac9.Task2;

public class Student {
    int iDNumber;
    String name;
    double gpa;

    public Student(int IDNumber, String name, double gpa) {
        this.iDNumber = IDNumber;
        this.name = name;
        this.gpa = gpa;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    public double getGpa() {
        return gpa;
    }
}
