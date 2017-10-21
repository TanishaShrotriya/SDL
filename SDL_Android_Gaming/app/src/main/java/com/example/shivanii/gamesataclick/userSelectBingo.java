package com.example.shivanii.gamesataclick;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class userSelectBingo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select_bingo);
    }
    public void comp(View v)
    {
        Intent intent;
        intent = new Intent(this,bingo.class);

        startActivity(intent);
    }
    public void user(View v)
    {
        Intent intent=new Intent(this,bingo.class);
      //  intent.putExtra("choice",2);
        startActivity(intent);
    }
}
