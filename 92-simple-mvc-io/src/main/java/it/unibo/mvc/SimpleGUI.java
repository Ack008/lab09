package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Objects;
import java.io.File;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;
/**
 * A very simple program using a graphical interface.
 * 
 */
public class SimpleGUI {

    private static final int PROPORTION = 5; 
    private final JFrame frame = new JFrame();
    private final Controller controller;
    private final JPanel canvas; 
    /**
     *Initializes the SimpleGUI class's object.
     * */
    protected SimpleGUI() {
        controller = new Controller();
        canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        final JButton button = new JButton("Save");
        canvas.add(button, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.addActionListener((e) -> controller.writeOnFile(textArea.getText()));
    }

    /**
     *Allow to add a component with its position(or style) to the main frame.
     * Parameters
     * @param component the component you want to add to the frame.
     * @param layoutInfo the information of the layout, could be (for example) BorderLayout.NORTH, ecc...
     * */
    protected void addToFrame(final JComponent component, final String layoutInfo) {
canvas.add(Objects.requireNonNull(component), Objects.requireNonNull(layoutInfo)); 
    }
/**
 * A method that return the controller that holds the file on which we are going to write.
 * @return the controller
 * */
    protected Controller getController() {
return controller;
    }
    /**
     * It's a class that helps us to encapsulate a choose of a file trought a JFileChooser.
     * */
    protected final class ChoosedFile {
    private final int retVal;
    private final File file;
/**
* The constructor takes as two input the returned value of the chooser and the file selected.
* Parameters
* @param retVal the returned value of the chooser
* @param file the file selected
* */
public ChoosedFile(final int retVal, final File file) { 
    this.retVal = retVal;
    this.file = file;
    }

/**
*It return the file selected by the chooser.
*@return a copy of the file
    */
    public File getFile() {
        return new File(file.getPath());
    }
/**
* A getter of the return value.
* @return the result of the choose;
* */
    public int getRetVal() {
        return retVal;
    }
    }
    /**
     *return an object of a class that holds both the returned value of the shoeOpenDialog and the file selected.
     @return a ChoosedFile objects
     * */
    protected ChoosedFile chooseFile() {
        final JFileChooser chooser = new JFileChooser();
        final int retVal = chooser.showOpenDialog(this.canvas);
        return new ChoosedFile(retVal, chooser.getSelectedFile());
    }
   /**
    * A method that displays the window content by first setting the windows's size.
    *
    * */ 
    protected final void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
/**The entry point of an application without the file chooser.
 * Parameters
 * @param args the arguments passed trought command line
 * */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
