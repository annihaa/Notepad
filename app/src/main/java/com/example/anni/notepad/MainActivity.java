package com.example.anni.notepad;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPref;
    public static final String MyPREFERENCES = "MyPreferences";
    public static final String Note = "Key";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        final EditText editor = findViewById(R.id.editText);
        final TextView written = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        String text=sharedPref.getString(Note, "t");
        written.setText(text);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = editor.getText().toString();
                written.append(t + "\n");
                SharedPreferences.Editor editor1 = sharedPref.edit();
                editor1.putString(Note, t);

                editor1.apply();
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"Program stared!", Toast.LENGTH_LONG).show();
    }

}