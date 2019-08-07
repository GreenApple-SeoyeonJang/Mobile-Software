package com.example.puppy.p1610861_8;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    dbHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        helper = new dbHelper(this);
        db = helper.getWritableDatabase();
        final Cursor cursor = db.rawQuery("SELECT  * FROM friends", null);
        startManagingCursor(cursor);
        String[] from = {"name","tel","birth"};
        int[] to = {(R.id.textView10) ,(R.id.textView8),(R.id.textView9)};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listitem, cursor, from, to);
        ListView list = (ListView) findViewById(R.id.listview1);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg4) {
                Intent intent = new Intent(getApplicationContext(), com.example.puppy.p1610861_8.Main4Activity.class);
                intent.putExtra("name",cursor.getString(1));
                intent.putExtra("tel",cursor.getString(2));
                intent.putExtra("birth",cursor.getString(3));
                startActivity(intent);
            }
        });

    }

    public void back(View view){
        Intent intent = getIntent();
        setResult(RESULT_OK, intent);
        finish();
    }
}
