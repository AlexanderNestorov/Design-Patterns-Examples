package designpatterns.strategy;

/**
 * An instance of this interface might provide/implement different text classification strategies.
 */
public interface ClassifierStrategy {

    /**
     * Determines if the passed text is of type/category that is supported by this classification
     * mechanism.
     */
    boolean instanceOf(String text);

    /**
     * User friendly-name of this classification strategy.
     */
    String getName();
}
