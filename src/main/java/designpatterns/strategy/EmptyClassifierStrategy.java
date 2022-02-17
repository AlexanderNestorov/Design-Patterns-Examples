package designpatterns.strategy;

/**
 * {@link ClassifierStrategy} implementation that classifies a text as {@value #NAME} if it is
 * empty.
 */
public class EmptyClassifierStrategy implements ClassifierStrategy{

    public static final String NAME = "Empty";

    @Override
    public boolean instanceOf(String text) {
        return text.trim().isEmpty();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
