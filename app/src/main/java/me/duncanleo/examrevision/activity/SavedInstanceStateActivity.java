package me.duncanleo.examrevision.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import me.duncanleo.examrevision.R;

public class SavedInstanceStateActivity extends AppCompatActivity {
    public static final String KEY_EDIT_TEXT = "editText";

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_instance_state);

        editText = (EditText)findViewById(R.id.editText);
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
