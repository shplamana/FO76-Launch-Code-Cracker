package org.aion.decryption;

public class Substitution {

    public static String codeSubstitution(String cipheredString, String codeString, String decipheredString, String termString) {

        StringBuilder ciphered = new StringBuilder(cipheredString);
        StringBuilder code = new StringBuilder(codeString);
        StringBuilder deciphered = new StringBuilder(decipheredString);
        StringBuilder term = new StringBuilder(termString);
        StringBuilder codeSolution = new StringBuilder();

        for (int i = 0; i < ciphered.length(); i++) {

            codeSolution
                    .append(
                            code.charAt(
                                    deciphered.indexOf(
                                            term.substring(i, i + 1)
                                    )
                            )
                    )
                    .append(" ");
        }

        System.out.println(codeSolution);

        return codeSolution.toString();

    }

}
