package designpatterns;

import java.util.List;
/**
 * API to classify list of text lines. Text line number, raw content and category is returned per
 * each input text line.
 */
public interface TextClassifierApi {

    /**
     * @param lines
     *        The input text lines to classify
     * @return List of {@link ClassifiedLine} per each input text line.
     */
    List<ClassifiedLine> classify(Iterable<String> lines);
}
