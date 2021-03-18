package com.example.tick_tack;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

     public int[] gamestage = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
      public int[][] win = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {2, 4, 6}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}};
      public int x1 = 1;
      public int x2 = 0;
      public int y1;
      public long c1;

          //public void dropin(View v) throws InterruptedException {



        public void dropin(View v){
        ImageView img = (ImageView) v;

        Integer update = Integer.parseInt(img.getTag().toString());

        if (gamestage[update - 1] == 2 && x2<2) {
            gamestage[update - 1] = x1;

            img.setTranslationY(-1500);
            if (x1 == 1) {
                img.setImageResource(R.drawable.cross);
                x1 = 0;
            } else {
                img.setImageResource(R.drawable.oo);
                x1 = 1;
            }
            img.animate().translationYBy(1500).setDuration(300);


            TextView text1 = (TextView) findViewById(R.id.text01);
            for (int i = 0; i < 8; i++) {


                if (gamestage[win[i][0]] == gamestage[win[i][1]] && gamestage[win[i][1]] == gamestage[win[i][2]] && gamestage[win[i][0]] != 2) {

                    if (gamestage[win[i][0]] == 0) {
                        text1.setText("O WIN");
                        x2 = 3;
                       // y1=5;
                        break;
                    } else if (gamestage[win[i][0]] == 1) {
                        text1.setText("CROSS WIN");
                        x2 = 4;
                       // y1=5;
                        break;
                    }
                    else
                    {text1.setText("MATCH DRAW");
                        x2 = 5;
                      //  y1=5;
                        break;

                    }

                }
            }

            if (x2 == 3 || x2 == 4) {
                if (x2 == 3) {
                    Toast.makeText(getApplicationContext(), "O WIN TO START NEW GAME CLICK ON PANDA", Toast.LENGTH_LONG).show();
                } else if(x2==4){
                    Toast.makeText(getApplicationContext(), "CROSS WIN TO START NEW GAME CLICK ON PANDA", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "MATCH  DRAW TO START NEW GAME CLICK ON PANDA", Toast.LENGTH_LONG).show();
                }
                gamestage = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
                x1 = 1;
                x2 = 0;

                GridLayout grid=(GridLayout)findViewById(R.id.gridLayout);

                for(int i=0;i<grid.getChildCount();i++)
                {

                    img = (ImageView) grid.getChildAt(i);
                    img.setImageDrawable(null);
                }

            }
        }

    }

    public void resumein(View view) {

        gamestage = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        x1 = 1;
        x2 = 0;

        GridLayout grid=(GridLayout)findViewById(R.id.gridLayout);

        for(int i=0;i<grid.getChildCount();i++)
        {

            ImageView img = (ImageView) grid.getChildAt(i);
            img.setImageDrawable(null);
        }

        c1=0;
        //Timer1 obj1=new Timer1();
        //obj1.Count();

    }

public class Timer1{

     public int x1;

     public TextView t1=(TextView) findViewById(R.id.text01);

     public void Count() {


       // for (int i = 0; i < 9; i++)
        {
            String x11= getIntent().getStringExtra("key1");
            int x12=Integer.parseInt(x11);
            CountDownTimer count1 = new CountDownTimer(x12, 1000) {
                public void onTick(long millisUntilFinished) {


                    if(c1==0)
                    {

                        
                    }

                    c1=millisUntilFinished;

                    if (c1 / 1000 > 60) {
                         y1 = (int) ((c1 / 1000) - 60);
                       t1.setText("TIMER 01:" + c1);
                    } else {
                        t1.setText("TIMER 00:" + c1/ 1000);
                    }

                }


                public void onFinish() {


                    t1.setText("done!");

                    gamestage = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
                    x1 = 1;
                    x2 = 0;

                    GridLayout grid = (GridLayout) findViewById(R.id.gridLayout);

                    for (int i = 0; i < grid.getChildCount(); i++) {

                        ImageView img = (ImageView) grid.getChildAt(i);
                        img.setImageDrawable(null);
                    }
                }
            };

            count1.start();


        }


        
        

    }




}



    @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
           //Intent in1=new Intent(this,slaps.class);
           //startActivity(in1);

            setContentView(R.layout.activity_main);
          try {
            this.getSupportActionBar().hide();
          } catch (NullPointerException e) {
        }

        setContentView(R.layout.activity_main);



            //Strart001 obj2=new Strart001();
           // View v1 = null;
            //obj2.dropin(v1);




            TextView text211 = (TextView) findViewById(R.id.text03);

            text211.setText("RESUME");



        Timer1 obj=new Timer1();
         obj.Count();

        }


        public void update1()
        {



        }

        /*


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }*/
}
