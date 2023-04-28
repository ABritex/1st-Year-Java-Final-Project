package Sub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SciCal extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPlus, btnMinus, btnDivide,
            btnMultiply, btnEquals, btnClear, btnDecimal, btnSquareRoot, btnPower;
    private double firstNumber, secondNumber;
    private String operation;
    private boolean decimalClicked;

    public SciCal() {
        setTitle("Scientific Calculator");
        setSize(300, 400);
        setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        btn0 = new JButton("0");
        panel.add(btn0);
        btn1 = new JButton("1");
        panel.add(btn1);
        btn2 = new JButton("2");
        panel.add(btn2);
        btn3 = new JButton("3");
        panel.add(btn3);
        btn4 = new JButton("4");
        panel.add(btn4);
        btn5 = new JButton("5");
        panel.add(btn5);
        btn6 = new JButton("6");
        panel.add(btn6);
        btn7 = new JButton("7");
        panel.add(btn7);
        btn8 = new JButton("8");
        panel.add(btn8);
        btn9 = new JButton("9");
        panel.add(btn9);
        btnPlus = new JButton("+");
        panel.add(btnPlus);
        btnMinus = new JButton("-");
        panel.add(btnMinus);
        btnDivide = new JButton("/");
        panel.add(btnDivide);
        btnMultiply = new JButton("*");
        panel.add(btnMultiply);
        btnEquals = new JButton("=");
        panel.add(btnEquals);
        btnClear = new JButton("C");
        panel.add(btnClear);
        btnDecimal = new JButton(".");
        panel.add(btnDecimal);
        btnSquareRoot = new JButton("sqrt");
        panel.add(btnSquareRoot);
        btnPower = new JButton("^");
        panel.add(btnPower);

        // add action listeners to each button
        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btnPlus.addActionListener(this);
        btnMinus.addActionListener(this);
        btnDivide.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnEquals.addActionListener(this);
        btnClear.addActionListener(this);
        btnDecimal.addActionListener(this);
        btnSquareRoot.addActionListener(this);
        btnPower.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("C")) {
            textField.setText("");
            firstNumber = 0;
            secondNumber = 0;
            operation = "";
            decimalClicked = false;
        } else if (command.equals("+")) {
            firstNumber = Double.parseDouble(textField.getText());
            operation = "+";
            textField.setText("");
            decimalClicked = false;
        } else if (command.equals("-")) {
            firstNumber = Double.parseDouble(textField.getText());
            operation = "-";
            textField.setText("");
            decimalClicked = false;
        } else if (command.equals("*")) {
            firstNumber = Double.parseDouble(textField.getText());
            operation = "*";
            textField.setText("");
            decimalClicked = false;
        } else if (command.equals("/")) {
            firstNumber = Double.parseDouble(textField.getText());
            operation = "/";
            textField.setText("");
            decimalClicked = false;
        } else if (command.equals("=")) {
            if (operation.equals("+")) {
                secondNumber = Double.parseDouble(textField.getText());
                double result = firstNumber + secondNumber;
                textField.setText(String.valueOf(result));
            } else if (operation.equals("-")) {
                secondNumber = Double.parseDouble(textField.getText());
                double result = firstNumber - secondNumber;
                textField.setText(String.valueOf(result));
            } else if (operation.equals("*")) {
                secondNumber = Double.parseDouble(textField.getText());
                double result = firstNumber * secondNumber;
                textField.setText(String.valueOf(result));
            } else if (operation.equals("/")) {
                secondNumber = Double.parseDouble(textField.getText());
                double result = firstNumber / secondNumber;
                textField.setText(String.valueOf(result));
            } else if (operation.equals("^")) {
                secondNumber = Double.parseDouble(textField.getText());
                double result = Math.pow(firstNumber, secondNumber);
                textField.setText(String.valueOf(result));
            }
            decimalClicked = false;
        } else if (command.equals(".")) {
            if (!decimalClicked) {
                textField.setText(textField.getText() + ".");
                decimalClicked = true;
            }
        } else if (command.equals("sqrt")) {
            double result = Math.sqrt(Double.parseDouble(textField.getText()));
            textField.setText(String.valueOf(result));
            decimalClicked = false;
        } else if (command.equals("^")) {
            firstNumber = Double.parseDouble(textField.getText());
            operation = "^";
            textField.setText("");
            decimalClicked = false;
        } else {
            // number buttons
            textField.setText(textField.getText() + command);
        }
    }

    public static void main(String[] args) {
        new SciCal();
    }
}
