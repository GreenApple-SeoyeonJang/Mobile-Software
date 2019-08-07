package com.example.puppy.p1610861_5;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        Intent intent = null;
        RadioButton r1 = findViewById(R.id.radioButton4);
        RadioButton r2 = findViewById(R.id.radioButton3);
        EditText usertext = findViewById((R.id.editText));
        boolean checked1 = r1.isChecked();
        boolean checked2 = r2.isChecked();
        String txt = usertext.getText().toString();

        if (checked1) {
            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + txt));
    }
        else if (checked2) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(txt));
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
