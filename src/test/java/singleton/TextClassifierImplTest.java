package singleton;

import designpatterns.ClassifiedLine;
import designpatterns.TextClassifierApi;
import designpatterns.builder.TextClassifierBuilder;
import designpatterns.singleton.EagerNumberClassifierStrategy;
import designpatterns.singleton.LazyClassSyncEmptyClassifierStrategy;
import designpatterns.singleton.LazyDCLCommentClassifierStrategy;
import designpatterns.singleton.OnDemandTextClassifierStrategy;
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
                .addFirst(LazyClassSyncEmptyClassifierStrategy.getInstance())
                .addLast(LazyDCLCommentClassifierStrategy.getInstance())
                .addLast(EagerNumberClassifierStrategy.getInstance())
                .addLast(OnDemandTextClassifierStrategy.getInstance())
                .build();
    }

    @Test
    public void testClassify() {

        List<ClassifiedLine> classifiedLines = classifier.classify(inputLines);

        System.out.println("classifiedLines: " + classifiedLines);

        assertEquals(new ClassifiedLine(0, "# the input for classifier API", "Comment"), classifiedLines.get(0));
        assertEquals(new ClassifiedLine(1, "", "Empty"), classifiedLines.get(1));
        assertEquals(new ClassifiedLine(2, "420", "Number"), classifiedLines.get(2));
        assertEquals(new ClassifiedLine(3, "singleton-test", "Text"), classifiedLines.get(3));
    }
}
