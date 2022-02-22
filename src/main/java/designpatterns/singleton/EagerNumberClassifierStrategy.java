package designpatterns.singleton;

import designpatterns.strategy.NumberClassifierStrategy;

/**
 * If the program will always need an instance, or if the cost of creating the instance is not too
 * large in terms of time/resources, the programmer can switch to eager initialization, which
 * always creates an instance.
 */
public class EagerNumberClassifierStrategy extends NumberClassifierStrategy {

    // Eager instantiation!
    private static final EagerNumberClassifierStrategy INSTANCE = new EagerNumberClassifierStrategy();

    /**
     * Return the singleton instance of this class.
     */
    public static EagerNumberClassifierStrategy getInstance() {
        return INSTANCE;
    }

    /*
     * Private constructor restricting instantiation of this class.
     */
    private EagerNumberClassifierStrategy() {
    }
}
