package it.unibo.mvc;
import java.util.Objects; 
import java.util.List;
import java.util.ArrayList;
/**
 *
 */
public final class SimpleController implements Controller {
        private String nextString;
        private final List<String> history;
        /**
         */
        public SimpleController() {
                history = new ArrayList<>();
        }
        /**
         * Set the next to be printed out.
         * @param s the string to be printed out. An exceptions is thrown if it's Null
         * */
        public void setNextStringToPrint(final String s) {
                nextString = Objects.requireNonNull(s);
                history.add(s);
        }
        /**
         *
         * @return the String
         * */
        public String getNextStringToPrint() {
                return nextString;
        }
        /**
         * Return the history.
         *@return a copy of the List of history
         * */
        public List<String> getHistory() {
                return new ArrayList<>(history);
        }
        /**
         * */
        @SuppressWarnings("PMD")
        public void printString() {
                System.out.println(nextString);
        }
}
