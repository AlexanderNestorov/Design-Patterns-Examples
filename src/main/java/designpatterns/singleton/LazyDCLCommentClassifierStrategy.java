package designpatterns.singleton;

import designpatterns.strategy.CommentClassifierStrategy;

/**
 * This method uses double-checked locking, which should not be used prior to J2SE 5.0, as it is
 * vulnerable to subtle bugs.
 */
public class LazyDCLCommentClassifierStrategy extends CommentClassifierStrategy {

    private static volatile LazyDCLCommentClassifierStrategy instance;

    /**
     * Return the singleton instance of this class.
     */
    public static LazyDCLCommentClassifierStrategy getInstance() {
        if (instance == null) {
            synchronized (LazyDCLCommentClassifierStrategy.class) {
                if (instance == null) {
                    instance = new LazyDCLCommentClassifierStrategy();
                }
            }
        }

        return instance;
    }

    /*
     * Private constructor restricting instantiation of this class.
     */
    private LazyDCLCommentClassifierStrategy() {
    }

}
