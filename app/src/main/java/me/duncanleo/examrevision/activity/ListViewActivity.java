package me.duncanleo.examrevision.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.duncanleo.examrevision.R;
import me.duncanleo.examrevision.adapter.ListViewAdapter;
import me.duncanleo.examrevision.model.App;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView)findViewById(R.id.listView);

        String[] appNames = new String[] {
                "Calendar",
                "Contacts",
                "Facebook",
                "Twitter",
                "Messaging",
                "Dictionary Provider",
                "MusicFX CPU",
                "Nfc Service"
        };

        String[] appTypes = new String[] {
                "System",
                "Background"
        };

        List<App> fakeData = new ArrayList<>();
        for (String appName : appNames) {
            fakeData.add(new App(
                    "",
                    appName,
                    appTypes[randInt(0, 1)],
                    randInt(0, 100)
            ));
        }

        listView.setAdapter(new ListViewAdapter(fakeData));
    }

    private int randInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
