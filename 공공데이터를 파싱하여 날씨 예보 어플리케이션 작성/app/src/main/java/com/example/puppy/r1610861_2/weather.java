package com.example.puppy.r1610861_2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@SuppressLint("NewApi")

public class weather extends AppCompatActivity {
    TextView textview;
    TextView dong;
    Document doc = null;
    LinearLayout layout = null;
    Intent intent;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        textview = (TextView)findViewById(R.id.textView3);
        dong = (TextView)findViewById(R.id.textView2);
        intent = getIntent();
        a = intent.getIntExtra("number",0);

        GetXMLTask task = new GetXMLTask(this);
        if(a == 1) {
            task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4128556000");
            dong.setText("마두 1동 일기예보");
        }
        else if (a == 2) {
            task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4128555100");
            dong.setText("백석 1동 일기예보");
        }
        else if (a == 3) {
            task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1117055500");
            dong.setText("청파동 일기예보");
        }
    }

    public void back(View v){
        finish();
    }

    @SuppressLint("NewApi")
    private class GetXMLTask extends AsyncTask<String, Void, Document> {
        private Activity context;

        public GetXMLTask(Activity context) {
            this.context = context;
        }

        @Override
        protected Document doInBackground(String... urls) {

            URL url;
            try {
                url = new URL(urls[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory
                        .newInstance();
                DocumentBuilder db;

                db = dbf.newDocumentBuilder();
                doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                Toast.makeText(getBaseContext(), "Parsing Error",
                        Toast.LENGTH_SHORT).show();
            }
            return doc;
        }

        @Override
        protected void onPostExecute(Document doc) {
            String s = "";
            NodeList nodeList = doc.getElementsByTagName("data");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element fstElmnt = (Element) node;
                NodeList nameList = fstElmnt.getElementsByTagName("hour");
                Element nameElement = (Element) nameList.item(0);
                nameList = nameElement.getChildNodes();

                s += ((Node) nameList.item(0)).getNodeValue() + "시 ";
                NodeList websiteList = fstElmnt.getElementsByTagName("wfKor");
                Element websiteElement = (Element) websiteList.item(0);
                websiteList = websiteElement.getChildNodes();
                s += ((Node) websiteList.item(0)).getNodeValue() + " ";

                NodeList tempList = fstElmnt.getElementsByTagName("temp");
                Element tempListElement = (Element) tempList.item(0);
                tempList = tempListElement.getChildNodes();
                s += ((Node) tempList.item(0)).getNodeValue() + "도\n";

            }
            textview.setText(s);
        }

    }
}
