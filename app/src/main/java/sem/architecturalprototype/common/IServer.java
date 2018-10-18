package sem.architecturalprototype.common;

public interface IServer {

    /**
     * Upload an IDataPoint to the server for processing
     * @param dataPoint the newest IDataPoint to be processed
     * @return whether the process was successful or not
     */
    boolean upload(IDataPoint dataPoint);

}
