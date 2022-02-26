package designpatterns.decorator;

import designpatterns.factory.TextLinesFactory;

import java.util.Iterator;

public abstract class TextLinesFactoryDecorator implements TextLinesFactory {

    protected final TextLinesFactory textLinesFactoryDelegate;

    public TextLinesFactoryDecorator(TextLinesFactory delegate) {
        textLinesFactoryDelegate = delegate;
    }

    protected abstract String decorateText(String text);

    @Override
    public Iterable<String> getTextLines() {
        return new TextLinesIterableDecorator(textLinesFactoryDelegate.getTextLines()) {
            @Override
            protected String decorateText(String text) {
                return TextLinesFactoryDecorator.this.decorateText(text);
            }
        };
    }

    public static abstract class TextLinesIterableDecorator implements Iterable<String> {

        protected final Iterable<String> iterableDelegate;

        public TextLinesIterableDecorator(Iterable<String> delegate) {
            iterableDelegate = delegate;
        }

        @Override
        public Iterator<String> iterator() {
            return new IteratorDecorator(iterableDelegate.iterator()) {
                @Override
                public String next() {
                    String text = super.next();

                    return TextLinesIterableDecorator.this.decorateText(text);
                }
            };
        }

        protected abstract String decorateText(String text);
    }

    public static abstract class IteratorDecorator implements Iterator<String> {

        protected final Iterator<String> iteratorDelegate;

        public IteratorDecorator(Iterator<String> delegate) {
            iteratorDelegate = delegate;
        }

        @Override
        public boolean hasNext() {
            return iteratorDelegate.hasNext();
        }

        @Override
        public String next() {
            return iteratorDelegate.next();
        }
    }
}
