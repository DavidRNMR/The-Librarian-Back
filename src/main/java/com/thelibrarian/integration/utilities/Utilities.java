package com.thelibrarian.integration.utilities;

public class Utilities {

    public static char generateRandomLetter() {
        int min = 97;
        int max = 122;
        return (char) ((Math.random() * (max - min)) + min);
    }

}
