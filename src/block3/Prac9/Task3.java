package block3.Prac9;

public class Task3 {

    public static void main(String[] args) {

        Student[] list1 = {
                new Student(5, "Иван", 4.2),
                new Student(1, "Анна", 4.8),
                new Student(8, "Петр", 3.9)
        };

        Student[] list2 = {
                new Student(3, "Мария", 4.5),
                new Student(7, "Алексей", 4.0),
                new Student(2, "Ольга", 4.7)
        };

        Student[] students = new Student[list1.length + list2.length];

        int index = 0;

        for (Student student : list1) {
            students[index] = student;
            index++;
        }

        for (Student student : list2) {
            students[index] = student;
            index++;
        }

        mergeSort(students, 0, students.length - 1);

        System.out.println("Отсортированный список:");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void mergeSort(Student[] students, int left, int right) {

        if (left < right) {

            int middle = (left + right) / 2;

            mergeSort(students, left, middle);
            mergeSort(students, middle + 1, right);

            merge(students, left, middle, right);
        }
    }

    public static void merge(
            Student[] students,
            int left,
            int middle,
            int right) {

        int size1 = middle - left + 1;
        int size2 = right - middle;

        Student[] leftArray = new Student[size1];
        Student[] rightArray = new Student[size2];

        for (int i = 0; i < size1; i++) {
            leftArray[i] = students[left + i];
        }

        for (int i = 0; i < size2; i++) {
            rightArray[i] = students[middle + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < size1 && j < size2) {

            if (leftArray[i].getIDNumber()
                    <= rightArray[j].getIDNumber()) {

                students[k] = leftArray[i];
                i++;

            } else {

                students[k] = rightArray[j];
                j++;
            }

            k++;
        }

        while (i < size1) {
            students[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < size2) {
            students[k] = rightArray[j];
            j++;
            k++;
        }
    }
}