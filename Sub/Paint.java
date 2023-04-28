package Sub;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;

public class Paint extends JFrame implements MouseMotionListener, ActionListener, ChangeListener {
    private Color currentColor = Color.blue;
    private int brushSize = 20;
    private JButton chooseColorButton;
    private JButton clearButton;
    private JSlider brushSizeSlider;

    public Paint() {
        System.out.print(brushSize);
        addMouseMotionListener(this);
        setBounds(100, 100, 1500, 1000);
        setVisible(true);
        addComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        new Paint().setTitle("Paint");
    }

    public void addComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1500, 1000);
        add(panel);

        chooseColorButton = new JButton("Choose Color");
        chooseColorButton.setBounds(10, 10, 100, 30);
        chooseColorButton.addActionListener(this);
        panel.add(chooseColorButton);

        brushSizeSlider = new JSlider(1, 50, 20);
        brushSizeSlider.setBounds(120, 10, 200, 30);
        brushSizeSlider.addChangeListener(this);
        panel.add(brushSizeSlider);

        clearButton = new JButton("Clear");
        clearButton.setBounds(330, 10, 100, 30);
        clearButton.addActionListener(this);
        panel.add(clearButton);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(currentColor);
        int size = brushSizeSlider.getValue();
        g.fillOval(e.getX() - size / 2, e.getY() - size / 2, size, size);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseColorButton) {
            Color newColor = JColorChooser.showDialog(this, "Choose Color", currentColor);
            if (newColor != null) {
                currentColor = newColor;
            }
        } else if (e.getSource() == clearButton) {
            Graphics g = getGraphics();
            g.setColor(getBackground());
            g.fillRect(0, 70, getWidth(), getHeight() - 50);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == brushSizeSlider) {
            brushSize = brushSizeSlider.getValue();
        }
    }
}
