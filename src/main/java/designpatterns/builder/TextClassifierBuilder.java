package designpatterns.builder;

import designpatterns.TextClassifierApi;
import designpatterns.strategy.ClassifierStrategy;
import designpatterns.strategy.TextClassifierImpl;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * The class is responsible to create and configure different versions/representations of
 * {@link TextClassifierApi}. It complies with Builder design pattern.
 */
public class TextClassifierBuilder {

    private final TextClassifierImpl textClassifierImpl;

    /**
     * @param useDefault
     *        Flag indicating whether to use default classification strategies or not.
     */
    public TextClassifierBuilder(boolean useDefault) {

        textClassifierImpl = new TextClassifierImpl();

        if (!useDefault) {
            // Just unregister default classification strategies.
            textClassifierImpl.classifierStrategies.clear();
        }
    }

    /**
     * Return the effective result of build process/logic.
     */
    public TextClassifierApi build() {
        return textClassifierImpl;
    }

    /**
     * Add passed classification strategy with highest precedence.
     */
    public TextClassifierBuilder addFirst(ClassifierStrategy classifierStrategy) {
        textClassifierImpl.classifierStrategies.add(0, classifierStrategy);

        /*
         * Return this instance so client can chain calls to the builder.
         */
        return this;
    }

    /**
     * Add passed classification strategy with lowest precedence.
     */
    public TextClassifierBuilder addLast(ClassifierStrategy classifierStrategy) {
        textClassifierImpl.classifierStrategies.add(classifierStrategy);

        /*
         * Return this instance so client can chain calls to the builder.
         */
        return this;
    }

    /**
     * Add the given classification strategy with precedence immediately higher than the named
     * relative classification strategy.
     */
    public TextClassifierBuilder addBefore(ClassifierStrategy classifierStrategy,
                                           String relativeClassifierStrategyName) {

        boolean added = false;

        for (ListIterator<ClassifierStrategy> iterator = textClassifierImpl.classifierStrategies
                .listIterator(); iterator.hasNext();) {
            if (iterator.next().getName().equalsIgnoreCase(relativeClassifierStrategyName)) {
                iterator.previous();
                iterator.add(classifierStrategy);
                added = true;
                break;
            }
        }

        if (!added) {
            throw new NoSuchElementException(relativeClassifierStrategyName);
        }

        /*
         * Return this instance so client can chain calls to the builder.
         */
        return this;
    }

    /**
     * Add the given classification strategy with precedence immediately lower than the named
     * relative classification strategy.
     */
    public TextClassifierBuilder addAfter(ClassifierStrategy classifierStrategy,
                                          String relativeClassifierStrategyName) {

        boolean added = false;

        for (ListIterator<ClassifierStrategy> iterator = textClassifierImpl.classifierStrategies
                .listIterator(); iterator.hasNext();) {
            if (iterator.next().getName().equalsIgnoreCase(relativeClassifierStrategyName)) {
                iterator.add(classifierStrategy);
                added = true;
                break;
            }
        }

        if (!added) {
            throw new NoSuchElementException(relativeClassifierStrategyName);
        }

        /*
         * Return this instance so client can chain calls to the builder.
         */
        return this;
    }
}
