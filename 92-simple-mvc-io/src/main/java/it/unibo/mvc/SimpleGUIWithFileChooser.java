package it.unibo.mvc;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser extends SimpleGUI {

    private SimpleGUIWithFileChooser() {
        super();
        final JPanel browsePanel = new JPanel();
        browsePanel.setLayout(new BorderLayout());
        final JButton browseButton = new JButton("Browse");
        browsePanel.add(browseButton, BorderLayout.EAST);
        final JTextField textField = new JTextField(getController().getFilePath());
        textField.setEditable(false);
        browsePanel.add(textField, BorderLayout.WEST);
this.addToFrame(browsePanel, BorderLayout.NORTH);
        browseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final var ret = chooseFile(); 
                if (ret.getRetVal() == JFileChooser.APPROVE_OPTION) {
                    getController().setCurrentFile(new File(ret.getFile().getPath()));
    textField.setText(ret.getFile().getPath());
                }
            }
        });
    }
    /**
     * The entry point of an application with a file chooser.
     * @param args arguments passed trought command line
     * */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser().display();
    }

}
