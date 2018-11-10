import org.aion.decryption.Scrambler;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class test {

    @Test
    public void smoke() {

//        Scrambler.findOptions("glanoity", Arrays.asList("something", "designatory", "scramble", "antology", "antilogy"));

//        Scrambler.findOptions("glanoity", Files.readAllLines(Paths.get(System.getProperty("user.dir")+ "/src/main/resources/words/words_alpha.txt")));

        InputStream resource = getClass().getResourceAsStream("words/words_alpha.txt");

        Scrambler.findOptions("glanoity", new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("words/words_alpha.txt"), StandardCharsets.UTF_8)).lines().collect(Collectors.toList()));


    }

}
