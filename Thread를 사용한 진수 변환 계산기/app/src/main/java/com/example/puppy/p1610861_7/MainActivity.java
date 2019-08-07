package com.example.puppy.p1610861_7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    twothread t; threethread th;

    boolean running = true;

    public class twothread extends Thread{
        public void run(){
            final EditText editen = (EditText)findViewById(R.id.editText);
            final EditText editwo = (EditText)findViewById(R.id.editText2);
            int i = Integer.parseInt(editen.getText().toString().replaceAll(" ",""));
            int k = 0;
            int sum = 0;
            int j = 0;
            int[] val = new int[100];
            for(j = 0; i >=2; j++){
                val[j] = i%2;
                i = i/2;
            }
            val[j] = i;
            for(k = j;k>=0;k--){
                sum = (sum*10) + val[k];
            }
            final String m = String.valueOf(sum);
            editwo.post(new Runnable(){
                public void run() {
                    editwo.setText(m);
                }
            });
        }
    }
    public class threethread extends Thread{
        public void run(){
            EditText editen = (EditText)findViewById(R.id.editText);
            final  EditText edithree = (EditText)findViewById(R.id.editText3);
            int i = Integer.parseInt(editen.getText().toString().replaceAll(" ",""));
            int j = 0,k,sum=0;
            int[] val = new int[100];
            for(j = 0; i >=3; j++){
                val[j] = i%3;
                i = i/3;
            }
            val[j] = i;
            for(k = j;k>=0;k--){
                sum = (sum*10) + val[k];
            }
            final String m = String.valueOf(sum);
            edithree.post(new Runnable(){
                public void run() {
                    edithree.setText(m);
                }
            });
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View v){
        t = new twothread();
        th = new threethread();
        running = true;
        t.start();
        th.start();
    }

}
