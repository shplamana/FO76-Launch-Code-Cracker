package org.aion.decryption;

import java.util.List;

/**
 * Takes the deciphered text and unscrambles it into possible words.
 * <p>
 * Credit where it's due for the algorithm
 *
 * @see <a href='https://codereview.stackexchange.com/questions/166281/find-all-words-in-a-dictionary-that-can-be-made-with-a-string-of-characters-rec'>algorithm</a>
 */
public class Scrambler {

    public static void findOptions(String decipheredText, List<String> wordList) {
        int[] freq = toFreq(decipheredText);
        for (String l : wordList) {
            if (l.length() == decipheredText.length()) {
                int[] freqIn = toFreq(l);
                if (matches(freq, freqIn)) {
                    System.out.println(l); // TODO: 11/9/2018 return a list of results instead of print
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
