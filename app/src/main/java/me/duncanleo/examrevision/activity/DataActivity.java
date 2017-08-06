package me.duncanleo.examrevision.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.Locale;

import me.duncanleo.examrevision.R;
import me.duncanleo.examrevision.model.Fare;

public class DataActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_textview);

        textView = (TextView)findViewById(R.id.textView);

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

        textView.setText(String.format(
                Locale.getDefault(),
                "%s\n%s\n%s",
                sharedPreferences.getString("basicFare", "Not Found!"),
                sharedPreferences.getString("secondaryFare", "Not Found!"),
                sharedPreferences.getString("otherFare", "Not Found!")
        ));
    }
}
