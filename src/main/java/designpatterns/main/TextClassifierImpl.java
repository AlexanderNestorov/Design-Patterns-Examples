package designpatterns.main;

import designpatterns.common.ClassifiedLine;
import designpatterns.common.TextClassifierApi;

import java.util.ArrayList;
import java.util.List;

public class TextClassifierImpl implements TextClassifierApi {
    @Override
    public List<ClassifiedLine> classify(Iterable<String> lines) {
        // Prepare final result
        List<ClassifiedLine> classifiedLines = new ArrayList<>();

        int index = 0;
        // Iterate lines...
        for (String textLine : lines) {

            final String category;

            // Checks classification/category
            if (isEmpty(textLine)) {

                category = "Empty";

            } else if (isPalindrome(textLine)) {

                category = "Palindrome";

            } else if (isNumber(textLine)) {

                category = "Number";

            } else {
                // By default every text is considered TEXT
                category = "Text";
            }

            // Return calculated result
            classifiedLines.add(new ClassifiedLine(index++, textLine, category));
        }

        return classifiedLines;
    }

    /**
     * Checks whether passed string is number.
     */
    public static boolean isNumber(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException exc) {
            return false;
        }
    }

    /**
     * Checks whether passed string is empty.
     */
    public static boolean isEmpty(String text) {
        return text.isEmpty();
    }

    /**
     * Checks whether passed string is palindrome.
     */
    public static boolean isPalindrome(String text) {
        for (int i = 0, size = text.length(); i < size / 2; i++) {
            if (text.charAt(i) != text.charAt(size - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
