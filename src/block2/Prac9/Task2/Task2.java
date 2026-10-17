package block2.Prac9.Task2;

public class Task2 {

    public static void main(String[] args) {
        Student[] students = {
                new Student(5, "Ivan", 4.2),
                new Student(2, "Petr", 3.7),
                new Student(8, "Oleg", 4.8),
                new Student(1, "Alex", 3.9),
                new Student(4, "Jane", 4.5)
        };

        SortingStudentsByGPA sorter = new SortingStudentsByGPA();

        sorter.quickSort(students, 0, students.length - 1);

        for (int i = 0; i < students.length; i++) {
            System.out.println(
                    students[i].iDNumber + " " + students[i].name
            );
        }
    }
}
