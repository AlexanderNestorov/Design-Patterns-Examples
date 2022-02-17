package designpatterns.strategy;

/**
 * {@link ClassifierStrategy} implementation that classifies a text as {@value #NAME} if it starts
 * with '#' char.
 */
public class CommentClassifierStrategy implements ClassifierStrategy{

    public static final String NAME = "Comment";

    @Override
    public boolean instanceOf(String text) {
        return text.startsWith("#");
    }

    @Override
    public String getName() {
        return NAME;
    }
}
