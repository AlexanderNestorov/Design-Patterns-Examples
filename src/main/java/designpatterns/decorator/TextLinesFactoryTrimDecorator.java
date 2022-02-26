package designpatterns.decorator;

import designpatterns.factory.TextLinesFactory;

public class TextLinesFactoryTrimDecorator extends TextLinesFactoryDecorator {

    public TextLinesFactoryTrimDecorator(TextLinesFactory delegate) {
        super(delegate);
    }

    @Override
    protected String decorateText(String text) {
        return text.trim();
    }
}
