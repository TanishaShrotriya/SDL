package com.example.shivanii.gamesataclick;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
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

   public void one(View view)
    {
        Button b1 = (Button)findViewById(R.id.button);

        t.count++;

        b1.setClickable(false);
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
        Toast.makeText(this, "Thread started", Toast.LENGTH_SHORT).show();
        Intent i =new Intent(this,message.class);
        startActivity(i);
    }

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

        Intent i =new Intent(this,message.class);
        startActivity(i);
    }

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

               //s = new Socket("192.168.0.5", port);
                s = new Socket("192.168.43.53", port);


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
                cOut.writeUTF("move updated");
                s.close();
            }
            catch(Exception e) {
                e.getMessage();
            }

        }

    }



    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Button b1 = (Button)findViewById(R.id.button);
        Button b2=(Button)findViewById(R.id.button2);
        Button b3=(Button)findViewById(R.id.button4);
        Button b4=(Button)findViewById(R.id.button5);
        Button b5=(Button)findViewById(R.id.button6);
        Button b6=(Button)findViewById(R.id.button7);
        Button b7=(Button)findViewById(R.id.button8);
        Button b8=(Button)findViewById(R.id.button9);
        Button b9=(Button)findViewById(R.id.b10);
        if(t.done==1)
        {
            if (t.count % 2 == 0) {
                b1.setText("X");
                t.done = 2;
            } else {
                b1.setText("O");
                t.done = 2;
            }


        }
        if(t.d==1)
        {
            if (t.count % 2 == 0) {
                b2.setText("X");
                t.d = 2;
            } else {
                b2.setText("O");
                t.d = 2;
            }
        }
        if(t.don==1)
        {
            if (t.count % 2 == 0) {
                b4.setText("X");
                t.don = 2;
            } else {
                b4.setText("O");
                t.don = 2;
            }
        }
        if(t.dd==1)
        {
            if (t.count % 2 == 0) {
                b5.setText("X");
                t.dd = 2;
            } else {
                b5.setText("O");
                t.dd = 2;
            }
        }
        if(t.dn==1)
        {
            if (t.count % 2 == 0) {
                b6.setText("X");
                t.dn = 2;
            } else {
                b6.setText("O");
                t.dn = 2;
            }
        }
        if(t.d2==1)
        {
            if (t.count % 2 == 0) {
                b7.setText("X");
                t.d2= 2;
            } else {
                b7.setText("O");
                t.d2 =2;
            }
        }

        if(t.d3==1)
        {
            if (t.count % 2 == 0) {
                b8.setText("X");
                t.d3 = 2;
            } else {
                b8.setText("O");
                t.d3 = 2;
            }
        }
        if(t.d4==1)
        {
            if (t.count % 2 == 0) {
                b9.setText("X");
                t.d4 = 2;
            } else {
                b9.setText("O");
                t.d4 = 2;
            }
        }
    }
}
