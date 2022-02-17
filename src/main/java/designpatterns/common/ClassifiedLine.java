package designpatterns.common;

/**
 * Data class representing classified data per single text line.
 */
public class ClassifiedLine {

    public final int number;

    public final String text;

    public final String category;

    public ClassifiedLine(int number, String text, String category) {
        this.number = number;
        this.text = text;
        this.category = category;
    }

    @Override
    public String toString() {
        return "[number=" + number + ", category=" + category + ", text=" + text + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        ClassifiedLine other = (ClassifiedLine) obj;

        if (number != other.number) {
            return false;
        }

        if (category == null) {
            if (other.category != null) {
                return false;
            }
        } else if (!category.equals(other.category)) {
            return false;
        }

        if (text == null) {
            return other.text == null;
        } else return text.equals(other.text);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (category == null ? 0 : category.hashCode());
        result = 31 * result + number;
        result = 31 * result + (text == null ? 0 : text.hashCode());
        return result;
    }
}
