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

    public Controller(final String file) {
        this.currentfile = new File(file);
    }

    public Controller(){

        this(DEFAULT_FILE);
        System.out.println(DEFAULT_FILE);
    }

    /*
     * takes a @String as a input and set its copy as the new current file
     * Parameters:
     * @String
     */
    public void setCurrentFile(final File file) {
        if(isNull(file) || !file.exists()){
            throw new IllegalArgumentException("file non esistente");
        }
        currentfile = new File(file.getAbsolutePath());
    }

    public String getFilePath(){
        return currentfile.getPath();
    }

    public void writeOnFile(final String s){
        if(isNull(s)){
            throw new IllegalArgumentException("String to write null");
        }
        try (final PrintStream ps = new PrintStream(currentfile.getPath(), StandardCharsets.UTF_8)) {
            ps.print(s);
        } catch (IOException e1) {
        }
    }

    /*
     * Return a copy of the current file
     */
    public File getCurrentFile(){
        return new File(currentfile.getPath());
    }

    private boolean isNull(final Object o1){
        return (o1.equals(null));
    }

    
}
