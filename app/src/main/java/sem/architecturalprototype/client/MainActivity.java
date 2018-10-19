package sem.architecturalprototype.client;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import sem.architecturalprototype.R;
import sem.architecturalprototype.common.IServer;
import sem.architecturalprototype.server.Server;

public class MainActivity extends AppCompatActivity {

    public static final int DUTY_CYCLE_INTERVAL = 3;

    private Button sampleButton;
    private TextView sampleStatus;
    private TextView sampleSize;

    private IServer server;
    private ILocationSampler locationSampler;

    private ScheduledExecutorService executorService;
    private boolean isSampling = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        executorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

        setServer(new Server());
        setLocationSampler(new DummyLocationSampler());
    }

    public void startSampling(View view) {
        if (!isSampling) {
            sampleButton.setText(getString(R.string.button_text_sampling));
            sampleButton.setEnabled(false);
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    int dataPointsCount = server.upload(locationSampler.sampleLocation());

                    sampleStatus.setText(getString(R.string.sample_status_sampling, getCurrentTimeFormatted()));
                    sampleSize.setText(getString(R.string.sample_size, dataPointsCount));
                }
            }, 0, DUTY_CYCLE_INTERVAL, TimeUnit.SECONDS);
            isSampling = true;
        }
    }

    /**
     * Method for dependency injection / late binding of a server
     *
     * @param server an implementation of the IServer interface
     */
    public void setServer(IServer server) {
        this.server = server;
    }

    /**
     * Method for dependency injection / late binding of a locationSampler
     *
     * @param locationSampler an implementation of the ILocationSampler interface
     */
    public void setLocationSampler(ILocationSampler locationSampler) {
        this.locationSampler = locationSampler;
    }

    private void initializeViews() {
        ((TextView) findViewById(R.id.sampleRate)).setText(getString(R.string.sample_rate, DUTY_CYCLE_INTERVAL));
        sampleButton = findViewById(R.id.sampleButton);
        sampleStatus = findViewById(R.id.sampleStatus);
        sampleSize = findViewById(R.id.sampleSize);
    }

    private String getCurrentTimeFormatted() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return simpleDateFormat.format(new Date());
    }

}
