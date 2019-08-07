package com.example.puppy.r1610861_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        Button button = (Button) findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText edione = (EditText) findViewById(R.id.editText);
                EditText editwo = (EditText) findViewById(R.id.editText2);
                EditText edithree = (EditText) findViewById(R.id.editText3);
                EditText edifour = (EditText) findViewById(R.id.editText4);
                Intent intent = getIntent();
                intent.putExtra("element",edione.getText().toString());
                intent.putExtra("middle",editwo.getText().toString());
                intent.putExtra("high",edithree.getText().toString());
                intent.putExtra("univ",edifour.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
