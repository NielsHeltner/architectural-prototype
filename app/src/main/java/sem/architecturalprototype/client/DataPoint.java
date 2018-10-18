package sem.architecturalprototype.client;

import sem.architecturalprototype.common.IDataPoint;

public class DataPoint implements IDataPoint {

    private final double lat;
    private final double lon;
    private final double speed;
    private final int cellId;
    private final long timeStamp;

    public DataPoint(double lat, double lon, double speed, int cellId, long timeStamp) {
        this.lat = lat;
        this.lon = lon;
        this.speed = speed;
        this.cellId = cellId;
        this.timeStamp = timeStamp;
    }

    @Override
    public double getLat() {
        return lat;
    }

    @Override
    public double getLon() {
        return lon;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public int getCellId() {
        return cellId;
    }

    @Override
    public long getTimeStamp() {
        return timeStamp;
    }

}
