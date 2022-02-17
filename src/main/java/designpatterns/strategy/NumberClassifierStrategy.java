package designpatterns.strategy;

/**
 * {@link ClassifierStrategy} implementation that classifies a text as {@value #NAME} if it
 * represents number.
 */
public class NumberClassifierStrategy implements ClassifierStrategy {

    public static final String NAME = "Number";

    @Override
    public boolean instanceOf(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}
