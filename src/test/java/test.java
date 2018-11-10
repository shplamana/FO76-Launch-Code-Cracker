import org.aion.decryption.Scrambler;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class test {

    @Test
    public void test() throws IOException, URISyntaxException {

//        Scrambler.findOptions("glanoity", Arrays.asList("something", "designatory", "scramble", "antology", "antilogy"));

//        Scrambler.findOptions("glanoity", Files.readAllLines(Paths.get(System.getProperty("user.dir")+ "/src/main/resources/words/words_alpha.txt")));

        Scrambler.findOptions("glanoity", Files.readAllLines(Paths.get(getClass().getResource("words/words_alpha.txt").toURI())));

    }

}
