package com.example.alekhsingh.androidinterviewstart;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by alekh singh on 1/8/2019.
 */
public class Simple_question extends AppCompatActivity implements View.OnClickListener {


    String[] simple_qustion,simple_answer;
    TextView tvquestion,tvanswer,tvpresentindex_xx,tvtotalindex_yy;

    Button lside,show,rside;
    int index;

    TextToSpeech textToSpeech;
    int result;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

        index=0;
        // Inisilization of TextView
        tvpresentindex_xx= (TextView) findViewById(R.id.tvxx);
        tvtotalindex_yy= (TextView) findViewById(R.id.tvyy);

        tvquestion= (TextView) findViewById(R.id.tv_question);
        tvanswer= (TextView) findViewById(R.id.defineanswer);

        // Inisilization of Buttons
        lside= (Button) findViewById(R.id.lbtn);
        rside= (Button) findViewById(R.id.rbtn);
        show= (Button) findViewById(R.id.showanswer);

        lside.setOnClickListener(this);
        rside.setOnClickListener(this);
        show.setOnClickListener(this);


        //Importing the string array from values folder
        simple_qustion=getResources().getStringArray(R.array.my_simple_qus);
        simple_answer=getResources().getStringArray(R.array.my_simple_ans);

        //setting values to our varible and 4 texview

          tvquestion.setText(simple_qustion[index]);
          tvanswer.setText(R.string.forAnswer);
          tvpresentindex_xx.setText(String.valueOf(index+1));
          tvtotalindex_yy.setText(String.valueOf("/"+simple_qustion.length));


    textToSpeech = new TextToSpeech(Simple_question.this, new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {

            if(status == TextToSpeech.SUCCESS){

              result = textToSpeech.setLanguage(Locale.UK);

            }else{

                Toast.makeText(Simple_question.this, "You device are not supported", Toast.LENGTH_SHORT).show();
            }

        }
    });

}

    @Override
    public void onClick(View view) {

       switch (view.getId()){

           case R.id.lbtn:

               tvanswer.setText(R.string.forAnswer);
               index--;

               if(index == -1){

                   index = simple_qustion.length-1;

                   tvquestion.setText(simple_qustion[index]);
                   tvpresentindex_xx.setText(String.valueOf(index+1));

               }else{

                   tvquestion.setText(simple_qustion[index]);
                   tvpresentindex_xx.setText(String.valueOf(index+1));
               }

               break;

           case R.id.showanswer:

               tvanswer.setText(simple_answer[index]);

               if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){

                   Toast.makeText(this, "Your device not supported", Toast.LENGTH_SHORT).show();
               }else{

                   textToSpeech.speak(simple_answer[index],TextToSpeech.QUEUE_FLUSH,null);
               }

               break;

           case R.id.rbtn:
               index++;

               tvanswer.setText(R.string.forAnswer);

               if(index == simple_qustion.length){

                   index=0;
                   tvquestion.setText(simple_qustion[index]);

                   tvpresentindex_xx.setText(String.valueOf(index+1));


               }else{
                   tvquestion.setText(simple_qustion[index]);

                   tvpresentindex_xx.setText(String.valueOf(index+1));

               }
               break;
       }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(textToSpeech != null){

            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}
