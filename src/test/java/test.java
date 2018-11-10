import org.aion.decryption.KeywordCipher;
import org.testng.annotations.Test;

public class test {

    @Test
    public void smoke() {

//        Scrambler.findOptions("glanoity", Arrays.asList("something", "designatory", "scramble", "antology", "antilogy"));

//        Scrambler.findOptions("glanoity", Files.readAllLines(Paths.get(System.getProperty("user.dir")+ "/src/main/resources/words/words_alpha.txt")));

//        InputStream resource = getClass().getResourceAsStream("words/words_alpha.txt");

//        Scrambler.findOptions("glanoity", new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("words/words_alpha.txt"), StandardCharsets.UTF_8)).lines().collect(Collectors.toList()));

        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "r", "x", "y", "z"};

        System.out.println(new KeywordCipher().cipherKeyWord("designatory", letters));

    }

}
