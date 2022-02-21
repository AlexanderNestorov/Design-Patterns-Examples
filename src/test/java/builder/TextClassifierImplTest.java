package builder;

import designpatterns.ClassifiedLine;
import designpatterns.TextClassifierApi;
import designpatterns.builder.TextClassifierBuilder;
import designpatterns.strategy.CommentClassifierStrategy;
import designpatterns.strategy.EmptyClassifierStrategy;
import org.junit.Before;
import org.junit.Test;
import support.TextClassifierTestSupport;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextClassifierImplTest extends TextClassifierTestSupport {
    TextClassifierApi classifier;

    @Before
    public void setupTest() {
        classifier = new TextClassifierBuilder(false)
                .addFirst(new EmptyClassifierStrategy())
                .addLast(new CommentClassifierStrategy())
                .addBefore(new KeyValueClassifierStrategy(), CommentClassifierStrategy.NAME)
                .build();
    }

    @Test
    public void testClassify() {

        List<ClassifiedLine> classifiedLines = classifier.classify(inputLines);

        System.out.println("classifiedLines: " + classifiedLines);

        assertEquals(new ClassifiedLine(0, "# Input for 'Builder' DP", CommentClassifierStrategy.NAME),
                classifiedLines.get(0));
        assertEquals(new ClassifiedLine(1, "", EmptyClassifierStrategy.NAME),
                classifiedLines.get(1));
        assertEquals(new ClassifiedLine(2, "tb.name = Testing Builder Pattern",
                        KeyValueClassifierStrategy.NAME),
                classifiedLines.get(2));
        assertEquals(new ClassifiedLine(3, "tb.year = 2022", KeyValueClassifierStrategy.NAME),
                classifiedLines.get(3));
    }

}
