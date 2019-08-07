package kr.co.company.mydraw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private SingleTouchView drawView;
    private ImageButton currPaint;
    private ImageButton brushsize;
    private ImageButton erase;
    private int flag=0, size=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawView = (SingleTouchView) findViewById(R.id.drawing);
        LinearLayout paintLayout = (LinearLayout) findViewById(R.id.paint_colors);
        currPaint = (ImageButton) paintLayout.getChildAt(0);
        brushsize = (ImageButton)findViewById(R.id.draw_btn);
        erase = (ImageButton)findViewById(R.id.erase_btn);
    }

    public void brushsize(View view){
            if(flag == 0)
                size = size + 5;
            else if(flag == 1)
                size = size - 5;
            drawView.brushsize(size);
        if(size >= 50)
            flag = 1;
        else if(size <= 10)
            flag = 0;
    }
    public void eraseall (View view){
        drawView.erase();
    }
    public void clicked(View view) {
        if (view != currPaint) {
            String color = view.getTag().toString();
            drawView.setColor(color);
            currPaint = (ImageButton) view;
        }
    }

}
