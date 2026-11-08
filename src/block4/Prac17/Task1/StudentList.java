package block4.Prac17.Task1;

public class StudentList {

    private Student head;

    // a. Создание пустого списка
    public StudentList() {
        head = null;
    }

    // b. Добавление элемента в список
    public void add(Student student) {
        if (head == null) {
            head = student;
        } else {
            Student current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = student;
        }
    }

    // c. Удаление элемента по имени
    public void remove(String name) {
        if (head == null) {
            return;
        }

        if (head.getName().equals(name)) {
            head = head.next;
            return;
        }

        Student current = head;

        while (current.next != null) {
            if (current.next.getName().equals(name)) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }

    // d. Вывод всех элементов списка
    public void printAll() {
        Student current = head;

        while (current != null) {
            current.print();
            System.out.println("----------------");

            current = current.next;
        }
    }

    // e. Очистка списка
    public void clear() {
        head = null;
    }

    // f. Проверка списка на пустоту
    public boolean isEmpty() {
        return head == null;
    }
}
