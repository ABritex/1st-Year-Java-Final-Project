package Main;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Font;
import java.awt.Container;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

public class InstructorLoginForm extends JFrame implements ActionListener {
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

    public InstructorLoginForm() {
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
        Login = new JLabel("Instructor - Login");
        Login.setFont(new Font("Courier", Font.BOLD, 20));
        Login.setForeground(Color.WHITE);

        emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);

        emailLabel.setFont(font);
        emailField = new JTextField("Arjean@gmail.com");
        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);

        passwordLabel.setFont(font);
        passwordField = new JPasswordField("123");
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

        container = getContentPane();
        container.setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SetBounds();
        AddComponents();
    }

    public void SetBounds() {
        welcomeLabel.setBounds(190, 180, 500, 50);
        SubLabel.setBounds(240, 200, 500, 50);
        Login.setBounds(260, 10, 600, 30);
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            boolean success = authenticate(email, password);
            if (success) {
                JOptionPane.showMessageDialog(null, "Login successful!");
                showAccountInfo(email);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect email or password.");
            }
        }
    }

    private boolean authenticate(String email, String password) {
        File file = new File(filename1.toString());
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String storedEmail = parts[0];
                String storedPassword = parts[1];
                if (storedEmail.equals(email) && storedPassword.equals(password)) {
                    scanner.close();
                    return true;
                }
            }
            scanner.close();
            return false;
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: users.txt file not found.");
            return false;
        }
    }

    private void showAccountInfo(String email) {
        File file = new File(filename1.toString());
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String storedEmail = parts[0];
                if (storedEmail.equals(email)) {
                    String name = parts[2];
                    JFrame accountFrame = new JFrame("Welcome " + name + " (Instructor)");
                    JTable InfoJTable = new JTable();
                    JScrollPane scrollPane = new JScrollPane(InfoJTable);

                    MyPanel myPanel = new MyPanel();
                    myPanel.setSize(accountFrame.getSize());
                    accountFrame.setContentPane(myPanel);
                    accountFrame.setSize(1500, 600);
                    accountFrame.setLayout(null);
                    accountFrame.setResizable(false);
                    accountFrame.setLocationRelativeTo(null);
                    accountFrame.setVisible(true);
                    accountFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    accountFrame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {

                            int confirmed = JOptionPane.showConfirmDialog(null,
                                    "Are you sure you want to exit the program?", "Exit Program Message Box",
                                    JOptionPane.YES_NO_OPTION);

                            if (confirmed == JOptionPane.YES_OPTION) {
                                accountFrame.dispose();
                            }
                        }
                    });

                    JButton LogOut = new JButton("Log out");
                    LogOut.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            MainMenu firstsPage = new MainMenu();
                            firstsPage.setSize(700, 600);
                            firstsPage.setVisible(true);
                            accountFrame.dispose();
                        }
                    });

                    ImageIcon originalImageIcon = new ImageIcon("Final_Project/image/Icon.png");
                    Image originalImage = originalImageIcon.getImage();

                    Image scaledImage = originalImage.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
                    ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                    imageLabel = new JLabel(scaledImageIcon);

                    JButton ShowStudent = new JButton("Show Student List");
                    ShowStudent.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            readProperties();
                            File studentFile = new File(filename.toString());
                            try {
                                Scanner studentScanner = new Scanner(studentFile);
                                ;
                                String[] columnNames = { "Name", "ID", "Phone", "Gender", "Birthdate",
                                        "Address" };
                                DefaultTableModel model = new DefaultTableModel(columnNames, 0);

                                while (studentScanner.hasNextLine()) {
                                    String studentLine = studentScanner.nextLine();
                                    String[] studentParts = studentLine.split(",");

                                    String firstName = studentParts[0];
                                    String middleName = studentParts[2];
                                    String lastName = studentParts[1];
                                    String fullName = String.format("%s %s. %s", firstName, middleName, lastName);

                                    String email = studentParts[3];

                                    String phoneNumber = studentParts[4];
                                    String gender = studentParts[7];
                                    String birthdate = studentParts[8];
                                    String Year = studentParts[9];
                                    String address = studentParts[10];

                                    String BDAY = String.format("%s, %s ", birthdate, Year);

                                    Object[] rowData = { fullName, email, phoneNumber, gender, BDAY,
                                            address };
                                    model.addRow(rowData);
                                }
                                studentScanner.close();
                                InfoJTable.setModel(model);
                                studentScanner.close();
                            } catch (FileNotFoundException ex) {
                                JOptionPane.showMessageDialog(null, "Error: student_list.txt file not found.");
                            }
                        }
                    });

                    JButton AddStudent = new JButton("Add Student");

                    JButton DeleteStudent = new JButton("Delete Student");

                    JButton Evaluation = new JButton("Evaluation");

                    imageLabel.setBounds(60, 20, 130, 130);
                    scrollPane.setBounds(220, 20, 1215, 485);
                    ShowStudent.setBounds(50, 180, 150, 25);
                    AddStudent.setBounds(50, 220, 150, 25);
                    DeleteStudent.setBounds(50, 260, 150, 25);
                    Evaluation.setBounds(50, 300, 150, 25);
                    LogOut.setBounds(50, 480, 150, 25);

                    accountFrame.add(imageLabel);
                    accountFrame.add(scrollPane);
                    accountFrame.add(ShowStudent);
                    accountFrame.add(AddStudent);
                    accountFrame.add(DeleteStudent);
                    accountFrame.add(Evaluation);
                    accountFrame.add(LogOut);

                    scanner.close();
                    return;
                }
            }
            scanner.close();
            JOptionPane.showMessageDialog(null, "Error: email not found.");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: users.txt file not found.");
        }
    }
    /*
     * public static void main(String[] args) {
     * InstructorLoginForm Frame = new InstructorLoginForm();
     * Frame.setTitle("Occidental Mindoro State College - Instructor");
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

}
