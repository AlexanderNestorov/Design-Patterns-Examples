package designpatterns.singleton;

import designpatterns.strategy.EmptyClassifierStrategy;

public class LazyClassSyncEmptyClassifierStrategy extends EmptyClassifierStrategy {

    private static volatile LazyClassSyncEmptyClassifierStrategy instance;

    /**
     * Return the singleton instance of this class.
     */
    public static synchronized LazyClassSyncEmptyClassifierStrategy getInstance() {
        if (instance == null) {
            instance = new LazyClassSyncEmptyClassifierStrategy();
        }

        return instance;
    }

    /*
     * Private constructor restricting instantiation of this class.
     */
    private LazyClassSyncEmptyClassifierStrategy() {
    }
}
