package designpatterns.singleton;

import designpatterns.strategy.TextClassifierStrategy;

/**
 * The technique known as the <b>initialization-on-demand</b> holder idiom is as lazy as possible,
 * and works in all known versions of Java. It takes advantage of language guarantees about class
 * initialization, and will therefore work correctly in all Java-compliant compilers and virtual
 * machines.
 *
 * <p>
 * The nested class is referenced no earlier (and therefore loaded no earlier by the class loader)
 * than the moment that getInstance() is called. Thus, this solution is thread-safe without
 * requiring special language constructs (i.e. volatile or synchronized).
 */
public class OnDemandTextClassifierStrategy extends TextClassifierStrategy {

    /**
     * Initializes singleton.
     *
     * {@link SingletonHolder} is loaded on the first execution of
     * {@link OnDemandTextClassifierStrategy#getInstance()} or the first access to
     * {@link SingletonHolder#INSTANCE}, not before.
     */
    private static class SingletonHolder {

        private static final OnDemandTextClassifierStrategy INSTANCE = new OnDemandTextClassifierStrategy();
    }

    /**
     * Return the singleton instance of this class.
     */
    public static OnDemandTextClassifierStrategy getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /*
     * Private constructor restricting instantiation of this class.
     */
    private OnDemandTextClassifierStrategy() {
    }
}
