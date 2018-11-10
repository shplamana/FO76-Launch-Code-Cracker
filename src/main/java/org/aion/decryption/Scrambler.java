package org.aion.decryption;

import java.util.List;

public class Scrambler {

    public static void findOptions(String decypheredText, List<String> wordList) {
        int[] freq = toFreq(decypheredText);
        for (String l : wordList) {
            if (l.length() == decypheredText.length()) {
                int[] freqIn = toFreq(l);
                if (matches(freq, freqIn)) {
                    System.out.println(l);
                }
            }
        }
    }

    /**
     * Encode a word in to a frequency array. int[0] = #a's, int[1] = #b's etc.
     *
     * @param string
     * @return
     */
    private static int[] toFreq(String string) {
        int[] freq = new int[26];
        for (char c : string.toCharArray()) {
            if ((c - 'a') >= 0 && (c - 'a') < 26) {
                freq[c - 'a']++;
            }
        }
        return freq;
    }

    /**
     * Returns true if all the frequencies of the letters match.
     *
     * @param freq
     * @param freqIn
     * @return
     */
    private static boolean matches(int[] freq, int[] freqIn) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0 && freqIn[i] > 0) {
                return false;
            } else if (freq[i] < freqIn[i]) {
                return false;
            }

        }
        return true;
    }

}
