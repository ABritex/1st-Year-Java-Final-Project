package Main;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.text.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;
import java.io.InputStream;

public class StudentRegisterForm extends JFrame {
    private JLabel SignUp, FirstName, LastName, MiddleName, Email, ReEmail, PhoneNumber, Code, Password, RePassword,
            Gender, BirthDate, Address, Term;
    private JTextField FirstNameText, LastNameText, MiddleNameText, EmailText, ReEmailText, PhoneNumberText, CodeText;
    private JPasswordField PasswordText, RePasswordText;
    private JButton SendCode;
    private JComboBox<String> Month, Day, Year;
    private JRadioButton Male, Female, Other;
    private JTextArea AdressText;
    private JCheckBox TermsNCondition;
    private JButton Submit, GoBack;
    String filename;
    Container container;

    public void readProperties() {
        Properties props = new Properties();
        try (InputStream is = StudentRegisterForm.class.getResourceAsStream("/.env")) {
            props.load(is);
            filename = props.getProperty("Student_Account");
            System.out.println("Student_Account = " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StudentRegisterForm() {
        MyPanel panel = new MyPanel();
        setContentPane(panel);
        panel.setLayout(null);

        SignUp = new JLabel("Personal Data");
        SignUp.setForeground(Color.WHITE);
        SignUp.setFont(new Font("Courier", Font.BOLD, 20));

        FirstName = new JLabel("First Name :");
        FirstName.setFont(new Font("Courier", ABORT, 15));
        FirstName.setForeground(Color.WHITE);
        FirstNameText = new JTextField();

        LastName = new JLabel("Last Name :");
        LastName.setFont(new Font("Courier", ABORT, 15));
        LastName.setForeground(Color.WHITE);
        LastNameText = new JTextField();

        MiddleName = new JLabel("Middle Initial :");
        MiddleName.setFont(new Font("Courier", ABORT, 15));
        MiddleName.setForeground(Color.WHITE);
        MiddleNameText = new JTextField();
        ((AbstractDocument) MiddleNameText.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                int currentLength = fb.getDocument().getLength();
                int finalLength = currentLength + text.length() - length;
                if (finalLength <= 1 && text.matches("[a-zA-Z]+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        Email = new JLabel("Email :");
        Email.setFont(new Font("Courier", ABORT, 15));
        Email.setForeground(Color.WHITE);
        EmailText = new JTextField();

        ReEmail = new JLabel("Re-enter Email :");
        ReEmail.setFont(new Font("Courier", ABORT, 15));
        ReEmail.setForeground(Color.WHITE);
        ReEmailText = new JTextField();

        PhoneNumber = new JLabel("Phone Number (+63) :");
        PhoneNumber.setFont(new Font("Courier", ABORT, 15));
        PhoneNumber.setForeground(Color.WHITE);
        PhoneNumberText = new JTextField();
        ((AbstractDocument) PhoneNumberText.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                if (string == null) {
                    return;
                }
                if ((fb.getDocument().getLength() + string.length()) <= 10) {
                    if (string.matches("[0-9]+")) {
                        super.insertString(fb, offset, string, attr);
                    }
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (text == null) {
                    return;
                }
                if ((fb.getDocument().getLength() + text.length() - length) <= 10) {
                    if (text.matches("[0-9]+")) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            }
        });

        Code = new JLabel("Code :");
        Code.setFont(new Font("Courier", ABORT, 15));
        Code.setForeground(Color.WHITE);
        CodeText = new JTextField();
        SendCode = new JButton("Send Code");

        Password = new JLabel("Password :");
        Password.setFont(new Font("Courier", ABORT, 15));
        Password.setForeground(Color.WHITE);
        PasswordText = new JPasswordField();

        RePassword = new JLabel("Re-enter Password :");
        RePassword.setFont(new Font("Courier", ABORT, 15));
        RePassword.setForeground(Color.WHITE);
        RePasswordText = new JPasswordField();

        Gender = new JLabel("Gender :");
        Gender.setFont(new Font("Courier", ABORT, 15));
        Gender.setForeground(Color.WHITE);
        Male = new JRadioButton("Male");
        Male.setForeground(Color.WHITE);
        Male.setOpaque(false);
        Female = new JRadioButton("Female");
        Female.setForeground(Color.WHITE);
        Female.setOpaque(false);
        Other = new JRadioButton("Others");
        Other.setForeground(Color.WHITE);
        Other.setOpaque(false);

        BirthDate = new JLabel("Birthdate :");
        BirthDate.setForeground(Color.WHITE);
        BirthDate.setFont(new Font("Courier", ABORT, 15));
        String[] month = { "January", "February", "March", "April", "June", "July", "August", "September", "October",
                "November", "December" };
        Month = new JComboBox<>(month);
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = Integer.toString(i);
        }
        Day = new JComboBox<>(days);
        String[] years = new String[120];
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 0; i < 120; i++) {
            years[i] = Integer.toString(currentYear - i);
        }
        Year = new JComboBox<>(years);

        Address = new JLabel("Address :");
        Address.setFont(new Font("Courier", ABORT, 15));
        Address.setForeground(Color.WHITE);
        AdressText = new JTextArea();

        TermsNCondition = new JCheckBox(
                "I accept the");
        TermsNCondition.setForeground(Color.WHITE);
        TermsNCondition.setOpaque(false);
        TermsNCondition.setFont(new Font("Courier", ABORT, 10));

        Term = new JLabel("<html><a href=''>terms & conditions</a></html>");
        Term.setForeground(Color.WHITE);
        Term.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Term.setFont(new Font("Courier", ABORT, 10));
        Term.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.example.com/terms-and-conditions"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        Submit = new JButton("Submit");
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = FirstNameText.getText();
                String lastName = LastNameText.getText();
                String middleName = MiddleNameText.getText();
                String email = EmailText.getText();
                String reEmail = ReEmailText.getText();
                String phoneNumber = PhoneNumberText.getText();
                String code = CodeText.getText();
                String password = new String(PasswordText.getPassword());
                String rePassword = new String(RePasswordText.getPassword());
                String gender = "";
                if (Male.isSelected()) {
                    gender = "Male";
                } else if (Female.isSelected()) {
                    gender = "Female";
                } else if (Other.isSelected()) {
                    gender = "Other";
                }

                String birthdate = Month.getSelectedItem().toString() + " " + Day.getSelectedItem().toString() + ", "
                        + Year.getSelectedItem().toString();
                String address = AdressText.getText();

                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || reEmail.isEmpty()
                        || phoneNumber.isEmpty()
                        || code.isEmpty() || password.isEmpty() || rePassword.isEmpty() || gender.isEmpty()
                        || birthdate.isEmpty()
                        || address.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
                    return;
                }

                if (!password.equals(rePassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match.");
                    return;
                }

                if (!email.equals(reEmail)) {
                    JOptionPane.showMessageDialog(null, "Emails do not match.");
                    return;
                }

                if (!email.endsWith("@gmail.com") && !email.endsWith("@yahoo.com") && !email.endsWith("@email.com")) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a valid email address");
                    return;
                }

                if (!phoneNumber.startsWith("9")) {
                    JOptionPane.showMessageDialog(null, "Not a Philippine Number");
                    return;
                }

                if (!TermsNCondition.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please accept the terms and conditions to continue.");
                    return;
                }

                Path file = Paths.get(filename.toString());
                try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                    writer.write(firstName + "," + lastName + "," + middleName + "," + email + "," + phoneNumber + ","
                            + code + "," + password + "," + gender + "," + birthdate + "," + address);
                    writer.newLine();
                    JOptionPane.showMessageDialog(null, "Your information has been saved to the file.");
                    FirstNameText.setText("");
                    LastNameText.setText("");
                    MiddleNameText.setText("");
                    EmailText.setText("");
                    ReEmailText.setText("");
                    PhoneNumberText.setText("");
                    CodeText.setText("");
                    PasswordText.setText("");
                    RePasswordText.setText("");
                    Male.setSelected(false);
                    Female.setSelected(false);
                    Other.setSelected(false);
                    Month.setSelectedIndex(0);
                    Day.setSelectedIndex(0);
                    Year.setSelectedIndex(0);
                    AdressText.setText("");
                    TermsNCondition.setSelected(false);
                    MainMenu firstPage = new MainMenu();
                    firstPage.setSize(700, 600);
                    firstPage.setVisible(true);
                    dispose();

                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred while saving your information to the file.");
                }
            }
        });

