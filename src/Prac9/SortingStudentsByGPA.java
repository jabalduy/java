package Prac9;

import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getGpa(), s1.getGpa());
    }

    public void quickSort(Student[] students, int left, int right) {
        if (left >= right) {
            return;
        }

        Student pivot = students[(left+right) / 2];

        int i = left;
        int j = right;

        while (i <= j) {

            while (compare(students[i], pivot) < 0) {
                i++;
            }

            while (compare(students[j], pivot) > 0) {
                j--;
            }

            if (i<=j) {
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;

                i++;
                j--;
            }
        }

        if (left < j) {
            quickSort(students, left, j);
        }

        if (i < right) {
            quickSort(students, i, right);
        }
    }
}
