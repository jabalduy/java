package Prac9;

public class Task1 {

    public static void insertionSort(Student [] students) {
        for (int i = 1; i < students.length; i++) {

            Student current = students[i];

            int j = i - 1;

            while (j >= 0 &&
            students[j].getIDNumber() > current.getIDNumber()) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = current;
        }
    }

    public static void main(String[] args) {

        Student[] students = {
                new Student(5, "Ivan", 4.2),
                new Student(2, "Petr", 3.7),
                new Student(8, "Oleg", 4.8),
                new Student(1, "Alex", 3.9),
                new Student(4, "Jane", 4.5)
        };

        insertionSort(students);

        for (int i = 0; i < students.length; i++) {
            System.out.println(
                    students[i].iDNumber + " " + students[i].name
            );
        }
    }
}
