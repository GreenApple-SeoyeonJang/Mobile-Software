package com.example.puppy.p1610861_8;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    dbHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        helper = new dbHelper(this);
        try {
            db = helper.getWritableDatabase();
        }catch (SQLiteException ex){
            db = helper.getReadableDatabase();
        }
    }
    public void insert(View view) {
        EditText ediname = (EditText)findViewById(R.id.editText);
        EditText editel = (EditText)findViewById(R.id.editText6);
        EditText edibirth = (EditText)findViewById(R.id.editText3);

        String sname = ediname.getText().toString();
        String stel = editel.getText().toString();
        String sbirth = edibirth.getText().toString();

        db.execSQL("INSERT INTO friends VALUES(null, '"+ sname + "' , '" + stel + "' , '" + sbirth +"');");
        Toast.makeText(getApplicationContext(), "추가되었음", Toast.LENGTH_SHORT).show();
        finish();
        Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(intent);
    }
}
