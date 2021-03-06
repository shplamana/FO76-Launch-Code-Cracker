package org.aion.decryption;

public class KeywordCipher {

    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public String encrypt(String text, String key) {

        char charEnc;
        int valEnc;
        char newEnc;

        StringBuilder encrypted = new StringBuilder();
        key = key.toLowerCase();
        text = text.toLowerCase();

        //replace repeated characters in key
        key = key.replaceAll("(.)(?=.*\\1)", "");
        StringBuilder newValue = new StringBuilder(key);

        // loop the value and add the rest to newValue
        for (int i = 0; i < alphabet.length(); i++) {
            charEnc = alphabet.charAt(i);
            // check if char exixt in the new key
            if (newValue.toString().indexOf(charEnc) < 0) {
                // add the char to new key if is not there
                newValue.append(alphabet.charAt(i));
            }
        }

        // now loop through the string
        for (int i = 0; i < text.length(); i++) {
            charEnc = text.charAt(i);
            // check the index of the character at the main alphabet string
            valEnc = alphabet.indexOf(charEnc);
            // pick the character of the corresponding newvalue index
            newEnc = newValue.charAt(valEnc);
            encrypted.append(newEnc);
        }
        return encrypted.toString().toLowerCase();
    }

    public String decrypt(String text, String key) {

        char charEnc;
        int valEnc;
        char newEnc;

        StringBuilder decrypted = new StringBuilder();
        key = key.toLowerCase();
        text = text.toLowerCase();

        //replace repeated characters in key
        key = key.replaceAll("(.)(?=.*\\1)", "");
        StringBuilder newValue = new StringBuilder(key);

        // loop the value and add the rest to newValue
        for (int i = 0; i < alphabet.length(); i++) {
            charEnc = alphabet.charAt(i);
            // check if char exixt in the new key
            if (newValue.toString().indexOf(charEnc) < 0) {
                // add the char to new key if is not there
                newValue.append(alphabet.charAt(i));
            }
        }

        // now loop through the string
        for (int i = 0; i < text.length(); i++) {
            charEnc = text.charAt(i);
            // check the index of the character at the main alphabet string
            valEnc = newValue.toString().indexOf(charEnc);
            // pick the character of the corresponding newvalue index
            newEnc = alphabet.charAt(valEnc);
            decrypted.append(newEnc);
        }
        return decrypted.toString().toLowerCase();
    }

}
