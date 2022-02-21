package strategy;

import designpatterns.ClassifiedLine;
import designpatterns.TextClassifierApi;
import designpatterns.strategy.TextClassifierImpl;
import org.junit.Test;
import support.TextClassifierTestSupport;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextClassifierImplTest extends TextClassifierTestSupport {

    TextClassifierApi classifier = new TextClassifierImpl();

    @Test
    public void testClassify() {

        List<ClassifiedLine> classifiedLines = classifier.classify(inputLines);

        System.out.println("classifiedLines: " + classifiedLines);

        assertEquals(new ClassifiedLine(0, "# the input for classifier API", "Comment"), classifiedLines.get(0));
        assertEquals(new ClassifiedLine(1, "", "Empty"), classifiedLines.get(1));
        assertEquals(new ClassifiedLine(2, "123", "Number"), classifiedLines.get(2));
        assertEquals(new ClassifiedLine(3, "unit-testing", "Text"), classifiedLines.get(3));
        assertEquals(new ClassifiedLine(4, "", "Empty"), classifiedLines.get(4));
        assertEquals(new ClassifiedLine(5, "tacocat", "Palindrome"), classifiedLines.get(5));
    }
}
