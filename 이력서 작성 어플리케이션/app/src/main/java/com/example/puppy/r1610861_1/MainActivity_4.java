package com.example.puppy.r1610861_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_4);

        Button btn = (Button)findViewById(R.id.button6);
        EditText edifive = (EditText) findViewById(R.id.editText5);
        EditText edisix = (EditText) findViewById(R.id.editText6);
        EditText ediseven = (EditText) findViewById(R.id.editText7);
        EditText edieight = (EditText) findViewById(R.id.editText8);
        ImageView lastimage = (ImageView)findViewById(R.id.imageView3);

        Intent intent = getIntent();
        int pic = intent.getExtras().getInt("selectpic");
        String element = intent.getExtras().getString("element");
        String mid = intent.getExtras().getString("mid");
        String high = intent.getExtras().getString("high");
        String univ = intent.getExtras().getString("univ");

        edifive.setText(element);
        edisix.setText(mid);
        ediseven.setText(high);
        edieight.setText(univ);

        if(pic==0)
            lastimage.setImageResource(R.drawable.artscrafts);
        if(pic==1)
            lastimage.setImageResource(R.drawable.chemicalbiological);
        if(pic==2)
            lastimage.setImageResource(R.drawable.chemistry);
        if(pic==3)
            lastimage.setImageResource(R.drawable.chinese);
        if(pic==4)
            lastimage.setImageResource(R.drawable.computerscience);
    }
    public void finish(View view){
        finish();
    }
}
