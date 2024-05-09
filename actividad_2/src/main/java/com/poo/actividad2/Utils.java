package com.poo.actividad2;

/**
 * Utils class, contains useful functions for our program
 */
public class Utils {

    // Array of common names
    public static final String[] names = {"Janner", "Nicoll", "Anthonella", "Emiliano", "Keiner", "Carlos", "Andrea", "Kaleth", "Sofia"};

    /**
     * Generates a random integer number within the specified range
     *
     * @param min minimum value
     * @param max maximum value
     * @return random integer number
     */
    public static int generateRandomInteger(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
