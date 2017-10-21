package com.example.shivanii.gamesataclick;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;


public class bingo extends AppCompatActivity {
    //private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25;
    Button[] butt = new Button[25];
    int[] flag1 = new int[25];
    int[] flagcr = new int[25];
    int[] flagcc = new int[25];
    int[] flagd1 = new int[25];
    int[] flagd2 = new int[25];
    int[][] flagsr = new int[5][5];
    int[][] flagsc = new int[5][5];
    int[][] flagsd1 = new int[5][5];
    int[][] flagsd2 = new int[5][5];
    int flg[][] = new int[5][5];
    Integer[] ran = new Integer[25];
    int[][] ser = new int[10][10];
    String tag = "bingo";
    int done=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bingo);
        butt[0] = (Button) findViewById(R.id.button);
        butt[1] = (Button) findViewById(R.id.button2);
        butt[2] = (Button) findViewById(R.id.button3);
        butt[3] = (Button) findViewById(R.id.button4);
        butt[4] = (Button) findViewById(R.id.button8);
        butt[5] = (Button) findViewById(R.id.button5);
        butt[6] = (Button) findViewById(R.id.button9);
        butt[7] = (Button) findViewById(R.id.button10);
        butt[8] = (Button) findViewById(R.id.button12);
        butt[9] = (Button) findViewById(R.id.button11);
        butt[10] = (Button) findViewById(R.id.button7);
        butt[11] = (Button) findViewById(R.id.button6);
        butt[12] = (Button) findViewById(R.id.button14);
        butt[13] = (Button) findViewById(R.id.button15);
        butt[14] = (Button) findViewById(R.id.button17);
        butt[15] = (Button) findViewById(R.id.button18);
        butt[16] = (Button) findViewById(R.id.button13);
        butt[17] = (Button) findViewById(R.id.button20);
        butt[18] = (Button) findViewById(R.id.button21);
        butt[19] = (Button) findViewById(R.id.button22);
        butt[20] = (Button) findViewById(R.id.button23);
        butt[21] = (Button) findViewById(R.id.button24);
        butt[22] = (Button) findViewById(R.id.button25);
        butt[23] = (Button) findViewById(R.id.button26);
        butt[24] = (Button) findViewById(R.id.button19);

    }

    public static int count = 0;
    public static int cou = 0;
    public static int cnt = 0;


    public void show(View view) {

        String tag = "bingo";
        Log.d(tag, "inside show()-----------------------------------------------------------------------");

        //flag for the buttons so that logic can be made


        //client bingo grid
        for (int i = 0; i < butt.length; i++) {
            final Button b = butt[i];
            //  int f = flag[i];
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cnt++;
                    if (cnt < 26) {
                        b.setText("" + cnt);

                    }
                }
            });
        }


    }

    public void serverGrid(View view) {

        //server bingo grid
        String TAG = "bingo";
        int z=1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                ser[i][j] = z;
                z++;
                // Log.d(TAG, "\nserver grid:" + ser[i][j]);
            }
        }

        for (int i = 0; i < 25; i++) {
            ran[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(ran));
        for (int m = 0; m < 25; m++) {

            Log.d(tag, "*******Random no.s" + ran[m]);

        }

        for (int i = 0; i < 25; i++) {
            flag1[i] = 0;
            //  Log.d(tag, "flag[]------------------\n" + flag1[i]);
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                flg[i][j] = 0;
                //  Log.d(TAG, "\flg[] --------------//-----------------:" + flg[i][j]);
            }
        }


        Toast.makeText(getApplicationContext(), "ENTER YOUR NUMBER IN THE BOX",
                Toast.LENGTH_SHORT).show();
    }

    //this method starts when the submit button is clicked .. here it is start button. everytime the client gives a number and then presses start then the striking happens

    public void accept1(View view) {            //accepting a number from user
        EditText text = (EditText) findViewById(R.id.acc_no);
        String str = text.getText().toString();


        for (int i = 0; i < 25; i++) {
            Log.d(tag, "in accept for-------------------");

            final Button c = butt[i];    //get a button at i position in b
            Log.d(tag, "///////////////////c button->text ");

            if (c.getText().toString().equals(str) && flag1[i] == 0) //uss button .getText
            {
                Log.d(tag, "in accept if-------------------");
                c.setText(" ");
                flag1[i] = 1;
            }
            Log.d(tag, "in accept end-------------------");
        }
        int num = Integer.parseInt(text.getText().toString());
        System.out.print("Now printing flg[] after inserting a no.\n");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (ser[i][j] == num) {
                    // Log.d(tag,"************ser:"+ser[i][j]);
                    flg[i][j] = 1;
                }
                Log.d(tag, flg[i][j] + "\t");

            }
            Log.d(tag, "\n");
        }

        // Log.d(tag,"flag of no. turned 1");

        client_row(0);
        client_row(5);
        client_row(10);
        client_row(15);
        client_row(20);
        client_column(0);
        client_column(1);
        client_column(2);
        client_column(3);
        client_column(4);
        client_diagonal1(0);
        client_diagonal2(4);
              /*server_row(0);
                server_row(1);
                server_row(2);
                server_row(3);
                server_row(4);
                server_column(1);
                server_column(2);
                server_column(3);
                server_column(4);
                server_column(5);
                //server_diagonal1(1);
                //server_diagonal2(1);*/

        server_number();

    }

    public void server_number() {
        done=0;
        for (int j = 25; j >0; j--)//for no.s 1 to 25
        {

            {
                for (int k = 0; k < 25; k++) // for buttons
                {
                    if (butt[k].getText().toString().equals("" + j)) {
                      //  Log.d(tag, "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

                        Toast.makeText(getApplicationContext(), "Comp passed number:" + j,
                                Toast.LENGTH_SHORT).show();
                        butt[k].setText(" ");
                        setflagofServ(j);
                        done=1;
                    }
                    if(done==1)
                    {
                        break;
                    }
                }
            }

        }
    Toast.makeText(getApplicationContext(), "Your turn:",Toast.LENGTH_SHORT).show();
}

