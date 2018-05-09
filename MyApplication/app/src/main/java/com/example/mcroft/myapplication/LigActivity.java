package com.example.mcroft.myapplication;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class LigActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private ListView list;
    final ArrayList<Lig> liste = new ArrayList<>();
    private Takimadapter adapter;
    private int i;
    private static String authorUrl = "http://www.tff.org/default.aspx?pageID=198";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lig);

        list = (ListView)findViewById(R.id.add);
        adapter = new Takimadapter(LigActivity.this,liste);
        new FetchYazarlar().execute();

    }

    private class FetchYazarlar extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(LigActivity.this);
            progressDialog.setTitle("Süper Lig");
            progressDialog.setMessage("Şampiyonluk Yükleniyor...");
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            try{

              Document doc  = Jsoup.connect(authorUrl).get();

              Elements elements = doc.select("div[id=ctl00_MPane_m_198_1890_ctnr_m_198_1890_Panel1]");

              Elements table = elements.select("table");

                  Elements toy = table.select("tr");

                  for(i=0; i<19; i++) {

                          Elements tds = toy.get(i).select("td");
                      if(i!=0)
                          liste.add(new Lig(tds.get(0).text(), tds.get(2).text(),tds.get(3).text(),tds.get(4).text(), tds.get(8).text()));
                      else
                          liste.add(new Lig("  TAKIMLAR  ", tds.get(2).text(),tds.get(3).text(),tds.get(4).text(), tds.get(8).text()));
                  }

            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            list.setAdapter(adapter);
            progressDialog.dismiss();

        }
    }
}
