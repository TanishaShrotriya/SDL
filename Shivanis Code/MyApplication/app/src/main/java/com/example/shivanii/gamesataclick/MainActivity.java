package com.example.shivanii.gamesataclick;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ttt(View v)
    {
        Intent intent=new Intent(this,tictactoe.class);
        startActivity(intent);

    }

    public void bingo(View v)
    {
        Intent intent=new Intent(this,bingo.class);
        startActivity(intent);

    }
}
