package me.duncanleo.examrevision.activity;

import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.Locale;

import me.duncanleo.examrevision.R;
import me.duncanleo.examrevision.model.Fare;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_EDIT_TEXT = "editText";
    public static final String TAG = "MainActivity";

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

        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<Fare> fareJsonAdapter = moshi.adapter(Fare.class);

        Fare basicFare = new Fare(
                "Flag-Down (inclusive of 1st km or less)",
                3.40,
                3.90,
                5.00
        );

        Fare secondaryFare = new Fare(
                "Every 400m thereafter or less up to 10km",
                0.22,
                0.22,
                0.33
        );

        Fare otherFare = new Fare(
                "Every 350 metres thereafter or less after 10 km",
                0.22,
                0.22,
                0.33
        );

        String basicJson = fareJsonAdapter.toJson(basicFare);
        String secondaryJson = fareJsonAdapter.toJson(secondaryFare);
        String otherJson = fareJsonAdapter.toJson(otherFare);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("basicFare", basicJson);
        editor.putString("secondaryFare", secondaryJson);
        editor.putString("otherFare", otherJson);

        editor.apply();

        // Read and dump
        Log.d(TAG, sharedPreferences.getString("basicFare", "Not Found!"));
        Log.d(TAG, sharedPreferences.getString("secondaryFare", "Not Found!"));
        Log.d(TAG, sharedPreferences.getString("otherFare", "Not Found!"));
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
