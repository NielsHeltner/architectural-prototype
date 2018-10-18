package sem.architecturalprototype.client;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import sem.architecturalprototype.R;
import sem.architecturalprototype.common.IServer;

public class MainActivity extends AppCompatActivity {

    private IServer server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method for dependency injection / late binding of a server
     * @param server an implementation of the IServer interface
     */
    @Inject
    public void setServer(IServer server) {
        this.server = server;
    }

}
