package sem.architecturalprototype.client;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import sem.architecturalprototype.R;
import sem.architecturalprototype.common.IServer;
import sem.architecturalprototype.server.Server;

public class MainActivity extends AppCompatActivity {

    private IServer server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setServer(new Server());
    }

    public void upload(View view) {
        Log.d("ap", "client upload");
        server.upload(new DataPoint(50.0, 10.0, 5.0, 123, 123456789));
    }

    /**
     * Method for dependency injection / late binding of a server
     *
     * @param server an implementation of the IServer interface
     */
    public void setServer(IServer server) {
        this.server = server;
    }

}
