package Main;

import Sub.SciCal;
import Sub.Table.*;
import Sub.Paint;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Main.Exams.ExamMenu;

import java.io.FileReader;
import java.io.FileWriter;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Font;
import java.awt.Container;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

public class StudentLoginForm extends JFrame implements ActionListener {
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
            filename1 = props.getProperty("Student_Enrollment");
            System.out.println("Student_Enrollment = " + filename1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StudentLoginForm() {
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
        Login = new JLabel("Student - Login");
        Login.setFont(new Font("Courier", Font.BOLD, 20));
        Login.setForeground(Color.WHITE);

        emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);

        emailLabel.setFont(font);
        emailField = new JTextField();
        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);

        passwordLabel.setFont(font);
        passwordField = new JPasswordField();
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
        Login.setBounds(270, 10, 600, 30);
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
        File file = new File(filename.toString());
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String storedEmail = parts[3];
                String storedPassword = parts[6];
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
        File file = new File(filename.toString());
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String storedEmail = parts[3];
                if (storedEmail.equals(email)) {
                    String firstName = parts[0];
                    String lastName = parts[1];
                    String middlename = parts[2];
                    JFrame accountFrame = new JFrame(lastName + ", " + firstName + " Student - Data");
                    JTable InfoJTable = new JTable();
                    JScrollPane scrollPane = new JScrollPane(InfoJTable);
                    MyPanel myPanel = new MyPanel();
                    myPanel.setSize(accountFrame.getSize());
                    accountFrame.setContentPane(myPanel);
                    accountFrame.setSize(700, 600);
                    accountFrame.setLayout(null);
                    accountFrame.setResizable(false);
                    accountFrame.setLocationRelativeTo(null);

                    accountFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    accountFrame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            int confirmed = JOptionPane.showConfirmDialog(null,
                                    "Are you sure you want to exit the program?", "Exit Program Message Box",
                                    JOptionPane.YES_NO_OPTION);

                            if (confirmed == JOptionPane.YES_OPTION) {
                                Window[] windows = Window.getWindows();
                                for (Window window : windows) {
                                    if (window != accountFrame) {
                                        window.dispose();
                                    }
                                }
                                accountFrame.dispose();
                            }
                        }
                    });

                    ImageIcon originalImageIcon = new ImageIcon("Final_Project/image/Icon.png");
                    Image originalImage = originalImageIcon.getImage();

                    Image scaledImage = originalImage.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
                    ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                    imageLabel = new JLabel(scaledImageIcon);
                    imageLabel.setBounds(505, 20, 130, 130);
                    accountFrame.add(imageLabel);

                    JLabel StudentInfo = new JLabel(
                            "Student's Information");
                    StudentInfo.setForeground(Color.WHITE);

                    JLabel Welc = new JLabel("Welcome: " + firstName + " " + middlename + ". " + lastName);
                    Welc.setForeground(Color.WHITE);

                    JLabel Tools = new JLabel("Tools");
                    Tools.setForeground(Color.white);

                    JLabel UtilityTools = new JLabel("Utility Tools");
                    UtilityTools.setForeground(Color.white);

                    JButton StudentProfile = new JButton("Student Profiles");
                    StudentProfile.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            JFrame profileFrame = new JFrame("Student Profile - " + lastName + ", " + firstName);
                            MyPanel panel = new MyPanel();

                            profileFrame.setLocationRelativeTo(StudentProfile);
                            profileFrame.setContentPane(panel);
                            panel.setLayout(null);
                            JLabel SProf = new JLabel(
                                    "Student's Profiles");
                            SProf.setForeground(Color.WHITE);
                            JTable StudentDataTable = new JTable();
                            JScrollPane scrollPane1 = new JScrollPane(StudentDataTable);

                            JButton PersonalInfo = new JButton("Personal Information");
                            PersonalInfo.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    readProperties();
                                    File studentFile = new File(filename.toString());
                                    try {
                                        Scanner studentScanner = new Scanner(studentFile);
                                        String[] columnNames = { "Data", "Personal Information" };
                                        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

                                        while (studentScanner.hasNextLine()) {
                                            String studentLine = studentScanner.nextLine();
                                            String[] studentParts = studentLine.split(",");

                                            String firstName = studentParts[0];
                                            String middleName = studentParts[2];
                                            String lastName = studentParts[1];
                                            String fullName = String.format("%s %s. %s", firstName, middleName,
                                                    lastName);

                                            String email = studentParts[3];
                                            String phoneNumber = studentParts[4];
                                            String gender = studentParts[7];
                                            String birthdate = studentParts[8];
                                            String Year = studentParts[9];
                                            String address = studentParts[10];
                                            String BDAY = String.format("%s, %s ", birthdate, Year);

                                            if (email.equals(storedEmail)) {
                                                Object[][] rowData = {
                                                        { "Name ", fullName },
                                                        { "Email ", email },
                                                        { "Phone ", phoneNumber },
                                                        { "Gender ", gender },
                                                        { "Birthday ", BDAY },
                                                        { "Address ", address }
                                                };
                                                for (Object[] row : rowData) {
                                                    model.addRow(row);
                                                }
                                            }
                                        }

                                        studentScanner.close();
                                        StudentDataTable.setModel(model);
                                    } catch (FileNotFoundException ex) {
                                        JOptionPane.showMessageDialog(null, "Error: student_list.txt file not found.");
                                    }
                                }
                            });

                            // this table shoud've bean editable
                            JButton EnrollData = new JButton("Enrollment Data");
                            EnrollData.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String[] columnNames = { "Data", "Personal Information" };
                                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                                    if (email.equals(storedEmail)) {
                                        Object[][] rowData = {
                                                { "Course ", " " },
                                                { "Curriculum ", " " },
                                                { "Level ", " " },
                                                { "Department ", " " },
                                                { "Entry Period ", " " },
                                                { "Entry Date ", " " },
                                                { "Learner Ref. No ", " " },
                                                { "Freshman ", " " },
                                                { "Transferee ", " " },
                                                { "New Student ", " " },
                                                { "Regular", " " }

                                        };
                                        for (Object[] row : rowData) {
                                            model.addRow(row);
                                        }
                                    }
                                    StudentDataTable.setModel(model);

                                }
                            });

                            // this table shoud've bean editable
                            JButton EducationalBackG = new JButton("Educational Background");
                            EducationalBackG.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String[] columnNames = { "Data", "Name of the  School" };
                                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                                    if (email.equals(storedEmail)) {
                                        Object[][] rowData = {
                                                { "Graduate ", " " },
                                                { "College ", " " },
                                                { "Senior High ", " " },
                                                { "Junior High ", " " },
                                                { "Elementary ", " " },
                                                { "Primary ", " " },

                                        };
                                        for (Object[] row : rowData) {
                                            model.addRow(row);
                                        }
                                    }
                                    StudentDataTable.setModel(model);

                                }
                            });

                            // this table shoud've bean editable
                            JButton ReligiousBackG = new JButton("Religious Background");
                            ReligiousBackG.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String[] columnNames = { "Data", " " };
                                    DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
                                        @Override
                                        public Class<?> getColumnClass(int columnIndex) {
                                            if (columnIndex == 1) {
                                                return Boolean.class;
                                            }
                                            return super.getColumnClass(columnIndex);
                                        }
                                    };
                                    if (email.equals(storedEmail)) {
                                        Object[][] rowData = {
                                                { "Religion ", " " },
                                                { "Church Marriage (Parents) ", false },
                                                { "Baptized ", false },
                                                { "First Communion ", false },
                                        };
                                        for (Object[] row : rowData) {
                                            model.addRow(row);
                                        }
                                    }
                                    StudentDataTable.setModel(model);
                                    StudentDataTable.getColumnModel().getColumn(1)
                                            .setCellRenderer(new DefaultTableCellRenderer() {
                                                private final JCheckBox checkbox = new JCheckBox();

                                                @Override
                                                public Component getTableCellRendererComponent(JTable table,
                                                        Object value,
                                                        boolean isSelected, boolean hasFocus, int row, int column) {
                                                    checkbox.setSelected((Boolean) value);
                                                    return checkbox;
                                                }
                                            });
                                }
                            });

                            JButton MedicalInfo = new JButton("Medical Information");
                            MedicalInfo.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String[] columnNames = { "Data", " " };
                                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                                    if (email.equals(storedEmail)) {
                                        Object[][] rowData = {
                                                { "Medical Status ", " " },
                                                { "Physician ", " " },
                                                { "Insidents ", " " },
                                                { "Remarks ", " " },

                                        };
                                        for (Object[] row : rowData) {
                                            model.addRow(row);
                                        }
                                    }
                                    StudentDataTable.setModel(model);

                                }
                            });

                            JButton EmploymentRec = new JButton("Employment Records");

                            JButton SaveData = new JButton("Save Data");

                            Font Title = new Font("Courier", Font.BOLD, 25);
                            SProf.setFont(Title);

                            // Set Bounds
                            SProf.setBounds(265, 20, 415, 25);
                            scrollPane1.setBounds(220, 50, 415, 500);
                            PersonalInfo.setBounds(50, 50, 150, 25);
                            EnrollData.setBounds(50, 90, 150, 25);
                            EducationalBackG.setBounds(50, 130, 150, 25);
                            ReligiousBackG.setBounds(50, 170, 150, 25);
                            MedicalInfo.setBounds(50, 210, 150, 25);
                            EmploymentRec.setBounds(50, 250, 150, 25);
                            SaveData.setBounds(50, 330, 150, 25);

                            // Add Components
                            profileFrame.add(SProf);
                            profileFrame.add(scrollPane1);
                            profileFrame.add(PersonalInfo);
                            profileFrame.add(EnrollData);
                            profileFrame.add(EducationalBackG);
                            profileFrame.add(ReligiousBackG);
                            profileFrame.add(MedicalInfo);
                            profileFrame.add(EmploymentRec);
                            profileFrame.add(SaveData);

                            // Frame Settings
                            profileFrame.setLayout(null);
                            profileFrame.setResizable(false);
                            profileFrame.setSize(700, 600);
                            profileFrame.setVisible(true);
                            profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        }
                    });

                    // this shit doesnt work man(25/04/2023) / now it works hahas(27/04/2023 - Nics
                    JButton ChangePass = new JButton("Change Pass");
                    ChangePass.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            readProperties();
                            JFrame frame = new JFrame("Change Password");

                            MyPanel myPanel = new MyPanel();
                            myPanel.setSize(frame.getSize());
                            frame.setContentPane(myPanel);
                            frame.setResizable(false);
                            JPanel panel = new JPanel(new GridLayout(3, 2));
                            panel.setOpaque(false);
                            JTextField newPassword = new JTextField();
                            newPassword.setForeground(Color.WHITE);
                            JTextField confirmPassword = new JTextField();
                            confirmPassword.setForeground(Color.WHITE);

                            JLabel newPasswordLabel = new JLabel("New Password: ");
                            JLabel confirmPasswordLabel = new JLabel("Confirm Password: ");
                            JButton confirmButton = new JButton("Confirm");

                            panel.add(newPasswordLabel);
                            panel.add(newPassword);
                            panel.add(confirmPasswordLabel);
                            panel.add(confirmPassword);
                            panel.add(confirmButton);
                            confirmButton.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        readProperties();
                                        String newPasswordText = newPassword.getText();
                                        String confirmNewPasswordText = confirmPassword.getText();

                                        if (!newPasswordText.equals(confirmNewPasswordText)) {
                                            JOptionPane.showMessageDialog(null, "Passwords do not match!");
                                            return;
                                        }

                                        if (newPasswordText.equals("") || confirmNewPasswordText.equals("")) {
                                            JOptionPane.showMessageDialog(null, "Please fill up all fields!");
                                            return;
                                        }

                                        File file = new File(filename);
                                        BufferedReader br = new BufferedReader(new FileReader(file));
                                        StringBuilder sb = new StringBuilder();
                                        String line;

                                        while ((line = br.readLine()) != null) {
                                            String[] fields = line.split(",");
                                            if (fields.length >= 7) {
                                                String email = fields[3];
                                                if (email.equals(storedEmail)) {
                                                    fields[6] = newPasswordText;
                                                }
                                            }
                                            sb.append(String.join(",", fields));
                                            sb.append(System.lineSeparator());
                                        }
                                        br.close();

                                        FileWriter writer = new FileWriter(file);
                                        writer.write(sb.toString());
                                        writer.close();

                                        JOptionPane.showMessageDialog(null, "Password changed successfully!");
                                        frame.dispose();
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            });
                            frame.getContentPane().add(panel);
                            frame.pack();
                            frame.setVisible(true);
                        }
                    });

                    JSeparator separator = new JSeparator();
                    separator.setForeground(Color.WHITE);

                    JButton activitiesButton = new JButton("Activities");
                    activitiesButton.setVisible(false);
                    activitiesButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // ActivitiesTableModel newTableModel = new ActivitiesTableModel();
                            // InfoJTable.setModel(newTableModel);
                        }
                    });

                    JButton quizzesButton = new JButton("Quizzes");
                    quizzesButton.setVisible(false);
                    quizzesButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // QuizzesTableModel newTableModel = new QuizzesTableModel();
                            // InfoJTable.setModel(newTableModel);
                        }
                    });

                    JButton examButton = new JButton("Exam");
                    examButton.setVisible(false);
                    examButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ExamMenu examMenu = new ExamMenu();
                            examMenu.setTitle("Occidental Mindoro State College - Exam Menu");
                            examMenu.setSize(700, 600);
                            examMenu.setLocationRelativeTo(null);
                            examMenu.setResizable(false);
                            examMenu.setVisible(true);
                        }
                    });

                    JButton Modules = new JButton("Modules");
                    Modules.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Modules newTableModel = new Modules();
                            InfoJTable.setModel(newTableModel);
                            activitiesButton.setVisible(false);
                            quizzesButton.setVisible(false);
                            examButton.setVisible(false);
                        }
                    });

                    JButton OnlineTask = new JButton("Online Task");
                    OnlineTask.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Set the visibility of the three buttons to true
                            activitiesButton.setVisible(true);
                            quizzesButton.setVisible(true);
                            examButton.setVisible(true);

                            // Update the table model
                            OnlineTask newTableModel = new OnlineTask();
                            InfoJTable.setModel(newTableModel);
                        }
                    });

                    JSeparator separator2 = new JSeparator();
                    separator2.setForeground(Color.WHITE);

                    JButton EnrolledSubject = new JButton("Enrolled Subjects");
                    EnrolledSubject.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            EnrolledSub newTableModel = new EnrolledSub();
                            InfoJTable.setModel(newTableModel);
                            activitiesButton.setVisible(false);
                            quizzesButton.setVisible(false);
                            examButton.setVisible(false);
                        }
                    });

                    JButton ClassAbsence = new JButton("Class Absences");
                    ClassAbsence.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ClassAbs newTableModel = new ClassAbs();
                            InfoJTable.setModel(newTableModel);
                            activitiesButton.setVisible(false);
                            quizzesButton.setVisible(false);
                            examButton.setVisible(false);
                        }
                    });

                    JButton CurriculumEva = new JButton("Curriculum Evaluation");
                    CurriculumEva.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            CurriculumEvaluation newTableModel = new CurriculumEvaluation();
                            InfoJTable.setModel(newTableModel);
                            activitiesButton.setVisible(false);
                            quizzesButton.setVisible(false);
                            examButton.setVisible(false);
                        }
                    });

                    JSeparator separator3 = new JSeparator();
                    separator3.setForeground(Color.WHITE);

                    JButton Paint = new JButton("Paint");
                    Paint.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Paint Paints = new Paint();
                            Paints.setSize(1500, 1000);
                            Paints.setVisible(true);
                            dispose();
                        }
                    });

                    JButton Calcu = new JButton("Sci Calculator");
                    Calcu.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            SciCal CalculatorgUI = new SciCal();
                            CalculatorgUI.setSize(300, 400);
                            CalculatorgUI.setVisible(true);
                            dispose();

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

                    // Fonts
                    Font Title = new Font("Courier", Font.BOLD, 25);
                    Font labelFont = new Font("Courier", ABORT, 20);
                    StudentInfo.setFont(Title);
                    Welc.setFont(labelFont);
                    emailLabel.setFont(labelFont);
                    Tools.setFont(labelFont);
                    UtilityTools.setFont(labelFont);
                    // SetBounds
                    StudentInfo.setBounds(233, 10, 400, 25);
                    Welc.setBounds(50, 40, 400, 30);
                    Tools.setBounds(100, 70, 150, 25);
                    UtilityTools.setBounds(240, 70, 150, 25);
                    StudentProfile.setBounds(50, 100, 150, 25);
                    ChangePass.setBounds(50, 140, 150, 25);
                    separator.setBounds(50, 180, 150, 10);
                    Modules.setBounds(50, 200, 150, 25);
                    OnlineTask.setBounds(50, 240, 150, 25);
                    separator2.setBounds(50, 280, 150, 10);
                    scrollPane.setBounds(220, 180, 415, 285);
                    EnrolledSubject.setBounds(50, 300, 150, 25);
                    ClassAbsence.setBounds(50, 340, 150, 25);
                    CurriculumEva.setBounds(50, 380, 150, 25);
                    separator3.setBounds(50, 420, 150, 10);
                    Paint.setBounds(220, 100, 150, 25);
                    Calcu.setBounds(220, 140, 150, 25);
                    LogOut.setBounds(50, 440, 150, 25);
                    activitiesButton.setBounds(220, 480, 100, 25);
                    quizzesButton.setBounds(380, 480, 100, 25);
                    examButton.setBounds(535, 480, 100, 25);

                    // AddComponents
                    accountFrame.add(StudentInfo);
                    accountFrame.add(Welc);
                    accountFrame.add(Tools);
                    accountFrame.add(UtilityTools);
                    accountFrame.add(StudentProfile);
                    accountFrame.add(ChangePass);
                    accountFrame.add(separator);
                    accountFrame.add(Modules);
                    accountFrame.add(OnlineTask);
                    accountFrame.add(activitiesButton);
                    accountFrame.add(quizzesButton);
                    accountFrame.add(examButton);
                    accountFrame.add(separator2);
                    accountFrame.add(scrollPane);
                    accountFrame.add(EnrolledSubject);
                    accountFrame.add(ClassAbsence);
                    accountFrame.add(CurriculumEva);
                    accountFrame.add(separator3);
                    accountFrame.add(Paint);
                    accountFrame.add(Calcu);
                    accountFrame.add(LogOut);
                    accountFrame.setVisible(true);
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
     * StudentLoginForm Frame = new StudentLoginForm();
     * Frame.setTitle("Occidental Mindoro State College - Student");
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