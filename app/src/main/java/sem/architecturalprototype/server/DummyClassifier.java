package sem.architecturalprototype.server;

import java.util.List;

import sem.architecturalprototype.common.IDataPoint;

public class DummyClassifier implements IClassifier {

    @Override
    public String classify(IDataPoint currentDataPoint, List<IDataPoint> previousDataPoints) {
        return "Walking";
    }

}
