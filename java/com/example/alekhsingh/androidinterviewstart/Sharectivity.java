package com.example.alekhsingh.androidinterviewstart;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.math.BigDecimal;

public class Sharectivity extends AppCompatActivity {

    TextInputLayout nameInputLayout, mobInputLayout;
    TextInputEditText nameEditText, mobEditText;
    private String location="https://github.com/RishiTanu/Android-Interview";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharectivity);


        nameEditText = findViewById(R.id.nameEditText);
        mobEditText = findViewById(R.id.mobEditText);

        nameInputLayout = findViewById(R.id.nameInputLayout);
        nameInputLayout.setCounterMaxLength(50);
        mobInputLayout =  findViewById(R.id.mobInputLayout);


        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        mobEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Button b1=findViewById(R.id.click_to_share);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(nameEditText.length()>0 && mobEditText.length()>0) {

                    if (mobEditText.getText().toString().matches("[0-9]+") && mobEditText.length() == 10) {

                        String shareBody = "You share GitHub Address " + getResources().getString(R.string.app_name) + " \nShare Person Name = " + nameEditText.getText().toString() + "\n" +
                                "Mobile Number= " + mobEditText.getText().toString() + "\n Download project From " + location + "";

                        Intent sharingintent = new Intent(Intent.ACTION_SEND);
                        sharingintent.setType("text/plain");
                        sharingintent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
                        sharingintent.putExtra(Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingintent, ""));
                    }else{
                        Toast.makeText(Sharectivity.this, "Enter correct mobile number", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(Sharectivity.this, "Mandetory field for share", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
