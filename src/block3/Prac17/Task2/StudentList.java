package block3.Prac17.Task2;

public class StudentList {

    private Student head;
    private Student tail;

    // Создание пустого списка
    public StudentList() {
        head = null;
        tail = null;
    }

    // Добавление студента
    public void add(Student student) {

        if (head == null) {
            head = student;
            tail = student;
        } else {
            tail.next = student;
            student.prev = tail;
            tail = student;
        }
    }

    // Удаление студента по имени
    public void remove(String name) {

        Student current = head;

        while (current != null) {

            if (current.getName().equals(name)) {

                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                return;
            }

            current = current.next;
        }
    }

    // Вывод списка от начала к концу
    public void printAll() {

        Student current = head;

        while (current != null) {
            current.print();
            System.out.println("----------------");

            current = current.next;
        }
    }

    // Вывод списка от конца к началу
    public void printReverse() {

        Student current = tail;

        while (current != null) {
            current.print();
            System.out.println("----------------");

            current = current.prev;
        }
    }

    // Очистка списка
    public void clear() {
        head = null;
        tail = null;
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return head == null;
    }
}
