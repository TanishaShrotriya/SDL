package com.example.shivanii.gamesataclick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class tictactoe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);
    }
    public static int count=0;
    int done=0;
    public void one(View view)
    {
       /*
        Button []buttons={};

        for(int i=0;i<10;i++)
        {
            buttons[i].setText("X");
        }*/
        //left to right

        count++;
        Button b1 = (Button)findViewById(R.id.button);
        if(done==0)
        {
            if (count % 2 == 0) {
                b1.setText("X");
                done = 1;
            } else {
                b1.setText("O");
                done = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
    int d=0;
    public void two(View v)
    {
        count++;

        Button b2=(Button)findViewById(R.id.button2);
        if(d==0)
        {
            if (count % 2 == 0) {
                b2.setText("X");
                d = 1;
            } else {
                b2.setText("O");
                d = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
    int d1=0;
    public void three(View v)
    {
        count++;

        Button b3=(Button)findViewById(R.id.button4);

        if(d1==0)
        {
            if (count % 2 == 0) {
                b3.setText("X");
                d1 = 1;
            } else {
                b3.setText("O");
                d1 = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
    int don=0;
    public void four(View v)
    {

        count++;
        Button b4=(Button)findViewById(R.id.button5);
        if(don==0)
        {
            if (count % 2 == 0) {
                b4.setText("X");
                don = 1;
            } else {
                b4.setText("O");
                don = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
    int dd=0;
    public void five(View v)
    {
        count++;

        Button b5=(Button)findViewById(R.id.button6);

        if(dd==0)
        {
            if (count % 2 == 0) {
                b5.setText("X");
                dd = 1;
            } else {
                b5.setText("O");
                dd = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
    int dn=0;
    public void six(View v)
    {

        count++;
        Button b6=(Button)findViewById(R.id.button7);

        if(dn==0)
        {
            if (count % 2 == 0) {
                b6.setText("X");
                dn = 1;
            } else {
                b6.setText("O");
                dn = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
    int d2=0;
    public void seven(View v)
    {
        count++;
        Button b7=(Button)findViewById(R.id.button8);
        if(d2==0)
        {
            if (count % 2 == 0) {
                b7.setText("X");
                d2= 1;
            } else {
                b7.setText("O");
                d2 = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
    int d3=0;
    public void eight(View v)
    {

        count++;
        Button b8=(Button)findViewById(R.id.button9);

        if(d3==0)
        {
            if (count % 2 == 0) {
                b8.setText("X");
                d3 = 1;
            } else {
                b8.setText("O");
                d3 = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
    int d4=0;
    public void nine(View v)
    {
        count++;
        Button b9=(Button)findViewById(R.id.b10);

        if(d4==0)
        {
            if (count % 2 == 0) {
                b9.setText("X");
                d4 = 1;
            } else {
                b9.setText("O");
                d4 = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
}
