package me.duncanleo.examrevision.activity;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

import me.duncanleo.examrevision.R;

public class LocationDistanceActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_textview);

        textView = (TextView)findViewById(R.id.textView);

        Location np = new Location("dummyprovider");
        np.setLatitude(1.333463);
        np.setLongitude(103.776764);

        Location sp = new Location("dummyprovider");
        sp.setLatitude(1.308358);
        sp.setLongitude(103.779141);

        textView.setText(String.format(
                Locale.getDefault(),
                "The distance between NP and SP is %.2fm",
                np.distanceTo(sp)
        ));
    }
}
