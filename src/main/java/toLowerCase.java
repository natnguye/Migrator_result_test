

package com.toLowerCase;

import java.util.InputMismatchException;

public class toLowerCase {

    public static String convertInputToLowerCase(String input) {
        if (input == null) {
            throw new NullPointerException("Input cannot be null");
        }
        if (!(input instanceof String)) {
            throw new ClassCastException("Input must be a string");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
        try {
            return input.toLowerCase();
        } catch (Exception e) {
            throw new InputMismatchException("An error occurred during the conversion process");
        }
    }
}