package com.example.puppy.p1610861_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnzero;
    Button btnone;
    Button btntwo;
    Button btnplus;
    Button btnmul;
    Button btneq;
    Button btnclear;
    EditText eText;
    EditText eTextre;
    int i=0;
    int num [] = new int[100]; // + 일 경우 -1로, *일 경우 -2로 처리하여 스택에 넣음
    int spare[] = new int[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eText = (EditText) findViewById(R.id.editText);
        eTextre = (EditText)findViewById(R.id.editText2);
        btnzero = (Button)findViewById(R.id.button4);
        btnone = (Button)findViewById(R.id.button3);
        btntwo = (Button)findViewById(R.id.button2);
        btnplus = (Button)findViewById(R.id.button7);
        btnmul = (Button)findViewById(R.id.button6);
        btneq = (Button)findViewById(R.id.button5);
        btnclear = (Button)findViewById(R.id.button);
    }
    public void writezero(View view){
        num[i] = (num[i]*3) + 0;
        eText.setText(eText.getText() + "0");
    }
    public void writeone(View view){
        num[i] = (num[i]*3) + 1;
        eText.setText(eText.getText() + "1");
    }
    public void writetwo(View view){
        num[i] = (num[i]*3) + 2;
        eText.setText(eText.getText() + "2");
    }
    public void writeplus(View view){
        i++;
        num[i] = -1;
        i++;
        eText.setText(eText.getText() + " + ");
    }
    public void writemul(View view){
        i++;
        num[i] = -2;
        i++;
        eText.setText( eText.getText() + " * ");
    }
    public void writeeq(View view){
        for(int k =0; k <=i; k++)
            spare[k] = num[k];

        for(int j = 0; j <=i; j++){
            if ( spare[j] == -2){
                spare[j-1] = spare[j-1] * spare[j+1];
                for(int n = j; n <=i; n++){
                    spare[n] = spare[n+2];
                }
                j--;
            }
        }
        for(int j = 0; j <=i; j++){
            if ( spare[j] == -1){
                spare[j-1] = spare[j-1] + spare[ j+1];
                for(int n = j; n <=i; n++){
                    spare[n] = spare[n+2];
                }
                j--;
            }
        }
        eTextre.setText("결과 : " + spare[0]);
    }

    public void writeclear(View view){
        for(i = 0; i < 100; i ++)
            num[i] = 0;
        i = 0;
        eText.setText("입력 : ");
        eTextre.setText("결과 : ");
    }

}
