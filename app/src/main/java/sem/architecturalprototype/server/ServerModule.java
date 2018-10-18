package sem.architecturalprototype.server;

import android.util.Log;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import sem.architecturalprototype.common.IDataPoint;

/**
 * Module class for providing objects to be injected as dependencies
 */

@Module
public class ServerModule {

    @Provides
    IClassifier provideClassifier() {
        return new IClassifier() {
            @Override
            public String classify(IDataPoint currentDataPoint, List<IDataPoint> previousDataPoints) {
                return "Walking";
            }
        };
    }

}
