package com.example.puppy.p1610861_6;

import android.app.Activity;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends Activity {
    public int choice = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mpone = MediaPlayer.create(this,R.raw.lie);
        final MediaPlayer mptwo = MediaPlayer.create(this,R.raw.ocean);
        final MediaPlayer mpthree = MediaPlayer.create(this,R.raw.wonder);

        final Button start = (Button)findViewById(R.id.button);
        final Button stop = (Button)findViewById(R.id.button2);
        final RadioButton rd1 = (RadioButton)findViewById(R.id.radioButton);
        final RadioButton rd2 = (RadioButton)findViewById(R.id.radioButton2);
        final RadioButton rd3 = (RadioButton)findViewById(R.id.radioButton3);

        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                boolean onechecked = rd1.isChecked();
                boolean twochecked = rd2.isChecked();
                boolean threechecked = rd3.isChecked();

                if(onechecked) {
                    mpone.start();
                    mpone.seekTo(0);
                }
                else if(twochecked){
                    mptwo.start();
                    mptwo.seekTo(0);
                 }
                else if(threechecked) {
                mpthree.start();
                mpthree.seekTo(0);
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(mpone.isPlaying())
                    mpone.pause();
                else if(mptwo.isPlaying())
                    mptwo.pause();
                else if(mpthree.isPlaying())
                    mpthree.pause();
            }
        });
    }

}
