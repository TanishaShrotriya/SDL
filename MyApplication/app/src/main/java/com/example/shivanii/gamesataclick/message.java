package com.example.shivanii.gamesataclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import java.util.logging.Handler;

import static android.net.sip.SipErrorCode.TIME_OUT;

public class message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

    }


    public void goBack(View view) {
        Intent i = new Intent(this,tictactoe.class);
        startActivity(i);
    }
}
