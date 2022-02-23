package factory;

import designpatterns.ClassifiedLine;
import designpatterns.TextClassifierApi;
import designpatterns.builder.TextClassifierBuilder;
import designpatterns.factory.FileTextLinesFactory;
import designpatterns.factory.InMemoryTextLinesFactory;
import designpatterns.factory.TextLinesFactory;
import designpatterns.strategy.EmptyClassifierStrategy;
import designpatterns.strategy.NumberClassifierStrategy;
import designpatterns.strategy.PalindromeClassifierStrategy;
import designpatterns.strategy.TextClassifierStrategy;
import org.junit.Test;
import support.TextClassifierTestSupport;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextClassifierImplTest {

    TextClassifierApi classifier = new TextClassifierBuilder(true).build();

    @Test
    public void testClassifyFromFile() {

        final TextLinesFactory textLinesFactory = new FileTextLinesFactory(
                TextClassifierTestSupport.getInputTextPath(getClass()).toString());

        List<ClassifiedLine> classifiedLines = classifier.classify(textLinesFactory.getTextLines());

        System.out.println("classifiedLines: " + classifiedLines);

        assertEquals(new ClassifiedLine(0, "123", NumberClassifierStrategy.NAME), classifiedLines.get(0));
        assertEquals(new ClassifiedLine(1, "factory-test", TextClassifierStrategy.NAME), classifiedLines.get(1));
        assertEquals(new ClassifiedLine(2, "", EmptyClassifierStrategy.NAME), classifiedLines.get(2));
        assertEquals(new ClassifiedLine(3, "tacocat", PalindromeClassifierStrategy.NAME), classifiedLines.get(3));
    }

    @Test
    public void testClassifyFromStrings() {

        final TextLinesFactory textLinesFactory = new InMemoryTextLinesFactory(
                "123", "factory-test", "", "tacocat");

        List<ClassifiedLine> classifiedLines = classifier.classify(textLinesFactory.getTextLines());

        System.out.println("classifiedLines: " + classifiedLines);

        assertEquals(new ClassifiedLine(0, "123", NumberClassifierStrategy.NAME), classifiedLines.get(0));
        assertEquals(new ClassifiedLine(1, "factory-test", TextClassifierStrategy.NAME), classifiedLines.get(1));
        assertEquals(new ClassifiedLine(2, "", EmptyClassifierStrategy.NAME), classifiedLines.get(2));
        assertEquals(new ClassifiedLine(3, "tacocat", PalindromeClassifierStrategy.NAME), classifiedLines.get(3));
    }
}
