package Sub;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.*;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Loading extends JFrame {
    JProgressBar Loading;
    int i = 0, num = 0;
    private JLabel welcomeLabel, SubLabel, imageLabel, imageLabel2;

    public Loading() {
        setTitle("Occidental Mindoro State College");

        MyPanel panel = new MyPanel();
        panel.setLayout(null);
        add(panel);

        ImageIcon originalImageIcon = new ImageIcon("Final_Project/image/Icon.png");
        Image originalImage = originalImageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        imageLabel = new JLabel(scaledImageIcon);
        imageLabel.setBounds(280, 50, 130, 130);
        panel.add(imageLabel);

        welcomeLabel = new JLabel("Occidental Mindoro State College");
        welcomeLabel.setFont(new Font("Courier", Font.BOLD, 20));
        welcomeLabel.setOpaque(false);
        welcomeLabel.setForeground(Color.black);

        SubLabel = new JLabel("San Jose, Occidental Mindoro");
        SubLabel.setFont(new Font("Courier", Font.BOLD, 15));
        SubLabel.setForeground(Color.black);

        welcomeLabel.setBounds(190, 180, 500, 50);
        SubLabel.setBounds(240, 200, 500, 50);
        panel.add(welcomeLabel);
        panel.add(SubLabel);

        Loading = new JProgressBar(0, 2000);
        Loading.setBounds(233, 250, 233, 40);
        Loading.setValue(0);
        Loading.setStringPainted(true);
        panel.add(Loading);

        ImageIcon originalImageIcon2 = new ImageIcon("Final_Project/image/Cover.jpg");
        Image originalImage2 = originalImageIcon2.getImage();
        Image scaledImage2 = originalImage2.getScaledInstance(700, 380, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon2 = new ImageIcon(scaledImage2);
        imageLabel2 = new JLabel(scaledImageIcon2);
        imageLabel2.setBounds(0, 0, 700, 380);
        panel.add(imageLabel2);

        setSize(700, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        iterate();
    }

    public void iterate() {
        while (i <= 2000) {
            Loading.setValue(i);
            i = i + 20;
            try {
                Thread.sleep(150);
            } catch (Exception e) {
            }
        }
        dispose();
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
