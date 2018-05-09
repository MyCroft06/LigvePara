package com.example.mcroft.myapplication;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView paracard,ligcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        if (Build.VERSION.SDK_INT > 20)
            window.setStatusBarColor(getResources().getColor(R.color.blue));

        paracard = (CardView) findViewById(R.id.btn_doviz);
        ligcard = (CardView) findViewById(R.id.btn_lig);

        paracard.setOnClickListener(this);
        ligcard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
        case R.id.btn_doviz : i = new Intent(this,ParaActivity.class); startActivity(i); break;
        case R.id.btn_lig : i = new Intent(this,LigActivity.class); startActivity(i); break;
        default: break;
        }
    }
}
