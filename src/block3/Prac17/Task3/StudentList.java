package block3.Prac17.Task3;

public class StudentList {

    private Student head;
    private Student tail;

    public StudentList() {
        head = null;
        tail = null;
    }

    public void add(Student student) {

        if (head == null) {
            head = student;
            tail = student;

            student.next = head;
        } else {
            tail.next = student;
            tail = student;

            tail.next = head;
        }
    }

    public void remove(String name) {

        if (head == null) {
            return;
        }

        Student current = head;
        Student previous = tail;

        do {
            if (current.getName().equals(name)) {

                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                }

                return;
            }

            previous = current;
            current = current.next;

        } while (current != head);
    }

    public void printAll() {

        if (head == null) {
            return;
        }

        Student current = head;

        do {
            current.print();
            System.out.println("----------------");

            current = current.next;

        } while (current != head);
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
