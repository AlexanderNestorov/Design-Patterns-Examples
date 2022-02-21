package builder;

import designpatterns.strategy.ClassifierStrategy;

public class KeyValueClassifierStrategy implements ClassifierStrategy {

    public static final String NAME = "Key-value";

    @Override
    public boolean instanceOf(String text) {
        return text.indexOf('=') != -1;
    }

    @Override
    public String getName() {
        return NAME;
    }

}

