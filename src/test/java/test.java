import org.aion.decryption.KeywordCipher;
import org.aion.decryption.Scrambler;
import org.aion.decryption.WordFind;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class test {

    @Test
    public void smoke() {

//        Scrambler.findOptions("glanoity", Arrays.asList("something", "designatory", "scramble", "antology", "antilogy"));

//        Scrambler.findOptions("glanoity", Files.readAllLines(Paths.get(System.getProperty("user.dir")+ "/src/main/resources/words/words_alpha.txt")));

//        InputStream resource = getClass().getResourceAsStream("words/words_alpha.txt");

//        Scrambler.findOptions("GLANOITY", new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("words/words_alpha.txt"), StandardCharsets.UTF_8)).lines().collect(Collectors.toList()));
//
//        System.out.println(new KeywordCipher().encrypt("glanoity", "designatory"));
//
//        System.out.println(new KeywordCipher().decrypt("ABDFHOPX", "designatory"));
//
        List<String> keywords = new WordFind().findWord(".....n.....*");

        for (String keyword : keywords) {
            System.out.println(keyword);
        }


    }

    @Test
    public void testComplete() {

        List<String> keywords = new WordFind().findWord(".....n..o..*");

        List<String> words = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("words/words_alpha.txt"), StandardCharsets.UTF_8)).lines().collect(Collectors.toList());

        for (String keyword : keywords) {

            String decryptedText = new KeywordCipher().decrypt("ABDFHOPX", keyword);

            Scrambler.findOptions(decryptedText, words);
        }

    }
}
