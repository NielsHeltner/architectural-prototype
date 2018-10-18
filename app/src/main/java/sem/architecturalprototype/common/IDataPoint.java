package sem.architecturalprototype.common;

/**
 * POJO representing a data point in time, with associated GPS coordinates, speed, and cell ID.
 */
public interface IDataPoint {

    double getLat();
    double getLon();
    double getSpeed();
    int getCellId();
    long getTimeStamp();

}
