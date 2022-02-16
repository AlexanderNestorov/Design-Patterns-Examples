package designpatterns.common;

import designpatterns.common.ClassifiedLine;

import java.util.List;

public interface LineClassifierApi {

    List<ClassifiedLine> classify(List<String> lines);
}
