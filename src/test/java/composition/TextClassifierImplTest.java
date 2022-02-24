package composition;

import designpatterns.ClassifiedLine;
import designpatterns.TextClassifierApi;
import designpatterns.builder.TextClassifierBuilder;
import designpatterns.compositon.ClassifierStrategyComposition;
import designpatterns.factory.InMemoryTextLinesFactory;
import designpatterns.factory.TextLinesFactory;
import designpatterns.strategy.ClassifierStrategy;
import designpatterns.strategy.NumberClassifierStrategy;
import designpatterns.strategy.PalindromeClassifierStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextClassifierImplTest {

    TextClassifierApi classifier;

    @Before
    public void setupTest() {
        ClassifierStrategy palindromeAndNumber = new ClassifierStrategyComposition(
                new NumberClassifierStrategy(),
                new PalindromeClassifierStrategy());

        classifier = new TextClassifierBuilder(false)
                .addFirst(palindromeAndNumber)
                .addLast(new NumberClassifierStrategy())
                .addLast(new PalindromeClassifierStrategy())
                .build();
    }

    @Test
    public void testClassifyFromFile() {

        TextLinesFactory textLinesFactory = new InMemoryTextLinesFactory(
                "123", "tacocat", "42024");

        List<ClassifiedLine> classifiedLines = classifier.classify(textLinesFactory.getTextLines());

        System.out.println("classifiedLines: " + classifiedLines);

        assertEquals(new ClassifiedLine(0, "123", NumberClassifierStrategy.NAME),
                classifiedLines.get(0));
        assertEquals(new ClassifiedLine(1, "tacocat", PalindromeClassifierStrategy.NAME),
                classifiedLines.get(1));
        assertEquals(new ClassifiedLine(2, "42024",
                        NumberClassifierStrategy.NAME + " and " + PalindromeClassifierStrategy.NAME),
                classifiedLines.get(2));
    }

}
