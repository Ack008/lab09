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
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5; 
    private final JFrame frame = new JFrame();
    private final Controller controller;
    private SimpleGUIWithFileChooser(){
        controller = new Controller();
        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        JPanel browsePanel = new JPanel();
        browsePanel.setLayout(new BorderLayout());
        JButton browseButton = new JButton("Browse");
        browsePanel.add(browseButton, BorderLayout.EAST);
        JTextField textField = new JTextField(controller.getFilePath());
        textField.setEditable(false);
        browsePanel.add(textField, BorderLayout.WEST);
        canvas.add(browsePanel, BorderLayout.NORTH);
        JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        JButton button = new JButton("Save");
        canvas.add(button, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        browseButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            }
            
        });

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.writeOnFile(textArea.getText());
            }
            
        });
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
        new SimpleGUIWithFileChooser().display();
    }

}
