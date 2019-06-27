package com.example.alekhsingh.androidinterviewstart;


import android.content.Intent;
import android.media.Rating;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FrontpageActivity extends AppCompatActivity implements View.OnClickListener {

    Button simbtn,toughbtn,appbtn,ratingbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setSubtitle(R.string.crack);

        toolbar.setNavigationIcon(R.drawable.ic_surround_sound_black_24dp);
        toolbar.setNavigationContentDescription("Navigation Icon");

        simbtn = (Button) findViewById(R.id.stq);
        toughbtn = (Button) findViewById(R.id.tq);
        appbtn = (Button) findViewById(R.id.otherapp);
        ratingbtn = (Button) findViewById(R.id.rateing);

        simbtn.setOnClickListener(this);
        toughbtn.setOnClickListener(this);
        appbtn.setOnClickListener(this);
        ratingbtn.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.stq:
                startActivity(new Intent(FrontpageActivity.this,Simple_question.class));
                break;

            case R.id.tq:
                startActivity(new Intent(FrontpageActivity.this,Tough_question.class));
                break;

            case R.id.otherapp:
                startActivity(new Intent(FrontpageActivity.this,Sharectivity.class));
                break;

            case R.id.rateing:

                try {
                    Uri uri = Uri.parse("market://details?id=" + getPackageName());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }catch (Exception x){

                    Uri uri = Uri.parse("http:google.play.store.com/store/details?id=" + getPackageName());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                    x.printStackTrace();
                }
                break;
        }
    }
}
