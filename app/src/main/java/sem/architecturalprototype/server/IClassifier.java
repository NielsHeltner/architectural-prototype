package sem.architecturalprototype.server;

import java.util.List;

import sem.architecturalprototype.common.IDataPoint;

public interface IClassifier {

    /**
     * Classifies a data point based on the data point as well as previous data points.
     *
     * @param currentDataPoint   the data point to be classified.
     * @param previousDataPoints the previous data points used to classify the data point
     * @return a transportation mode classification
     */
    String classify(IDataPoint currentDataPoint, List<IDataPoint> previousDataPoints);

}
