package main;

import designpatterns.ClassifiedLine;
import designpatterns.TextClassifierApi;
import designpatterns.main.TextClassifierImpl;
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

        int line = 0;

        assertEquals(new ClassifiedLine(line, "123", "Number"), classifiedLines.get(line));
        line++;
        assertEquals(new ClassifiedLine(line, "1221", "Palindrome"), classifiedLines.get(line));
        line++;
        assertEquals(new ClassifiedLine(line, "test-test", "Text"), classifiedLines.get(line));
        line++;
        assertEquals(new ClassifiedLine(line, "", "Empty"), classifiedLines.get(line));
        line++;
        assertEquals(new ClassifiedLine(line, "abba", "Palindrome"), classifiedLines.get(line));
        line++;
        assertEquals(new ClassifiedLine(line, "tacocat", "Palindrome"), classifiedLines.get(line));
    }
}
