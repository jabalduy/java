package block2.Prac10;

import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {

    private Student[] iDNumber;

    public void setArray(Student[] students) {
        iDNumber = students;
    }

    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getGpa(), s1.getGpa());
    }

    public void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }

        Student pivot = iDNumber[(left + right) / 2];

        int i = left;
        int j = right;

        while (i <= j) {

            while (compare(iDNumber[i], pivot) < 0) {
                i++;
            }

            while (compare(iDNumber[j], pivot) > 0) {
                j--;
            }

            if (i <= j) {
                Student temp = iDNumber[i];
                iDNumber[i] = iDNumber[j];
                iDNumber[j] = temp;

                i++;
                j--;
            }
        }

        if (left < j) {
            quickSort(left, j);
        }

        if (i < right) {
            quickSort(i, right);
        }
    }

    public void mergeSort(int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;

        mergeSort(left, middle);
        mergeSort(middle + 1, right);

        merge(left, middle, right);
    }

    private void merge(int left, int middle, int right) {
        Student[] temp = new Student[right - left + 1];

        int i = left;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= right) {
            if (compare(iDNumber[i], iDNumber[j]) <= 0) {
                temp[k] = iDNumber[i];
                i++;
            } else {
                temp[k] = iDNumber[j];
                j++;
            }

            k++;
        }

        while (i <= middle) {
            temp[k] = iDNumber[i];
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = iDNumber[j];
            j++;
            k++;
        }

        for (int x = 0; x < temp.length; x++) {
            iDNumber[left + x] = temp[x];
        }
    }

    public void sortByName() {
        for (int i = 0; i < iDNumber.length - 1; i++) {
            for (int j = 0; j < iDNumber.length - 1 - i; j++) {

                if (iDNumber[j].getName()
                        .compareTo(iDNumber[j + 1].getName()) > 0) {

                    Student temp = iDNumber[j];
                    iDNumber[j] = iDNumber[j + 1];
                    iDNumber[j + 1] = temp;
                }
            }
        }
    }

    public void outArray() {
        for (int i = 0; i < iDNumber.length; i++) {
            System.out.println(
                    iDNumber[i].getName() + " " +
                            iDNumber[i].getSurname() + " " +
                            iDNumber[i].getGpa()
            );
        }
    }

}