public  void setflagofServ(int j)
{
    for (int i = 0; i < 5; i++)
    {
       // Log.d(tag,"************in first for loop");
        for (int m = 0; m < 5; m++)
        {
            /*Log.d(tag,"ser[]: "+ser[i][m]+"\t");
            Log.d(tag,"flg[]: "+flg[i][m]+"\t");*/
            if (ser[i][m] == j) {
               // Log.d(tag,"ser at j:"+j);
                flg[i][m] = 1;
            }
            Log.d(tag, "FLag of "+flg[i][m] + " is set!******************* ");


        }
        Log.d(tag,"\n");

    }
}

    public void client_row(int number) {
        for (int a = number; a <= number + 4; a++) {

            if (flag1[a] == 1 && flagcr[a] == 0) {
                count++;
                flagcr[number] = 1;
            }
            Log.d(tag, "///////////////////count:" + count);
            counting(count);
        }
    }
    public void client_column(int number) {
        for (int a = number; a <= number + 20; a = a + 5) {
            if (flag1[a] == 1 && flagcc[a] == 0) {
                count++;
                flagcc[number] = 1;
            }
            Log.d(tag, "///////////////////count:" + count);
            counting(count);
            int c = 0;
      /*      if(c%5==0)
            {
                Toast.makeText(getApplicationContext(), "client_column()",
                        Toast.LENGTH_SHORT).show();

            }*/
        }

    }

    public void client_diagonal1(int number) {
        for (int a = number; a <= number + 24; a++) {
            if (flag1[a] == 1 && flagd1[a] == 0) {
                flagd1[a] = 1;
                count++;
            }
            Log.d(tag, "///////////////////count:" + count);

            counting(count);

        }

    }

    public void client_diagonal2(int number) {
        for (int a = number; a <= number + 16; a++) {

            if (flag1[a] == 1 && flagd2[a] == 0) {
                flagd2[a] = 1;
                count++;
            }
            Log.d(tag, "///////////////////count:" + count);

            counting(count);

        }

    }

    public void counting(int t) {
        if (t >84 ||t>100 ) {
            Log.d(tag, "///////////////////count in counting():" + t);
            Toast.makeText(getApplicationContext(), "YOU WON",
                    Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }   //will check winning condition for client
    public void coun(int p) {
        if (p == 25) {
            Toast.makeText(getApplicationContext(), "SERVER WON",
                    Toast.LENGTH_SHORT).show();

        }

    } ////will check winning condition for client

    public void server_row(int r) {
        int i = 0;
        while (i < 5) {
            if (flg[r][i] == 1 && flagsr[r][i] == 0) {
                cou++;
                Log.d(tag, "***********count after");
                flagsr[r][i] = 1;
            }
            coun(cou);
            i++;
        }

        Toast.makeText(getApplicationContext(), "SERVER ROW END",
                Toast.LENGTH_SHORT).show();

    }

    public void server_column(int r) {
        int i = 1;
        while (i < 6) {

            if (flg[i][r] == 1 && flagsc[i][r] == 0)
            {
                cou++;
                flagsc[i][r] = 1;
            }
            Log.d(tag, "***********count at server:" + cou);

            coun(cou);

            i++;
        }

    }



    public void server_diagonal1(int r) {
        int i = 1;
        while (i < 6) {

            if (flg[i][i] == 1 && flagsd1[i][i] == 0) {
                cou++;
                flagsd1[i][i] = 1;
            }
            Log.d(tag, "***********count at server:" + cou);
            coun(cou);
            i++;
        }

    }

    public void server_diagonal2(int r) {
        int i = r, j = 4;
        while (i < 5) {

            if (flg[i][j] == 1 && flagsd2[i][j] == 0) {
                cou++;
                flagsd2[i][j] = 1;
            }
            Log.d(tag, "***********count at server:" + cou);
            coun(cou);
            i++;
            j--;
        }

    }


}