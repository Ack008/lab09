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
public final class SimpleGUIWithFileChooser extends SimpleGUI{

    private SimpleGUIWithFileChooser(){
        super();
        JPanel browsePanel = new JPanel();
        browsePanel.setLayout(new BorderLayout());
        JButton browseButton = new JButton("Browse");
        browsePanel.add(browseButton, BorderLayout.EAST);
        JTextField textField = new JTextField(getController().getFilePath());
        textField.setEditable(false);
        browsePanel.add(textField, BorderLayout.WEST);
        getCanvas().add(browsePanel, BorderLayout.NORTH);

        browseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                final int retVal = chooser.showOpenDialog(getCanvas());
                if(retVal == JFileChooser.APPROVE_OPTION) {
                    getController().setCurrentFile(new File(chooser.getSelectedFile().getPath()));
                }
            }
            
        });
    
    }
    public static void main(String[] args) {
        new SimpleGUIWithFileChooser().display();
    }

}
