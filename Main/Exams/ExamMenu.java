package Main.Exams;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExamMenu extends JFrame {

    private JButton JavaExam, JavaExam1;
    private Container container;
    private MyPanel panel;
    private JLabel Java;

    public ExamMenu() {
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Occidental Mindoro State College - Exam Menu");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        Java = new JLabel("Java");
        Java.setFont(new Font("Courier", Font.BOLD, 20));
        Java.setForeground(Color.WHITE);
        JavaExam = new JButton("Midterm Exam");
        JavaExam1 = new JButton("Final Exam");

        panel = new MyPanel();
        panel.setLayout(null);

        container = getContentPane();
        container.add(panel);
        SetBounds();
        AddComponents();
    }

    public void SetBounds() {
        Java.setBounds(10, 10, 500, 50);
        JavaExam.setBounds(10, 50, 150, 25);
        JavaExam1.setBounds(10, 80, 150, 25);
    }

    public void AddComponents() {
        panel.add(Java);
        panel.add(JavaExam);
        panel.add(JavaExam1);
    }

    //
    public static void main(String[] args) {
        ExamMenu firstPage = new ExamMenu();
        firstPage.setVisible(true);
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint gra = new GradientPaint(0, 0, new Color(45, 2, 201), 0, getHeight(), new Color(24, 0, 110));
            g2d.setPaint(gra);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
