package designpatterns.factory;

import java.util.Arrays;

/**
 * {@link TextLinesFactory} implementation whose source is a list or array of strings.
 */
public class InMemoryTextLinesFactory implements TextLinesFactory {

    private final Iterable<String> textLines;

    public InMemoryTextLinesFactory(String... textLines) {
        this.textLines = Arrays.asList(textLines);
    }

    @Override
    public Iterable<String> getTextLines() {
        return textLines;
    }

}
