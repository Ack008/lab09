package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5; 
    private final JFrame frame = new JFrame();
    private final Controller controller;
    protected SimpleGUI(){
        controller = new Controller();
        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        JButton button = new JButton("Dave");
        canvas.add(button, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.writeOnFile(textArea.getText());
            }
            
        });
    }
    protected Controller getController(){
        return new Controller(controller.getFilePath());
    }
    
    private void display(){
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new SimpleGUI().display();
    }
}
