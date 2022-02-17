package designpatterns.strategy;

/**
 * {@link ClassifierStrategy} implementation that classifies a text as {@value #NAME}.
 */
public class TextClassifierStrategy implements ClassifierStrategy{

    public static final String NAME = "Text";

    @Override
    public boolean instanceOf(String text) {
        //By default, all texts are classified as TEXT.
        return true;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
