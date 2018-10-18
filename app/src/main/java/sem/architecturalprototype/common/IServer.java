package sem.architecturalprototype.common;

public interface IServer {

    /**
     * Upload an IDataPoint to the server for processing
     *
     * @param dataPoint the newest IDataPoint to be processed
     * @return the amount of data points uploaded to the server
     */
    int upload(IDataPoint dataPoint);

}
