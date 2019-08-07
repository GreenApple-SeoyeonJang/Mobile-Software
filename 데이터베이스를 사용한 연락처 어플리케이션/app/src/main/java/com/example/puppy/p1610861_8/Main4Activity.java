package com.example.puppy.p1610861_8;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main4Activity extends AppCompatActivity {

    dbHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        helper = new dbHelper(this);
        db = helper.getWritableDatabase();

        final Intent intent = getIntent();

        EditText edi7 = (EditText)findViewById(R.id.editText7);
        EditText edi8 = (EditText)findViewById(R.id.editText8);
        EditText edi9 = (EditText)findViewById(R.id.editText9);

        edi7.setText(intent.getExtras().getString("name"));
        edi8.setText(intent.getExtras().getString("tel"));
        edi9.setText(intent.getExtras().getString("birth"));

        findViewById(R.id.button3).setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        EditText edd = (EditText)findViewById(R.id.editText7);
                        EditText ed = (EditText)findViewById(R.id.editText8);
                        EditText er = (EditText)findViewById(R.id.editText9);
                        String name = edd.getText().toString();
                        String tel = ed.getText().toString();
                        String birth = er.getText().toString();
                        db.execSQL("UPDATE friends SET birth = '" + birth + "' WHERE name = '" + intent.getExtras().getString("name") + "';");
                        db.execSQL("UPDATE friends SET tel = '" + tel + "' WHERE name = '"+ intent.getExtras().getString("name") + "';");
                        db.execSQL("UPDATE friends SET name = '" + name + "' WHERE name = '" + intent.getExtras().getString("name") + "';");

                        Intent intent = getIntent();
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });

        findViewById(R.id.button4).setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        EditText edd = (EditText)findViewById(R.id.editText7);
                        String name = edd.getText().toString();

                        db.execSQL("DELETE FROM friends WHERE name = '" + intent.getExtras().getString("name") +"';");

                        Intent intent = getIntent();
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
    }


}
