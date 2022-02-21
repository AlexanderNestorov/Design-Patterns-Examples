package designpatterns.strategy;

import designpatterns.ClassifiedLine;
import designpatterns.TextClassifierApi;

import java.util.ArrayList;
import java.util.List;

/**
 * Enhanced implementation of {@link TextClassifierApi} using Strategy design pattern to abstract
 * classification mechanisms.
 */
public class TextClassifierImpl implements TextClassifierApi {

    /**
     * A list of classification strategies supported. Every input text line is checked against the
     * strategies from the list. The FIRST strategy that classifies a text defines the its category.
     */
    public List<ClassifierStrategy> classifierStrategies = new ArrayList<>();

    /**
     * Initialize the instance with all strategies supported.
     */
    public TextClassifierImpl() {
        classifierStrategies.add(new EmptyClassifierStrategy());
        classifierStrategies.add(new CommentClassifierStrategy());
        classifierStrategies.add(new NumberClassifierStrategy());
        classifierStrategies.add(new PalindromeClassifierStrategy());
        classifierStrategies.add(new TextClassifierStrategy());
    }

    @Override
    public List<ClassifiedLine> classify(Iterable<String> lines) {
        List<ClassifiedLine> classifiedLines = new ArrayList<>();

        int index = 0;
        // For each line...
        for (String textLine : lines) {

            // ...apply classification strategies
            for (ClassifierStrategy classifierStrategy : classifierStrategies) {
                if (classifierStrategy.instanceOf(textLine)) {
                    // ... and the FIRST one defines line's category
                    classifiedLines.add(
                            new ClassifiedLine(index++, textLine, classifierStrategy.getName()));
                    break;
                }
            }
        }

        return classifiedLines;
    }
}
