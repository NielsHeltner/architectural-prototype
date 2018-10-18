package sem.architecturalprototype.server;

import android.util.Log;

import java.util.List;

import sem.architecturalprototype.common.IDataPoint;

public class DummyClassifier implements IClassifier {

    @Override
    public String classify(IDataPoint currentDataPoint, List<IDataPoint> previousDataPoints) {
        Log.d("ap", "classifer");
        return "Walking";
    }

}
