package Main;

import javax.swing.*;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
import java.awt.Font;
import java.awt.Container;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

public class ParentLoginForm extends JFrame implements ActionListener {
    JLabel Login, emailLabel, passwordLabel;
    JTextField emailField;
    JPasswordField passwordField;
    JButton loginButton, Gobck;
    String filename, filename1;
    Container container;
    JCheckBox showPassword;
    private JLabel welcomeLabel, SubLabel, imageLabel;

    public void readProperties() {
        Properties props = new Properties();
        try (InputStream is = StudentRegisterForm.class.getResourceAsStream("/.env")) {
            props.load(is);
            filename = props.getProperty("Student_Account");
            System.out.println("Student_Account = " + filename);
            filename1 = props.getProperty("Instructor_Account");
            System.out.println("Instructor_Account = " + filename1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ParentLoginForm() {
        MyPanel panel = new MyPanel();
        setContentPane(panel);
        panel.setLayout(null);

        ImageIcon originalImageIcon = new ImageIcon("Final_Project/image/Icon.png");
        Image originalImage = originalImageIcon.getImage();

        Image scaledImage = originalImage.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        imageLabel = new JLabel(scaledImageIcon);
        imageLabel.setBounds(282, 50, 130, 130);
        panel.add(imageLabel);

        welcomeLabel = new JLabel("Occidental Mindoro State College");
        welcomeLabel.setFont(new Font("Courier", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.WHITE);

        SubLabel = new JLabel("San Jose, Occidental Mindoro");
        SubLabel.setFont(new Font("Courier", Font.BOLD, 15));
        SubLabel.setForeground(Color.WHITE);

        Font font = new Font("Courier", ABORT, 20);
        Login = new JLabel("Parent - Login");
        Login.setFont(new Font("Courier", Font.BOLD, 20));
        Login.setForeground(Color.WHITE);

        emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);

        emailLabel.setFont(font);
        emailField = new JTextField("");
        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);

        passwordLabel.setFont(font);
        passwordField = new JPasswordField("");
        showPassword = new JCheckBox("Show password");
        showPassword.setOpaque(false);
        showPassword.setForeground(Color.WHITE);
        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0); // show password
                } else {
                    passwordField.setEchoChar('*'); // hide password
                }
            }
        });
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        container = getContentPane();
        container.setLayout(null);
        Gobck = new JButton("Go Back");
        Gobck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu firstPage = new MainMenu();
                firstPage.setSize(700, 600);
                firstPage.setVisible(true);
                dispose();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SetBounds();
        AddComponents();
    }

    public void SetBounds() {
        welcomeLabel.setBounds(190, 180, 500, 50);
        SubLabel.setBounds(240, 200, 500, 50);
        Login.setBounds(280, 10, 600, 30);
        emailLabel.setBounds(233, 270, 233, 25);
        emailField.setBounds(233, 300, 233, 25);
        passwordLabel.setBounds(233, 330, 233, 25);
        passwordField.setBounds(233, 360, 233, 25);
        showPassword.setBounds(233, 390, 233, 25);
        loginButton.setBounds(233, 420, 233, 35);
        Gobck.setBounds(233, 470, 233, 35);
    }

    public void AddComponents() {
        container.add(welcomeLabel);
        container.add(SubLabel);
        container.add(Login);
        container.add(emailLabel);
        container.add(emailField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(Gobck);

    }
    /*
     * public static void main(String[] args) {
     * ParentLoginForm Frame = new ParentLoginForm();
     * Frame.setTitle("Occidental Mindoro State College - Administrator");
     * Frame.setVisible(true);
     * Frame.setSize(700, 600);
     * Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     * Frame.setResizable(false);
     * Frame.setLocationRelativeTo(null);
     * Frame.readProperties();
     * }
     */

    public class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint gra = new GradientPaint(0, 0, new Color(45, 2, 201), 0, getHeight(), new Color(24, 0, 110));
            g2d.setPaint(gra);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
