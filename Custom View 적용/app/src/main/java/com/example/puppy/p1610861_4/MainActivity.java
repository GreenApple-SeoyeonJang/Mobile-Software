package com.example.puppy.p1610861_4;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] majorEs= {
            "Arts & Crafts",
            "Chemical & Biological Engineering",
            "Chemistry",
            "Chinese Language & Literature",
            "Computer Science",
            "French Language & Culture",
            "Mathematics",
            "Orchestral Instruments",
            "Painting",
            "Physical Education"
    };
    String[] majorKs = {
            "공예과",
            "화공생명공학부",
            "화학과",
            "중어중문학부",
            "컴퓨터과학전공",
            "프랑스언어 & 문화학과",
            "수학과",
            "관현악과",
            "회화과",
            "체육교육과"
    } ;
    String[] yearlist = {
            "1948년",
            "2016년",
            "1968년",
            "1972년",
            "1983년",
            "1963년",
            "1975년",
            "1963년",
            "1948년",
            "1962년"
    } ;
    String[] profs = {
            "4명",
            "10명",
            "11명",
            "14명",
            "17명",
            "9명",
            "8명",
            "8명",
            "6명",
            "7명"
    } ;
    Integer[] images = {
            R.drawable.artscrafts,
            R.drawable.chemicalbiological,
            R.drawable.chemistry,
            R.drawable.chinese,
            R.drawable.computerscience,
            R.drawable.french,
            R.drawable.mathematics,
            R.drawable.orchestra,
            R.drawable.painting,
            R.drawable.physical,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomList adapter = new
                CustomList(MainActivity.this);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getBaseContext(), majorKs[+position], Toast.LENGTH_SHORT).show();
            }
        });
    }
    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        public CustomList(Activity context ) {
            super(context, R.layout.listitem, majorKs);
            this.context = context;
        }
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView= inflater.inflate(R.layout.listitem, null, true);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
            TextView majorK = (TextView) rowView.findViewById(R.id.majorK);
            TextView majorE = (TextView) rowView.findViewById(R.id.majorE);
            TextView year = (TextView) rowView.findViewById(R.id.year);
            TextView prof = (TextView) rowView.findViewById(R.id.prof);
            majorK.setText("학과명 : "+majorKs[position]);
            imageView.setImageResource(images[position]);
            majorE.setText("영문명 : " + majorEs[position]);
            year.setText(yearlist[position]);
            prof.setText(profs[position]);
            return rowView;
        }
    }
}
