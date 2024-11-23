package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String DEFAULT_FILE = System.getProperty("user.home") + File.separator + "output.txt";
    private File currentfile;
    /**
     *Create a controller and given a filePath.
     @param file the initial file
     */
    public Controller(final String file) {
        this.currentfile = new File(file);
    }

    /**
    * Constructor with 0 parameters, sets a default /output.txt as filepath.
     * */
    public Controller() {
        this(DEFAULT_FILE);
    }

    /**
     * takes a as a input and set its copy as the new current file.
     * Parameters:
     * @param file the file that will become the next current file
     */
    public void setCurrentFile(final File file) {
       currentfile = new File(file.getAbsolutePath());
    }

    /**
     *Returns the actual file's filepath.
    * @return the current's file Filepath
    * */
    public String getFilePath() {
        return currentfile.getPath();
    }

    /**
     *Method that gived a message prints on the current file of the controller the message.
     Parameters
     @param s the message to print on the file
     *
     */
    public void writeOnFile(final String s) {
        if (isNull(s)) {
            throw new IllegalArgumentException("String to write null");
        }
        try (PrintStream ps = new PrintStream(currentfile.getPath(), StandardCharsets.UTF_8)) {
            ps.print(s);
        } catch (IOException e1) {
throw new IllegalArgumentException(e1);
}
    }

    /**
     * Return a copy of the current file.
     *@return a copy of the current file
     */
    public File getCurrentFile() {
        return new File(currentfile.getPath());
    }

    private boolean isNull(final Object o1) {
        return o1 == null;
    } 
}
