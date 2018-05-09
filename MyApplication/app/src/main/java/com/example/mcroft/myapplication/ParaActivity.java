package com.example.mcroft.myapplication;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class ParaActivity extends AppCompatActivity {

    private ListView listview;
    final ArrayList<Para> liste = new ArrayList<>();
    private ParaAdapter adapter;

    private ProgressDialog progressDialog;
    private String bitcoin,dolar,euro,i,sterlin;
    private static String authorUrl = "http://altin.tlkur.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para);

        listview=(ListView)findViewById(R.id.listview);

        adapter = new ParaAdapter(ParaActivity.this,liste);
        new ata().execute();

    }

    private class ata extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(ParaActivity.this);
            progressDialog.setTitle("Borsa");
            progressDialog.setMessage("Paralar Yükleniyor...");
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            try{

                Document doc  = Jsoup.connect(authorUrl).get();

                Elements fiyat = doc.select("div[class=middle gray_neutral] span[class=rate]");

                dolar = fiyat.get(0).text();
                euro = fiyat.get(1).text();
                bitcoin = fiyat.get(2).text();
                sterlin = fiyat.get(4).text();

                double bit=Double.valueOf(dolar).doubleValue()*Double.valueOf(bitcoin).doubleValue();

                i = String.valueOf((int)bit).toString();

                liste.add(new Para("1 Dolar : " + dolar + "TL"));
                liste.add(new Para("1 Euro : " + euro + "TL"));
                liste.add(new Para("1 Bticoin : " + bitcoin + "$"));
                liste.add(new Para("1 Bitcoin : " + i + "TL"));
                liste.add(new Para("1 Sterlin : " + sterlin + "TL"));

            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            //text.setText("1 BTC = "+ bitcoin + " $\n\n1 BTC = " + i + " TL\n\n1 Dolar = " + dolar +" TL\n\n1 Euro = " + euro +" TL\n\n1 Sterlin = " + sterlin +" TL");
            listview.setAdapter(adapter);
            progressDialog.dismiss();

        }
    }
}
