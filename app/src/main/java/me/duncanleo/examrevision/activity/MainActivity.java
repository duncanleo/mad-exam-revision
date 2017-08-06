package me.duncanleo.examrevision.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import me.duncanleo.examrevision.R;

public class MainActivity extends AppCompatActivity {
    private Button sis, location, data, list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sis = (Button) findViewById(R.id.sisButton);
        location = (Button) findViewById(R.id.locationButton);
        data = (Button) findViewById(R.id.dataButton);
        list = (Button) findViewById(R.id.listButton);

        sis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity(SavedInstanceStateActivity.class);
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity(LocationDistanceActivity.class);
            }
        });

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity(DataActivity.class);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity(ListViewActivity.class);
            }
        });
    }

    private void launchActivity(Class c) {
        startActivity(new Intent(this, c));
    }
}
