package com.example.shivanii.gamesataclick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class bingo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bingo);
    }
    public static int cnt=0;

    public void show(View view)
    {

        Button b1=(Button)findViewById(R.id.button);
        Button b2=(Button)findViewById(R.id.button2);
        Button b3=(Button)findViewById(R.id.button3);
        Button b4=(Button)findViewById(R.id.button4);
        Button b5=(Button)findViewById(R.id.button5);
        Button b6=(Button)findViewById(R.id.button6);
        Button b7=(Button)findViewById(R.id.button7);
        Button b8=(Button)findViewById(R.id.button8);
        Button b9=(Button)findViewById(R.id.button9);
        Button b10=(Button)findViewById(R.id.button10);
        Button b11=(Button)findViewById(R.id.button11);
        Button b12=(Button)findViewById(R.id.button12);
        Button b13=(Button)findViewById(R.id.button13);
        Button b14=(Button)findViewById(R.id.button14);
        Button b15=(Button)findViewById(R.id.button15);
        Button b16=(Button)findViewById(R.id.button17);
        Button b17=(Button)findViewById(R.id.button18);
        Button b18=(Button)findViewById(R.id.button19);
        Button b19=(Button)findViewById(R.id.button20);
        Button b20=(Button)findViewById(R.id.button21);
        Button b21=(Button)findViewById(R.id.button22);
        Button b22=(Button)findViewById(R.id.button23);
        Button b23=(Button)findViewById(R.id.button24);
        Button b24=(Button)findViewById(R.id.button25);
        Button b25=(Button)findViewById(R.id.button26);

        Button butt[]={b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25};



        {
            //cnt++;

            for(int i = 0; i<butt.length; i++)
            {
                final Button b = butt[i];
                b.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        cnt++;
                        if(cnt<26)
                        {
                            b.setText(""+cnt);

                        }
                    }
                });
            }
        }
    }

}
