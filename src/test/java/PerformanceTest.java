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

    private String pattern = "stewarding";
    private String cipherText = "achknops";
    private String cipherCode = "08380495";

    private List<String> words;
    private List<String> keywords;
    private List<String> wordsWeWant;
    private List<Solution> solutionsList;

    String keywordsPath = null;
    String wordsPath = null;

    @BeforeTest
    public void setUp() {

//        keywordsPath = "/words/words_alpha_no_dupes.txt";
//        wordsPath = "/words/words_alpha_8.txt";


        keywordsPath = "/words/words_alpha.txt";
        wordsPath = "/words/words_alpha.txt";


        words = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(keywordsPath), StandardCharsets.UTF_8)).lines().collect(Collectors.toList());

    }

    @Test
    public void testWordFind() {

        // Find possible keywords
        keywords = new WordFind().findWord(pattern, words);

        // Get a list of words that match our cipher text length
        wordsWeWant = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(wordsPath), StandardCharsets.UTF_8)).lines().collect(Collectors.toList());

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
