package com.example.shivanii.gamesataclick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.net.*;
import java.io.*;

public class tictactoe extends AppCompatActivity {

    static tictactoe2 t ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        t = (tictactoe2)getIntent().getParcelableExtra("tObject");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);


    }
    //   public static int count=0;
   // int done=0;
   public void one(View view)
    {

        t.count++;
        Button b1 = (Button)findViewById(R.id.button);
        if(t.done==0)
        {
            if (t.count % 2 == 0) {
                b1.setText("X");
                t.done = 1;
            } else {
                b1.setText("O");
                t.done = 1;
            }


        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
        Thread th = new Thread(new tictactoeThread());
        th.start();

        Toast.makeText(this, "Thread supposedly started", Toast.LENGTH_SHORT).show();

    }
  //  int d=0;
    public void two(View v)
    {
        t.count++;

        Button b2=(Button)findViewById(R.id.button2);
        if(t.d==0)
        {
            if (t.count % 2 == 0) {
                b2.setText("X");
                t.d = 1;
            } else {
                b2.setText("O");
                t.d = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
    //int d1=0;

    public void three(View v)
    {
        t.count++;

        Button b3=(Button)findViewById(R.id.button4);

        if(t.d1==0)
        {
            if (t.count % 2 == 0) {
                b3.setText("X");
                t.d1 = 1;
            } else {
                b3.setText("O");
                t.d1 = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
    //int don=0;
    public void four(View v)
    {

        t.count++;
        Button b4=(Button)findViewById(R.id.button5);
        if(t.don==0)
        {
            if (t.count % 2 == 0) {
                b4.setText("X");
                t.don = 1;
            } else {
                b4.setText("O");
                t.don = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
    //int dd=0;
    public void five(View v)
    {
        t.count++;
        Button b5=(Button)findViewById(R.id.button6);

        if(t.dd==0)
        {
            if (t.count % 2 == 0) {
                b5.setText("X");
                t.dd = 1;
            } else {
                b5.setText("O");
                t.dd = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
   // int dn=0;
    public void six(View v)
    {

        t.count++;
        Button b6=(Button)findViewById(R.id.button7);

        if(t.dn==0)
        {
            if (t.count % 2 == 0) {
                b6.setText("X");
                t.dn = 1;
            } else {
                b6.setText("O");
                t.dn = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
    //int d2=0;
    public void seven(View v)
    {
        t.count++;
        Button b7=(Button)findViewById(R.id.button8);
        if(t.d2==0)
        {
            if (t.count % 2 == 0) {
                b7.setText("X");
                t.d2= 1;
            } else {
                b7.setText("O");
                t.d2 = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
   // int d3=0;
    public void eight(View v)
    {

        t.count++;
        Button b8=(Button)findViewById(R.id.button9);

        if(t.d3==0)
        {
            if (t.count % 2 == 0) {
                b8.setText("X");
                t.d3 = 1;
            } else {
                b8.setText("O");
                t.d3 = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }
    //int d4=0;
    public void nine(View v)
    {
        t.count++;
        Button b9=(Button)findViewById(R.id.b10);

        if(t.d4==0)
        {
            if (t.count % 2 == 0) {
                b9.setText("X");
                t.d4 = 1;
            } else {
                b9.setText("O");
                t.d4 = 1;
            }
        }
        else
        {
            Toast.makeText(this, "Already marked", Toast.LENGTH_SHORT).show();
        }
    }

    public class tictactoeThread implements Runnable{


        @Override
        public void run() {
            int port ;
            Socket s = null;
            //Objects created for data transfer
            ObjectOutputStream cObOut =null;
            ObjectInputStream cObIn = null;
            DataOutputStream cOut = null;
            DataInputStream cIn =null;

            try {
                port = 12345;
                //Client socket created.

                s = new Socket("192.168.0.5", port);
                //giving IP address of server and the port for communication

                //Objects created for data transfer
                cObOut = new ObjectOutputStream(s.getOutputStream());
                //this doesn't make sense.
                cObIn = new ObjectInputStream(s.getInputStream());
                //for sending object data
                cOut = new DataOutputStream(s.getOutputStream());
                //for sending data
                cIn = new DataInputStream(s.getInputStream());
                //for reading data

                tictactoe2 tOld=t;
                cObOut.writeObject(t);
                t=(tictactoe2)cObIn.readObject();
                compare(tOld);
            }
            catch(Exception e) {
                e.getMessage();
            }
        }

    }

    public void compare(tictactoe2 tOld) {

        if(t.dd!=tOld.dd) {

            Button b5=(Button)findViewById(R.id.button6);

            if (t.count % 2 == 0) {
                b5.setText("X");
                t.dd = 1;
            } else {
                b5.setText("O");
                t.dd = 1;
            }

        }
    }
}
