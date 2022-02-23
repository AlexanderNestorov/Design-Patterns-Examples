package designpatterns.factory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

/**
 * {@link TextLinesFactory} implementation whose source is a file.
 */
public class FileTextLinesFactory implements TextLinesFactory {

    private final Path inputPath;

    public FileTextLinesFactory(File inputFile) {
        this(inputFile.getPath());
    }

    public FileTextLinesFactory(String inputPath) {
        this.inputPath = Paths.get(inputPath);
    }

    @Override
    public Iterable<String> getTextLines() {
        return new FileTextLinesIterable(inputPath);
    }

    private static class FileTextLinesIterable implements Iterable<String> {

        private final Path inputPath;

        public FileTextLinesIterable(Path inputPath) {
            this.inputPath = inputPath;
        }

        @Override
        public Iterator<String> iterator() {
            try {
                List<String> readAllLines = Files.readAllLines(inputPath, Charset.defaultCharset());

                return readAllLines.iterator();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
