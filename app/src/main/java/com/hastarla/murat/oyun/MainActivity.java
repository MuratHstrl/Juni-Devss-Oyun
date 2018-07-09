package com.hastarla.murat.oyun;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
TextView textView;
TextView textView2;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;
    ImageView image8;
    ImageView image9;
    ImageView image10;
    int skore;
    ImageView [] resim ;
    Handler handler;
    Runnable run;
    int i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        skore=0;
        image2=(ImageView) findViewById(R.id.imageView2);
        image3=(ImageView) findViewById(R.id.imageView3);
        image4=(ImageView) findViewById(R.id.imageView4);
        image5=(ImageView) findViewById(R.id.imageView5);
        image6=(ImageView) findViewById(R.id.imageView6);
        image7=(ImageView) findViewById(R.id.imageView7);
        image8=(ImageView) findViewById(R.id.imageView8);
        image9=(ImageView) findViewById(R.id.imageView9);
        image10=(ImageView) findViewById(R.id.imageView10);
        resim=new ImageView[]{image2,image3,image4,image5,image6,image7,image8,image9,image10};

oyun();
        new CountDownTimer(30000,1000){
            public void onTick(long millisUntilFinished){
                textView=(TextView) findViewById(R.id.textView);
                textView.setText("Süre: "+ millisUntilFinished /1000);

            }
            public void onFinish(){

                textView=(TextView) findViewById(R.id.textView);
                textView.setText("Süren Bitti");
                handler.removeCallbacks(run);
                resim[i].setVisibility(View.INVISIBLE);

            }
        }.start();
    }
    public void Puan(View view){
        textView2=(TextView) findViewById(R.id.textView2);

  skore++;
  textView2.setText("Puan: "+ skore);

    }
    public void oyun(){

        handler=new Handler();
        run=new Runnable() {
            @Override
            public void run() {
                for (ImageView isim : resim) {
                    isim.setVisibility(View.INVISIBLE);
                }
                Random r = new Random();
i= r.nextInt(9-0);
resim[i].setVisibility(View.VISIBLE);
handler.postDelayed(this,500);
                }
        };
        handler.post(run);

    }
}
