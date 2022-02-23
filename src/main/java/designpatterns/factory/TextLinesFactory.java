package designpatterns.factory;

/**
 * An interface for objects that are source/factory for text lines.
 */
public interface TextLinesFactory {

    /**
     * Returns text lines. It's up to the implementation to decide how and from where to
     * get/access/read text lines returned.
     */
    Iterable<String> getTextLines();

}
