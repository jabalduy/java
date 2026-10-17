package block2.Prac10;

public class Task3 {

    public static Student[] combine(Student[] first, Student[] second) {
        Student[] result = new Student[first.length + second.length];

        int k = 0;

        for (int i = 0; i < first.length; i++) {
            result[k] = first[i];
            k++;
        }

        for (int i = 0; i < second.length; i++) {
            result[k] = second[i];
            k++;
        }

        return result;
    }

    public static void main(String[] args) {

        Student[] first = {
                new Student("Ivan", "Ivanov", "CS", 2, "IKBO-01", 3.7),
                new Student("Anna", "Petrova", "Math", 3, "IKBO-02", 4.9),
                new Student("Max", "Volkov", "Physics", 1, "IKBO-03", 4.1)
        };

        Student[] second = {
                new Student("Oleg", "Sidorov", "CS", 2, "IKBO-04", 3.5),
                new Student("Petr", "Smirnov", "Math", 4, "IKBO-05", 4.6),
                new Student("John", "Orlov", "Physics", 2, "IKBO-06", 4.3)
        };

        Student[] result = combine(first, second);

        SortingStudentsByGPA sorter = new SortingStudentsByGPA();

        sorter.setArray(result);

        sorter.quickSort(0, result.length - 1);

        sorter.outArray();
    }
}