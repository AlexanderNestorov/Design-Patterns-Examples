package template;


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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static support.TextClassifierTestSupport.getInputTextPath;

public class TextClassifierImplTest {

    TextClassifierApi classifier = new TextClassifierBuilder(true).build();

    @Test
    public void testClassifyFromStrings() {

        new TestRunTemplate() {
            @Override
            TextLinesFactory prepare() {
                return new InMemoryTextLinesFactory("123", "pattern-test", "", "tacocat");
            }
        }.runTest();
    }

    @Test
    public void testClassifyFromFile() {

        new TestRunTemplate() {
            @Override
            TextLinesFactory prepare() {
                return new FileTextLinesFactory(
                        getInputTextPath(TextClassifierImplTest.this.getClass()).toString());
            }
        }.runTest();
    }

    abstract class TestRunTemplate {

        final void runTest() {
            TextLinesFactory textLinesSource = prepare();

            List<ClassifiedLine> actual = callCodeUnderTesting(textLinesSource);

            assertResult(actual);
        }

        abstract TextLinesFactory prepare();

        List<ClassifiedLine> callCodeUnderTesting(TextLinesFactory textLinesFactory) {

            List<ClassifiedLine> classifiedLines = classifier
                    .classify(textLinesFactory.getTextLines());

            System.out.println("classifiedLines: " + classifiedLines);

            return classifiedLines;
        }

        void assertResult(List<ClassifiedLine> classifiedLines) {
            assertEquals(new ClassifiedLine(0, "123", NumberClassifierStrategy.NAME),
                    classifiedLines.get(0));
            assertEquals(new ClassifiedLine(1, "pattern-test", TextClassifierStrategy.NAME),
                    classifiedLines.get(1));
            assertEquals(new ClassifiedLine(2, "", EmptyClassifierStrategy.NAME),
                    classifiedLines.get(2));
            assertEquals(new ClassifiedLine(3, "tacocat", PalindromeClassifierStrategy.NAME),
                    classifiedLines.get(3));
        }

    }
}
