package com.example.shivanii.gamesataclick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class tictactoe extends AppCompatActivity {

    Button[] butt = new Button[9];
    int[] marked = new int[9];
    public static int count = 1;
    String tag = "tictactoe";
    public static int turn =0,n=0;//1 is for client
  public static   int pturn = 0;
    final int[] flag = new int[9];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

        butt[0] = (Button) findViewById(R.id.button);
        butt[1] = (Button) findViewById(R.id.button2);
        butt[2] = (Button) findViewById(R.id.button4);
        butt[3] = (Button) findViewById(R.id.button7);
        butt[4] = (Button) findViewById(R.id.button6);
        butt[5] = (Button) findViewById(R.id.button5);
        butt[6] = (Button) findViewById(R.id.button8);
        butt[7] = (Button) findViewById(R.id.button9);
        butt[8] = (Button) findViewById(R.id.b10);

    }




    public boolean gameOver() {


        if ((flag[0] == 2 && flag[1]== 2 && flag[2] == 2) ||
                (flag[3] == 2 && flag[4] == 2 && flag[5] == 2) ||
                (flag[6] == 2 && flag[7] == 2 && flag[8] == 2) ||
                (flag[0] == 2 && flag[3] == 2 && flag[6] == 2) ||
                (flag[1] == 2 && flag[4] == 2 && flag[7] == 2) ||
                (flag[2] == 2 && flag[5] == 2 && flag[8] == 2) ||
                (flag[0] == 2 && flag[4] == 2 && flag[8] == 2) ||
                (flag[2] == 2 && flag[4] == 2 && flag[6] == 2)

                ) {
            Toast.makeText(this, "congrats you won", Toast.LENGTH_SHORT).show();
            return true;

        }

        if ((flag[0] == 1 && flag[1]== 1 && flag[2] == 1) ||
                (flag[3] == 1 && flag[4] == 1 && flag[5] == 1) ||
                (flag[6] == 1 && flag[7] == 1 && flag[8] == 1) ||
                (flag[0] == 1 && flag[3] == 1 && flag[6] == 1) ||
                (flag[1] == 1 && flag[4] == 1 && flag[7] == 1) ||
                (flag[2] == 1 && flag[5] == 1 && flag[8] == 1) ||
                (flag[0] == 1 && flag[4] == 1 && flag[8] == 1) ||
                (flag[2] == 1 && flag[4] == 1 && flag[6] == 1)

                ) {
            Toast.makeText(this, "server won", Toast.LENGTH_SHORT).show();
            return true;


        } else if (flag[0] == 0 || flag[1] == 0 || flag[2] == 0 ||
                flag[3] == 0 || flag[4] == 0 || flag[5] == 0 ||
                flag[6] == 0 || flag[7] == 0 || flag[8] == 0) {
            return false;

        } else {
            Toast.makeText(this, "Game TIED", Toast.LENGTH_SHORT).show();
            return true;
        }


    }

    public void start(View V) {

        butt[4].setText("X");
        butt[4].setEnabled(false);

        for (int i = 0; i < 9; i++) {

            flag[i] = 0;
            Log.d(tag, "flags*********" + flag[i]);

        }
        flag[4]=1;

        turn = 1;
        Toast.makeText(getApplicationContext(), "you need to click a button",
                Toast.LENGTH_SHORT).show();

    }

    public void display(int n) {

            final Button b = butt[n];

            b.setText("O");
            b.setEnabled(false);
            flag[n] = 2;//done by client
            turn = 2;//2 is for server

            Log.d(tag, " " + turn);


            if (turn == 2) {
                compMove();


            }

        Toast.makeText(this, "your turn", Toast.LENGTH_SHORT).show();

        }



    public void one(View view)
    {
        display(0);
    }

    public void two(View view)
    {
        display(1);
    }
    public void three(View view)
    {
        display(2);
    }
    public void four(View view)
    {
        display(3);
    }
    public void five(View view)
    {
        display(4);
    }
    public void six(View view)
    {
        display(5);
    }
    public void seven(View view)
    {
        display(6);
    }
    public void eight(View view)
    {
        display(7);
    }
    public void nine(View view)
    {
        display(8);
    }


    public void compMove() {
        Log.d(tag, "***********inside compMove:");
        pturn = 0; //and nothing is done;no one has won yet
        if (pturn == 0) {
            doublefun(0);//row,column and diagonal
Log.d(tag,"double1 worked");
        }

       if (pturn == 0) {
            doublefun(3);//rpw
           Log.d(tag,"double2 worked");
       }

        if (pturn == 0) {
            doublefun(6);//row
        }

        if (pturn == 0) {
            doublefun(1);//column
        }

        if (pturn == 0) {
            doublefun(2);//column
        }

        if (pturn == 0) {
            corner();
        }

        if (pturn == 0) {
            anyempty();
        }

        if(pturn==2)
        {gameOver();}
    }

    public void doublefun(int n) {

        //if pturn=2 then server wins
        if (n % 3 == 0)//for rows-0,3,6
        {
//X is for server so flag[] for server is 1
            if ((flag[n] == 1 && flag[n + 1] == 1 && flag[n + 2] == 0) || (flag[n + 1] == 1 && flag[n + 2] == 1 && flag[n] == 0) || (flag[n] == 1 && flag[n + 2] == 1 && flag[n + 1] == 0)) {

                if (flag[n] == 0) {
                    butt[n].setText("X");
                    butt[n].setEnabled(false);
                    flag[n] = 1;
                    pturn = 2;
                }
                if (flag[n + 1] == 0) {
                    butt[n + 1].setText("X");
                    butt[n+1].setEnabled(false);
                    flag[n + 1] = 1;
                    pturn = 2;
                }
                if (flag[n + 2] == 0) {
                    butt[n + 2].setText("X");
                    butt[n+2].setEnabled(false);
                    flag[n + 2] = 1;
                    pturn = 2;
                }

            }


        }

        if (n % 3 != 0 || n == 0)//for 0th column,1st and 2nd column
        {
            if ((flag[n] == 1 && flag[n + 3] == 1 && flag[n + 6] == 0) || (flag[n + 3] == 1 && flag[n + 6] == 1 && flag[n] == 0) || (flag[n] == 1 && flag[n + 6] == 1 && flag[n + 3] == 0)) {

                if (flag[n] == 0) {
                    butt[n].setText("X");
                    butt[n].setEnabled(false);
                    flag[n] = 1;
                    pturn = 2;
                }
                if (flag[n + 3] == 0) {
                    butt[n + 3].setText("X");
                    butt[n+3].setEnabled(false);
                    flag[n + 3] = 1;
                    pturn = 2;
                }
                if (flag[n + 6] == 0) {
                    butt[n + 6].setText("X");
                    butt[n+6].setEnabled(false);
                    flag[n + 6] = 1;
                    pturn = 2;
                }

            }


        } else {
            for (int i = 0; i < 9; i++) {
                if (i % 2 == 0) {
                    if (i % 4 == 0) {
                        if (i == 0)//for diagonal from 0,4,8 {
                            if ((flag[0] == 1 && flag[ 4] == 1 && flag[8] == 0) || (flag[4] == 1 && flag[8] == 1 && flag[0] == 0) || (flag[0] == 1 && flag[8] == 1 && flag[4] == 0)) {

                                if (flag[0] == 0) {
                                    butt[0].setText("X");

                                    butt[0].setEnabled(false);        flag[0] = 1;
                                    pturn = 2;
                                }
                                if (flag[4] == 0) {
                                    butt[4].setText("X");
                                    butt[4].setEnabled(false);
                                    flag[4] = 1;
                                    pturn = 2;

                                }
                                if (flag[8] == 0) {
                                    butt[8].setText("X");
                                    butt[8].setEnabled(false);
                                    flag[8] = 1;
                                    pturn = 2;
                                }

                            }
                    } else//for second diagonal i.e 2,4,6
                    {
                        if ((flag[2] == 1 && flag[4] == 1 && flag[6] == 0) || (flag[6] == 1 && flag[4] == 1 && flag[2] == 0) || (flag[2] == 1 && flag[6] == 1 && flag[4] == 0)) {

                            if (flag[i] == 0) {
                                butt[i].setText("X");
                                flag[i] = 1;
                                butt[i].setEnabled(false);
                                pturn = 2;
                            }
                            if (flag[i + 2] == 0) {
                                butt[i + 2].setText("X");

                                butt[i+2].setEnabled(false);flag[i + 2] = 1;
                                pturn = 2;

                            }
                            if (flag[i + 4] == 0) {
                                butt[i + 4].setText("X");

                                butt[i+4].setEnabled(false);flag[i + 4] = 1;
                                pturn = 2;
                            }

                        }


                    }//else end
                }//end for mod 2 if


            }//end of for loop
        }


    }//end of double function


    public void corner() {
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0 && i != 4) {

                if (flag[0] == 0 && i == 0) {
                    butt[0].setText("X");
                    butt[0].setEnabled(false);
                    flag[0] = 1;
                    pturn = 1;
                    break;
                    //start();
                } else if (flag[2] == 0 && i == 2) {
                    butt[2].setText("X");
                    butt[2].setEnabled(false);
                    flag[2] = 1;
                    pturn = 1;
                    break;
                    //start();
                } else if (flag[6] == 0 && i == 6) {
                    butt[6].setText("X");
                    butt[6].setEnabled(false);
                    flag[6] = 1;
                    pturn = 1;
                    break;
                    //start();
                } else if (flag[8] == 0 && i == 8) {
                    butt[8].setText("X");
                    butt[8].setEnabled(false);
                    flag[8] = 1;
                    pturn = 1;//completed corner function
                    break;
                    //start();
                }


            }


        }


    }//end of corner function

    public void anyempty() {


        for (int j = 0; j < 9; j++) {

            int done = 0;
            if (flag[j] == 0) {

                butt[j].setText("X");
                butt[j].setEnabled(false);
                flag[j] = 1;
                done = 1;
                break;
            }

        }


    }


}
