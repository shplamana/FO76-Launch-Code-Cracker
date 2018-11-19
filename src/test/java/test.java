import org.aion.decryption.KeywordCipher;
import org.aion.decryption.WordFind;
import org.aion.gui.model.MainModel;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class test {

    @Test
    public void smoke() {

//        Scrambler.unscramble("glanoity", Arrays.asList("something", "designatory", "scramble", "antology", "antilogy"));

//        Scrambler.unscramble("glanoity", Files.readAllLines(Paths.get(System.getProperty("user.dir")+ "/src/main/resources/words/words_alpha.txt")));

//        InputStream resource = getClass().getResourceAsStream("words/words_alpha.txt");

//        Scrambler.unscramble("GLANOITY", new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("words/words_alpha.txt"), StandardCharsets.UTF_8)).lines().collect(Collectors.toList()));
//
//        System.out.println(new KeywordCipher().encrypt("glanoity", "designatory"));
//
//        System.out.println(new KeywordCipher().decrypt("ABDFHOPX", "designatory"));

        List<String> words = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("words/words_alpha.txt"), StandardCharsets.UTF_8)).lines().collect(Collectors.toList());

        // Find possible keywords
        List<String> keywords = new WordFind().findWord("s..wa....g.*", words);

        System.out.println(keywords);

//        for (String word : words) {
//
//            int[] freq = new int[26];
//            for (char c : word.toLowerCase().toCharArray()) {
//                if ((c - 'a') >= 0 && (c - 'a') < 26) {
//                    freq[c - 'a']++;
//                }
//            }
//
//            boolean contains = IntStream.of(freq).anyMatch(x -> x > 1);
//
//            if (!contains) {
//                System.out.println(word);
//            }
//
//        }

//        for (String word : words) {
//
//            if (word.length() == 8) {
//                System.out.println(word);
//            }
//
//        }

//        List<String> keywords = new WordFind().findWord(".....n.....*", words);
//
//        for (String keyword : keywords) {
//            System.out.println(keyword);
//        }


    }

    @Test
    public void testComplete() {

        List<String> words = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("words/words_alpha.txt"), StandardCharsets.UTF_8)).lines().collect(Collectors.toList());

        List<String> keywords = new WordFind().findWord(".....n..o..*", words);


        for (String keyword : keywords) {

            String decryptedText = new KeywordCipher().decrypt("ABDFHOPX", keyword);

//            Scrambler.unscramble(decryptedText, words);
        }

    }

    @Test
    public void testSubstitution() throws Exception {

        StringBuilder ciphered = new StringBuilder("ABDFHOPX");
        StringBuilder code = new StringBuilder("06828161");
        StringBuilder deciphered = new StringBuilder("GLANOITY ");
        StringBuilder term = new StringBuilder("ANTILOGY ");
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

    }

    @Test
    public void testMainModel() {

        new MainModel().execute(null, "ABDFHOPX", "06828161", ".....n..o..");

    }

}
