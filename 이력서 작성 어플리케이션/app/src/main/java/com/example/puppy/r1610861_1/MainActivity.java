package com.example.puppy.r1610861_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU_info = 1;
    public static final int REQUEST_CODE_MENU_pic = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int mypic;
    String element, mid, high, univ;

    public void onclickone(View view){
        Button btt = (Button)findViewById(R.id.button);
       Intent in = new Intent(getApplicationContext(),MainActivity_2.class);
       startActivityForResult(in, REQUEST_CODE_MENU_info);
    }
@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == REQUEST_CODE_MENU_info){
            if(resultCode == RESULT_OK){
                element = data.getStringExtra("element");
                mid = data.getStringExtra("middle");
                high = data.getStringExtra("high");
                univ = data.getStringExtra("univ");
            }
        }
        if(requestCode == REQUEST_CODE_MENU_pic){
             if(resultCode == RESULT_OK){
                mypic = data.getIntExtra("picselect",100);
            }
        }
    }
    public void onclicktwo(View view){
        ImageView img = (ImageView)findViewById(R.id.imageView);
        Intent intent = new Intent(getApplicationContext(),MainActivity_3.class);
        startActivityForResult(intent, REQUEST_CODE_MENU_pic);
    }
    public void onclickthree(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity_4.class);
        intent.putExtra("selectpic",mypic);
        intent.putExtra("element",element);
        intent.putExtra("mid",mid);
        intent.putExtra("high",high);
        intent.putExtra("univ",univ);
        startActivity(intent);
    }

}
