

package com.logwriter;

import java.io.IOException;
import java.io.PrintStream;

/**
 * A utility class for logging and text formatting.
 */
public class LogWriter {
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RESET = "\u001B[0m";

    /**
     * Prints the input text to the console with cyan text color using ANSI escape codes.
     * 
     * @param text the input text to be printed
     */
    public void sayHelp(String text) {
        if (text != null && !text.isEmpty()) {
            try {
                PrintStream out = System.out;
                if (out != null) {
                    out.print(ANSI_CYAN);
                    out.print(toLowerCase(text));
                    out.print(ANSI_RESET);
                    out.println();
                }
            } catch (IOException e) {
                System.err.println("Error writing to console: " + e.getMessage());
            }
        }
    }

    /**
     * Converts the input text to lowercase.
     * 
     * @param text the input text to be converted
     * @return the lowercase text
     */
    private String toLowerCase(String text) {
        return text.toLowerCase();
    }
}