        GoBack = new JButton("Go Back");
        GoBack.addActionListener(new ActionListener() {
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
        SetBounds();
        AddComponents();
    }

    public void SetBounds() {
        SignUp.setBounds(280, 10, 600, 30);
        FirstName.setBounds(10, 60, 100, 25);
        FirstNameText.setBounds(10, 90, 130, 25);
        LastName.setBounds(180, 60, 100, 25);
        LastNameText.setBounds(180, 90, 130, 25);
        MiddleName.setBounds(10, 120, 100, 25);
        MiddleNameText.setBounds(10, 150, 130, 25);
        Email.setBounds(10, 180, 100, 25);
        EmailText.setBounds(10, 210, 300, 25);
        ReEmail.setBounds(10, 240, 140, 25);
        ReEmailText.setBounds(10, 270, 300, 25);
        PhoneNumber.setBounds(10, 300, 200, 25);
        PhoneNumberText.setBounds(10, 330, 300, 25);
        Code.setBounds(10, 360, 100, 25);
        CodeText.setBounds(10, 390, 180, 25);
        SendCode.setBounds(200, 390, 110, 25);
        Password.setBounds(370, 60, 100, 25);
        PasswordText.setBounds(370, 90, 300, 25);
        RePassword.setBounds(370, 120, 150, 25);
        RePasswordText.setBounds(370, 150, 300, 25);
        Gender.setBounds(370, 180, 100, 25);
        Male.setBounds(370, 210, 60, 25);
        Female.setBounds(440, 210, 70, 25);
        Other.setBounds(520, 210, 100, 25);
        BirthDate.setBounds(370, 240, 100, 25);
        Month.setBounds(370, 270, 80, 25);
        Day.setBounds(470, 270, 40, 25);
        Year.setBounds(530, 270, 80, 25);
        Address.setBounds(370, 300, 100, 25);
        AdressText.setBounds(370, 330, 300, 90);
        TermsNCondition.setBounds(10, 440, 82, 25);
        Term.setBounds(91, 440, 250, 25);
        Submit.setBounds(220, 480, 100, 36);
        GoBack.setBounds(360, 480, 100, 36);
    }

    public void AddComponents() {
        container.add(SignUp);
        container.add(FirstName);
        container.add(FirstNameText);
        container.add(LastName);
        container.add(LastNameText);
        container.add(MiddleName);
        container.add(MiddleNameText);
        container.add(Email);
        container.add(EmailText);
        container.add(ReEmail);
        container.add(ReEmailText);
        container.add(PhoneNumber);
        container.add(PhoneNumberText);
        container.add(Code);
        container.add(CodeText);
        container.add(SendCode);
        container.add(Password);
        container.add(PasswordText);
        container.add(RePassword);
        container.add(RePasswordText);
        container.add(Gender);
        container.add(Male);
        container.add(Female);
        container.add(Other);
        container.add(BirthDate);
        container.add(Month);
        container.add(Day);
        container.add(Year);
        container.add(Address);
        container.add(AdressText);
        container.add(TermsNCondition);
        container.add(Submit);
        container.add(Term);
        container.add(GoBack);

    }

    /*
     * public static void main(String[] Args) {
     * StudentRegisterForm Frame = new StudentRegisterForm();
     * Frame.setTitle("Occidental Mindoro State College - Admission");
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
