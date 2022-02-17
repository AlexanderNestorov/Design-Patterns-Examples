package designpatterns.strategy;
/**
 * {@link ClassifierStrategy} implementation that classifies a text as {@value #NAME} if it is
 * palindrome.
 */
public class PalindromeClassifierStrategy implements ClassifierStrategy {

    public static final String NAME = "Palindrome";

    @Override
    public boolean instanceOf(String text) {
       for (int i = 0, size = text.length();i < size / 2; i++) {
           if (text.charAt(i) != text.charAt(size - i - 1)) {
               return false;
           }
       }
       return true;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
