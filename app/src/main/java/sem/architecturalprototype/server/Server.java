package sem.architecturalprototype.server;

import java.util.ArrayList;
import java.util.List;

import sem.architecturalprototype.common.IDataPoint;
import sem.architecturalprototype.common.IServer;

public class Server implements IServer {

    private final List<IDataPoint> dataPoints;
    private IClassifier classifier;

    public Server() {
        dataPoints = new ArrayList<>();

        setClassifier(new DummyClassifier());
    }

    @Override
    public int upload(IDataPoint dataPoint) {
        classifier.classify(dataPoint, dataPoints);
        dataPoints.add(dataPoint);

        return dataPoints.size();
    }

    /**
     * Method for dependency injection / late binding of a classifier
     *
     * @param classifier an implementation of the IClassifier interface
     */
    public void setClassifier(IClassifier classifier) {
        this.classifier = classifier;
    }

}
