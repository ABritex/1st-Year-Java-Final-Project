package Main.Exams;

import Sub.Questions;
import java.util.Properties;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;
import javax.swing.*;

import Main.StudentRegisterForm;

public class JavaExam extends JFrame implements ActionListener {
        static String Questions;
        static String Choice;
        static String Choice1;
        static String Answers;
        static String Answers1;
        static Scanner s = new Scanner(System.in);
        int score;
        JLabel[] questionLabels = new JLabel[45];
        JLabel[] answerLabels1 = new JLabel[45];
        JLabel[] answerLabels2 = new JLabel[45];
        JRadioButton[][] choiceButtons = new JRadioButton[45][4];
        ButtonGroup[] choiceGroups = new ButtonGroup[45];
        int questionNum;

        public void readProperties() {
                Properties props = new Properties();
                try (InputStream is = StudentRegisterForm.class.getResourceAsStream("/.env")) {
                        props.load(is);
                        Questions = props.getProperty("Question");
                        System.out.println("Question = " + Questions);

                        Choice = props.getProperty("Choice");
                        System.out.println("Choice = " + Choice);
                        Choice1 = props.getProperty("Choice1");
                        System.out.println("Choice1 = " + Choice1);
                        Answers = props.getProperty("Answers");
                        System.out.println("Answers = " + Answers);

                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        public JavaExam() {

                try {
                        JPanel panel = new JPanel();
                        setContentPane(panel);
                        panel.setLayout(null);
                        panel.setVisible(true);

                        Path P = Paths.get(Questions.toString());
                        InputStream I = Files.newInputStream(P);
                        BufferedReader R = new BufferedReader(new InputStreamReader(I));

                        Path P1 = Paths.get(Choice.toString());
                        InputStream I1 = Files.newInputStream(P1);
                        BufferedReader R1 = new BufferedReader(new InputStreamReader(I1));

                        Path P2 = Paths.get(Choice1.toString());
                        InputStream I2 = Files.newInputStream(P2);
                        BufferedReader R2 = new BufferedReader(new InputStreamReader(I2));

                        Path P3 = Paths.get(Answers.toString());
                        InputStream I3 = Files.newInputStream(P3);
                        BufferedReader R3 = new BufferedReader(new InputStreamReader(I3));

                        // Path P4 = Paths.get(Answers1.toString());
                        // InputStream I4 = Files.newInputStream(P4);
                        // BufferedReader R4 = new BufferedReader(new InputStreamReader(I4));

                        // String answ[] = new String[45];
                        String A[] = new String[45];
                        Questions[] question = {
                                        new Questions(A[0] = R.readLine(), A[0] = R1.readLine(), A[0] = R2.readLine(),
                                                        A[0] = R3.readLine()),
                                        new Questions(A[1] = R.readLine(), A[1] = R1.readLine(), A[1] = R2.readLine(),
                                                        A[1] = R3.readLine()),
                                        new Questions(A[2] = R.readLine(), A[2] = R1.readLine(), A[2] = R2.readLine(),
                                                        A[2] = R3.readLine()),
                                        new Questions(A[3] = R.readLine(), A[3] = R1.readLine(), A[3] = R2.readLine(),
                                                        A[3] = R3.readLine()),
                                        new Questions(A[4] = R.readLine(), A[4] = R1.readLine(), A[4] = R2.readLine(),
                                                        A[4] = R3.readLine()),
                                        new Questions(A[5] = R.readLine(), A[5] = R1.readLine(), A[5] = R2.readLine(),
                                                        A[5] = R3.readLine()),
                                        new Questions(A[6] = R.readLine(), A[6] = R1.readLine(), A[6] = R2.readLine(),
                                                        A[6] = R3.readLine()),
                                        new Questions(A[7] = R.readLine(), A[7] = R1.readLine(), A[7] = R2.readLine(),
                                                        A[7] = R3.readLine()),
                                        new Questions(A[8] = R.readLine(), A[8] = R1.readLine(), A[8] = R2.readLine(),
                                                        A[8] = R3.readLine()),
                                        new Questions(A[9] = R.readLine(), A[9] = R1.readLine(), A[9] = R2.readLine(),
                                                        A[9] = R3.readLine()),
                                        new Questions(A[10] = R.readLine(), A[10] = R1.readLine(),
                                                        A[10] = R2.readLine(), A[10] = R3.readLine()),
                                        new Questions(A[11] = R.readLine(), A[11] = R1.readLine(),
                                                        A[11] = R2.readLine(), A[11] = R3.readLine()),
                                        new Questions(A[12] = R.readLine(), A[12] = R1.readLine(),
                                                        A[12] = R2.readLine(), A[12] = R3.readLine()),
                                        new Questions(A[13] = R.readLine(), A[13] = R1.readLine(),
                                                        A[13] = R2.readLine(), A[13] = R3.readLine()),
                                        new Questions(A[14] = R.readLine(), A[14] = R1.readLine(),
                                                        A[14] = R2.readLine(), A[14] = R3.readLine()),
                                        new Questions(A[15] = R.readLine(), A[15] = R1.readLine(),
                                                        A[15] = R2.readLine(), A[15] = R3.readLine()),
                                        new Questions(A[16] = R.readLine(), A[16] = R1.readLine(),
                                                        A[16] = R2.readLine(), A[16] = R3.readLine()),
                                        new Questions(A[17] = R.readLine(), A[17] = R1.readLine(),
                                                        A[17] = R2.readLine(), A[17] = R3.readLine()),
                                        new Questions(A[18] = R.readLine(), A[18] = R1.readLine(),
                                                        A[18] = R2.readLine(), A[18] = R3.readLine()),
                                        new Questions(A[19] = R.readLine(), A[19] = R1.readLine(),
                                                        A[19] = R2.readLine(), A[19] = R3.readLine()),
                                        new Questions(A[20] = R.readLine(), A[20] = R1.readLine(),
                                                        A[20] = R2.readLine(), A[20] = R3.readLine()),
                                        new Questions(A[21] = R.readLine(), A[21] = R1.readLine(),
                                                        A[21] = R2.readLine(), A[21] = R3.readLine()),
                                        new Questions(A[22] = R.readLine(), A[22] = R1.readLine(),
                                                        A[22] = R2.readLine(), A[22] = R3.readLine()),
                                        new Questions(A[23] = R.readLine(), A[23] = R1.readLine(),
                                                        A[23] = R2.readLine(), A[23] = R3.readLine()),
                                        new Questions(A[24] = R.readLine(), A[24] = R1.readLine(),
                                                        A[24] = R2.readLine(), A[24] = R3.readLine()),
                                        new Questions(A[25] = R.readLine(), A[25] = R1.readLine(),
                                                        A[25] = R2.readLine(), A[25] = R3.readLine()),
                                        new Questions(A[26] = R.readLine(), A[26] = R1.readLine(),
                                                        A[26] = R2.readLine(), A[26] = R3.readLine()),
                                        new Questions(A[27] = R.readLine(), A[27] = R1.readLine(),
                                                        A[27] = R2.readLine(), A[27] = R3.readLine()),
                                        new Questions(A[28] = R.readLine(), A[28] = R1.readLine(),
                                                        A[28] = R2.readLine(), A[28] = R3.readLine()),
                                        new Questions(A[29] = R.readLine(), A[29] = R1.readLine(),
                                                        A[29] = R2.readLine(), A[29] = R3.readLine()),
                                        new Questions(A[30] = R.readLine(), A[30] = R1.readLine(),
                                                        A[30] = R2.readLine(), A[30] = R3.readLine()),
                                        new Questions(A[31] = R.readLine(), A[31] = R1.readLine(),
                                                        A[31] = R2.readLine(), A[31] = R3.readLine()),
                                        new Questions(A[32] = R.readLine(), A[32] = R1.readLine(),
                                                        A[32] = R2.readLine(), A[32] = R3.readLine()),
                                        new Questions(A[33] = R.readLine(), A[33] = R1.readLine(),
                                                        A[33] = R2.readLine(), A[33] = R3.readLine()),
                                        new Questions(A[34] = R.readLine(), A[34] = R1.readLine(),
                                                        A[34] = R2.readLine(), A[34] = R3.readLine()),
                                        new Questions(A[35] = R.readLine(), A[35] = R1.readLine(),
                                                        A[35] = R2.readLine(), A[35] = R3.readLine()),
                                        new Questions(A[36] = R.readLine(), A[36] = R1.readLine(),
                                                        A[36] = R2.readLine(), A[36] = R3.readLine()),
                                        new Questions(A[37] = R.readLine(), A[37] = R1.readLine(),
                                                        A[37] = R2.readLine(), A[37] = R3.readLine()),
                                        new Questions(A[38] = R.readLine(), A[38] = R1.readLine(),
                                                        A[38] = R2.readLine(), A[38] = R3.readLine()),
                                        new Questions(A[39] = R.readLine(), A[39] = R1.readLine(),
                                                        A[39] = R2.readLine(), A[39] = R3.readLine()),
                                        new Questions(A[40] = R.readLine(), A[40] = R1.readLine(),
                                                        A[40] = R2.readLine(), A[40] = R3.readLine()),
                                        new Questions(A[41] = R.readLine(), A[41] = R1.readLine(),
                                                        A[41] = R2.readLine(), A[41] = R3.readLine()),
                                        new Questions(A[42] = R.readLine(), A[42] = R1.readLine(),
                                                        A[42] = R2.readLine(), A[42] = R3.readLine()),
                                        new Questions(A[43] = R.readLine(), A[43] = R1.readLine(),
                                                        A[43] = R2.readLine(), A[43] = R3.readLine()),
                                        new Questions(A[44] = R.readLine(), A[44] = R1.readLine(),
                                                        A[44] = R2.readLine(), A[44] = R3.readLine())
                        };

                        for (int i = 0; i < 45; i++) {
                                questionLabels[i] = new JLabel(question[i].Answer);
                                questionLabels[i].setBounds(50, 50, 400, 30);
                                panel.add(questionLabels[i]);

                                answerLabels1[i] = new JLabel(question[i].Choice);
                                answerLabels1[i].setBounds(50, 70, 400, 30);
                                panel.add(answerLabels1[i]);

                                answerLabels2[i] = new JLabel(question[i].Choice1);
                                answerLabels2[i].setBounds(50, 90, 400, 30);
                                panel.add(answerLabels2[i]);

                                choiceButtons[i][0] = new JRadioButton("");
                                choiceButtons[i][0].setBounds(45, 75, 20, 20);
                                panel.add(choiceButtons[i][0]);

                                choiceButtons[i][1] = new JRadioButton("");
                                choiceButtons[i][1].setBounds(190, 75, 20, 20);
                                panel.add(choiceButtons[i][1]);

                                choiceButtons[i][2] = new JRadioButton("");
                                choiceButtons[i][2].setBounds(45, 95, 20, 20);
                                panel.add(choiceButtons[i][2]);

                                choiceButtons[i][3] = new JRadioButton("");
                                choiceButtons[i][3].setBounds(190, 95, 20, 20);
                                panel.add(choiceButtons[i][3]);

                                choiceGroups[i] = new ButtonGroup();
                                choiceGroups[i].add(choiceButtons[i][0]);
                                choiceGroups[i].add(choiceButtons[i][1]);
                                choiceGroups[i].add(choiceButtons[i][2]);
                                choiceGroups[i].add(choiceButtons[i][3]);

                                JButton submitButton = new JButton("Submit");
                                submitButton.setBounds(200, 220, 100, 30);
                                panel.add(submitButton);

                                questionNum = i;
                                submitButton.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                                String answer = "";
                                                if (choiceButtons[questionNum][0].isSelected()) {
                                                        answer = "A";
                                                } else if (choiceButtons[questionNum][1].isSelected()) {
                                                        answer = "B";
                                                } else if (choiceButtons[questionNum][2].isSelected()) {
                                                        answer = "C";
                                                } else if (choiceButtons[questionNum][3].isSelected()) {
                                                        answer = "D";
                                                }
                                                if (answer.equalsIgnoreCase(question[questionNum].Prompt)) {
                                                        score++;
                                                }

                                                panel.remove(questionLabels[questionNum]);
                                                panel.remove(answerLabels1[questionNum]);
                                                panel.remove(answerLabels2[questionNum]);
                                                panel.remove(choiceButtons[questionNum][0]);
                                                panel.remove(choiceButtons[questionNum][1]);
                                                panel.remove(choiceButtons[questionNum][2]);
                                                panel.remove(choiceButtons[questionNum][3]);
                                                panel.remove(submitButton);
                                                questionNum++;
                                                if (questionNum < question.length) {
                                                        questionLabels[questionNum] = new JLabel(
                                                                        question[questionNum].Answer);
                                                        questionLabels[questionNum].setBounds(50, 50, 400, 30);
                                                        panel.add(questionLabels[questionNum]);
                                                        answerLabels1[questionNum] = new JLabel(
                                                                        question[questionNum].Choice);
                                                        answerLabels1[questionNum].setBounds(50, 70, 400, 30);
                                                        panel.add(answerLabels1[questionNum]);

                                                        answerLabels2[questionNum] = new JLabel(
                                                                        question[questionNum].Choice1);
                                                        answerLabels2[questionNum].setBounds(50, 90, 400, 30);
                                                        panel.add(answerLabels2[questionNum]);

                                                        choiceButtons[questionNum][0] = new JRadioButton("");
                                                        choiceButtons[questionNum][0].setBounds(45, 75, 20, 20);
                                                        panel.add(choiceButtons[questionNum][0]);

                                                        choiceButtons[questionNum][1] = new JRadioButton("");
                                                        choiceButtons[questionNum][1].setBounds(190, 75, 20, 20);
                                                        panel.add(choiceButtons[questionNum][1]);

                                                        choiceButtons[questionNum][2] = new JRadioButton("");
                                                        choiceButtons[questionNum][2].setBounds(45, 95, 20, 20);
                                                        panel.add(choiceButtons[questionNum][2]);

                                                        choiceButtons[questionNum][3] = new JRadioButton("");
                                                        choiceButtons[questionNum][3].setBounds(190, 95, 20, 20);
                                                        panel.add(choiceButtons[questionNum][3]);

                                                        choiceGroups[questionNum] = new ButtonGroup();
                                                        choiceGroups[questionNum].add(choiceButtons[questionNum][0]);
                                                        choiceGroups[questionNum].add(choiceButtons[questionNum][1]);
                                                        choiceGroups[questionNum].add(choiceButtons[questionNum][2]);
                                                        choiceGroups[questionNum].add(choiceButtons[questionNum][3]);

                                                        submitButton.setBounds(200, 220, 100, 30);
                                                        panel.add(submitButton);
                                                        panel.revalidate();
                                                        panel.repaint();
                                                } else {
                                                        JOptionPane.showMessageDialog(null,
                                                                        "Quiz is finished. Your score is " + score);
                                                }
                                        }
                                });

                        }
                } catch (Exception e) {

                }
        }

        public static void main(String[] args) {

                JavaExam exam = new JavaExam();
                exam.setLayout(null);
                exam.setSize(500, 300);
                exam.setDefaultCloseOperation(EXIT_ON_CLOSE);
                exam.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }

}
