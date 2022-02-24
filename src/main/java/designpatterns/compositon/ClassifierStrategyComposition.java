package designpatterns.compositon;

import designpatterns.strategy.ClassifierStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassifierStrategyComposition implements ClassifierStrategy {

    protected final List<ClassifierStrategy> delegates;

    public ClassifierStrategyComposition(ClassifierStrategy... delegates) {
        this(Arrays.asList(delegates));
    }

    public ClassifierStrategyComposition(List<ClassifierStrategy> delegates) {
        this.delegates = delegates;
    }

    @Override
    public boolean instanceOf(String text) {
        if (delegates.isEmpty()) {
            return false;
        }
        for (ClassifierStrategy delegate : delegates) {
            if (!delegate.instanceOf(text)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        if (delegates.isEmpty()) {
            return "undefined";
        }

        List<String> names = new ArrayList<>();

        for (ClassifierStrategy delegate : delegates) {
            names.add(delegate.getName());
        }

        return String.join(" and ", names);
    }


}
