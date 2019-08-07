package com.example.puppy.r1610861_1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);

        Gallery gallery = (Gallery)findViewById(R.id.gallery1);
        gallery.setAdapter(new ImageAdapter(this));

        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, final int position, long id) {
                ImageView img = (ImageView)findViewById(R.id.imageView2);
                if(position == 0)
                    img.setImageResource(R.drawable.artscrafts);
                if(position == 1)
                    img.setImageResource(R.drawable.chemicalbiological);
                if(position == 2)
                    img.setImageResource(R.drawable.chemistry);
                if(position == 3)
                    img.setImageResource(R.drawable.chinese);
                if(position == 4)
                    img.setImageResource(R.drawable.computerscience);
                Button btn = (Button)findViewById(R.id.button5);
                btn.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        ImageView img = (ImageView)findViewById(R.id.imageView2);
                        Intent intent = getIntent();
                        intent.putExtra("picselect",position);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }
        });

    }
}