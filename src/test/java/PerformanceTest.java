import org.aion.decryption.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PerformanceTest {

    private String pattern = ".....n.*";
    private String cipherText = "ABDFHOPX";
    private String cipherCode = "06828161";

    private List<String> words;
    private List<String> keywords;
    private List<String> wordsWeWant;
    private List<Solution> solutionsList;

    @BeforeTest
    public void setUp() {

        words = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/words/words_alpha_no_dupes.txt"), StandardCharsets.UTF_8)).lines().collect(Collectors.toList());

    }

    @Test
    public void testWordFind() {

        // Find possible keywords
        keywords = new WordFind().findWord(pattern, words);

        // Find keywords that match our cipher text length
        wordsWeWant = new ArrayList<>();
        for (String word : words) {
            if (word.length() == cipherText.length()) {
                wordsWeWant.add(word);
            }
        }

    }

    @Test(dependsOnMethods = "testWordFind")
    public void testKeywordCipher() {
        // Decipher with all possible keywords
        solutionsList = new ArrayList<>();
        for (String keyword : keywords) {
            solutionsList.add(
                    new Solution(cipherText, new KeywordCipher().decrypt(cipherText, keyword), "")
            );
        }

    }

    @Test(dependsOnMethods = "testKeywordCipher")
    public void testScrambler() {

        // Unscramble deciphered text
        solutionsList = Scrambler.unscramble(solutionsList, wordsWeWant);

    }

    @Test(dependsOnMethods = "testScrambler")
    public void testSubstitution() {

        // Do the text/cipher substitution
        List<String> codeSolutions = new ArrayList<>();
        for (Solution solution : solutionsList) {
            if (!solution.getCodeword().isEmpty()) {
                codeSolutions.add(
                        Substitution.codeSubstitution(cipherText, cipherCode, solution.getDecoded(), solution.getCodeword())
                );
            }
        }

        System.out.println(String.join("\n", codeSolutions));

    }

}
