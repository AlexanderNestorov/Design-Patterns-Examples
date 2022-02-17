package support;

import org.junit.Before;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class TextClassifierTestSupport {

    protected Iterable<String> inputLines;

    @Before
    public void beforeTest() throws IOException {

        inputLines = Files.readAllLines(getInputTextPath(getClass()), Charset.defaultCharset());
    }

    public static Path getInputTextPath(Class<?> clazz) {
        try {
            URL inputURL = clazz.getResource("text-classifier-input.txt");

            return Paths.get(inputURL.toURI());

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
