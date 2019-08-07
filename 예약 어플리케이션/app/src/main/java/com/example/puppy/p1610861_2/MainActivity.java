package com.example.puppy.p1610861_2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button datebt, timebt, canclebt;
    EditText reserve;
    String datestr, timestr;
    private TimePickerDialog timepicker;
    private DatePickerDialog datepicker;
    private AlertDialog alertdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datebt = (Button)findViewById((R.id.button));
        timebt= (Button)findViewById((R.id.button2));
        canclebt = (Button)findViewById((R.id.button3));
        reserve = (EditText)findViewById((R.id.editText2));
        reserve.setText("");
        datestr = ""; timestr = "";
    }
    public void setdate(View view){
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datepicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                datestr = year + "년 " + (monthOfYear + 1) + "월 " + dayOfMonth + "일";
                if(timestr.equals(""))
                    reserve.setText(datestr);
                else
                    reserve.setText((datestr + " " + timestr));
            }
        },mYear, mMonth, mDay);
        datepicker.show();
    }
    public void settime(View view){

        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        TimePickerDialog timepicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if(hourOfDay == 0)
                    timestr = "오전 " + (hourOfDay+12) + "시 " + minute + "분";
                else if(hourOfDay == 12)
                    timestr = "오후 " + hourOfDay + "시 " + minute + "분";
                else if(hourOfDay >12)
                    timestr = "오후 " + (hourOfDay-12) + "시 " + minute + "분";
                else
                    timestr = "오전 " + hourOfDay + "시 " + minute + "분";
                if(datestr.equals(""))
                    reserve.setText(timestr);
                else
                    reserve.setText((datestr + " " + timestr));
            }
        },mHour, mMinute, false);
        timepicker.show();
    }
    public void cancle(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("취소하시겠습니까?");
        alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                timestr = ""; datestr = "";
                reserve.setText("");
                Toast.makeText(MainActivity.this,"취소되었습니다.",Toast.LENGTH_LONG).show();
            }
        });
        alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "예약을 유지합니다.",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertdialog = alertDialogBuilder.create();
        alertdialog.show();
    }
}
