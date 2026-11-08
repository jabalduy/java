package block3.Prac5;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Абстрактный класс фигуры
abstract class Shape {

    protected int x;
    protected int y;
    protected Color color;

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    // Каждая фигура должна сама реализовать рисование
    public abstract void draw(Graphics g);
}


// Класс круга
class Circle extends Shape {

    private int size;

    public Circle(int x, int y, int size, Color color) {
        super(x, y, color);
        this.size = size;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }
}


// Класс прямоугольника
class RectangleShape extends Shape {

    private int width;
    private int height;

    public RectangleShape(int x, int y,
                          int width, int height,
                          Color color) {
        super(x, y, color);

        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}


// Панель, на которой будут рисоваться фигуры
class DrawingPanel extends JPanel {

    private Shape[] shapes = new Shape[20];
    private Random random = new Random();

    public DrawingPanel() {

        // Создаем 20 случайных фигур
        for (int i = 0; i < shapes.length; i++) {

            // Случайная позиция
            int x = random.nextInt(450);
            int y = random.nextInt(350);

            // Случайный цвет
            Color color = new Color(
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256)
            );

            // Случайный размер
            int size = 30 + random.nextInt(70);

            // Случайно выбираем круг или прямоугольник
            if (random.nextBoolean()) {

                shapes[i] = new Circle(
                        x,
                        y,
                        size,
                        color
                );

            } else {

                int width = 30 + random.nextInt(70);
                int height = 30 + random.nextInt(70);

                shapes[i] = new RectangleShape(
                        x,
                        y,
                        width,
                        height,
                        color
                );
            }
        }
    }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Рисуем все фигуры
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}


// Главный класс программы
public class RandomShapes {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("20 Random Shapes");

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setSize(600, 500);

        DrawingPanel panel =
                new DrawingPanel();

        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
