package com.example.shivanii.gamesataclick;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class userSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selection);
    }

    public void VsComp(View v)
    {
        Intent intent=new Intent(this,tictactoe.class);
        //i m passign 1 if vs comp is selected and in the logic of ttt,
        //same parameter of 'choice' will be checked as to carrying
        //out either of logic
        intent.putExtra("choice",1);
        startActivity(intent);
    }
    public void VsUser(View v)
    {
        Intent intent=new Intent(this,tictactoe.class);
        intent.putExtra("choice",2);
        startActivity(intent);
    }
}
