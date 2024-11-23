package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
        private static final int PROPORTION = 5;
        private final JFrame frame = new JFrame();
        private SimpleGUI() {
                final JPanel canvas = new JPanel();
                canvas.setLayout(new BorderLayout());
                final JTextField textField = new JTextField();
                canvas.add(textField, BorderLayout.NORTH);
                final JTextArea textArea = new JTextArea();
                canvas.add(textArea, BorderLayout.CENTER);
                final JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new BorderLayout());
                canvas.add(buttonPanel, BorderLayout.SOUTH);
                final JButton printButton = new JButton("Print");
                buttonPanel.add(printButton, BorderLayout.WEST);
                final JButton showButton = new JButton("Show History");
                buttonPanel.add(showButton, BorderLayout.EAST);
                frame.setContentPane(canvas);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                final SimpleController ct = new SimpleController(); 
                printButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(final ActionEvent e) {
                        ct.setNextStringToPrint(textField.getText());
                        ct.printString();
                        }
                });
                showButton.addActionListener((e) -> textArea.setText(ct.getHistory().toString()));
        }
        private void display() {
                /*
                 * Make the frame one fifth the resolution of the screen. This very
                 * method is enough for a single screen setup. In case of multiple
                 * monitors, the primary is selected. In order to deal coherently with
                 * multimonitor setups, other facilities exist (see the Java
                 * documentation about this issue). It is MUCH better than manually
                 * specify the size of a window in pixel: it takes into account the
                 * current resolution.
                 */
                final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                final int sw = (int) screen.getWidth();
                final int sh = (int) screen.getHeight();
                frame.setSize(sw / PROPORTION, sh / PROPORTION);
                /*
                 * Instead of appearing at (0,0), upper left corner of the screen, this
                 * flag makes the OS window manager take care of the default positioning
                 * on screen. Results may vary, but it is generally the best choice.
                 */
                frame.setLocationByPlatform(true);
                /*
                 * Resize the frame to minimum size
                 */
                //frame.pack();
                /*
                 * OK, ready to pull the frame onscreen
                 */
                frame.setVisible(true);
        }
        /**
         *The entry point of the application.
         @param args the arguments passed trought command line
         * */
        public static void main(final String[] args) {
                new SimpleGUI().display();
        } 
} 
