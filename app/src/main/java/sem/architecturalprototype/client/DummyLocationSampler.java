package sem.architecturalprototype.client;

import sem.architecturalprototype.common.IDataPoint;

public class DummyLocationSampler implements ILocationSampler {

    @Override
    public IDataPoint sampleLocation() {
        return new DataPoint(50.0, 10.0, 5.0, 123, 123456789);
    }

}
