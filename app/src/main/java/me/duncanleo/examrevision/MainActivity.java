package me.duncanleo.examrevision;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_EDIT_TEXT = "editText";

    private EditText editText;
    private TextView location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        location = (TextView)findViewById(R.id.locationTextView);

        Location np = new Location("dummyprovider");
        np.setLatitude(1.333463);
        np.setLongitude(103.776764);

        Location sp = new Location("dummyprovider");
        sp.setLatitude(1.308358);
        sp.setLongitude(103.779141);

        location.setText(String.format(
                Locale.getDefault(),
                "The distance between NP and SP is %.2fm",
                np.distanceTo(sp)
        ));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_EDIT_TEXT, editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        editText.setText(savedInstanceState.getString(KEY_EDIT_TEXT));
    }
}
