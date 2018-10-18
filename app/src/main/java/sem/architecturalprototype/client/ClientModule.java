package sem.architecturalprototype.client;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import sem.architecturalprototype.common.IServer;
import sem.architecturalprototype.server.Server;

/**
 * Module class for providing objects to be injected as dependencies
 */

@Module
public class ClientModule {

    @Provides
    @Singleton
    IServer provideServer() {
        return new Server();
    }

}
