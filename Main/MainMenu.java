package Main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JFrame {

    private JButton Administrator, Instructor, Student, Parent, Admission;
    private Container container;
    private MyPanel panel;
    private JLabel welcomeLabel, SubLabel, imageLabel;

    public MainMenu() {
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Occidental Mindoro State College - Main Menu");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        panel = new MyPanel();
        panel.setLayout(null);

        ImageIcon originalImageIcon = new ImageIcon("Final_Project/image/Icon.png");
        Image originalImage = originalImageIcon.getImage();

        Image scaledImage = originalImage.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        imageLabel = new JLabel(scaledImageIcon);

        Font font = new Font("Courier", Font.BOLD, 15);

        welcomeLabel = new JLabel("Occidental Mindoro State College");
        welcomeLabel.setFont(new Font("Courier", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.WHITE);

        SubLabel = new JLabel("San Jose, Occidental Mindoro");
        SubLabel.setFont(new Font("Courier", Font.BOLD, 15));
        SubLabel.setForeground(Color.WHITE);

        Administrator = new JButton("Administrator");
        Administrator.setFont(font);
        Administrator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminLoginForm signUpPage = new AdminLoginForm();
                signUpPage.setTitle("Occidental Mindoro State College - Administrator");
                signUpPage.setSize(700, 600);
                signUpPage.setLocationRelativeTo(null);
                signUpPage.setResizable(false);
                signUpPage.readProperties();
                signUpPage.setVisible(true);
                dispose();
            }
        });

        Instructor = new JButton("Instructor");
        Instructor.setFont(font);
        Instructor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InstructorLoginForm loginPage = new InstructorLoginForm();
                loginPage.setTitle("Occidental Mindoro State College - Instructor");
                loginPage.setSize(700, 600);
                loginPage.setLocationRelativeTo(null);
                loginPage.setResizable(false);
                loginPage.setVisible(true);
                loginPage.readProperties();
                dispose();
            }
        });

        Student = new JButton("Student");
        Student.setFont(font);
        Student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentLoginForm loginPage = new StudentLoginForm();
                loginPage.setTitle("Occidental Mindoro State College - Student");

                loginPage.setSize(700, 600);
                loginPage.setLocationRelativeTo(null);
                loginPage.setResizable(false);
                loginPage.setVisible(true);
                loginPage.readProperties();
                dispose();
            }
        });

        Parent = new JButton("Parent");
        Parent.setFont(font);
        Parent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParentLoginForm signUpPage = new ParentLoginForm();
                signUpPage.setTitle("Occidental Mindoro State College - Parent");
                signUpPage.setSize(700, 600);
                signUpPage.setLocationRelativeTo(null);
                signUpPage.setResizable(false);
                signUpPage.readProperties();
                signUpPage.setVisible(true);
                dispose();
            }
        });

        Admission = new JButton("Admission");
        Admission.setFont(font);
        Admission.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentRegisterForm signUpPage = new StudentRegisterForm();
                signUpPage.setTitle("Occidental Mindoro State College - Admission");
                signUpPage.setSize(700, 600);
                signUpPage.setLocationRelativeTo(null);
                signUpPage.setResizable(false);
                signUpPage.readProperties();
                signUpPage.setVisible(true);
                dispose();
            }
        });

        container = getContentPane();
        container.add(panel);
        SetBounds();
        AddComponents();
    }

    public void SetBounds() {
        imageLabel.setBounds(282, 50, 130, 130);
        welcomeLabel.setBounds(190, 180, 500, 50);
        SubLabel.setBounds(240, 200, 500, 50);
        Administrator.setBounds(233, 260, 233, 35);
        Instructor.setBounds(233, 310, 233, 35);
        Student.setBounds(233, 360, 233, 35);
        Parent.setBounds(233, 410, 233, 35);
        Admission.setBounds(233, 460, 233, 35);
    }

    public void AddComponents() {
        panel.add(imageLabel);
        panel.add(welcomeLabel);
        panel.add(SubLabel);
        panel.add(Administrator);
        panel.add(Instructor);
        panel.add(Student);
        panel.add(Parent);
        panel.add(Admission);
    }

    //
    public static void main(String[] args) {
        MainMenu firstPage = new MainMenu();
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
