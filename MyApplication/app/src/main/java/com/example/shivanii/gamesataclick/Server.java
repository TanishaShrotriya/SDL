package com.example.shivanii.gamesataclick;

import java.net.*;
import java.io.*;

import android.app.Activity;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static com.example.shivanii.gamesataclick.R.*;

/**
 * Created by tanishashrotriya on 24/9/17.
 */

public class Server {



    public static void main(String args[]) throws Exception {
        int port = 12345;
        //Server for socket created.
        System.out.println("Waiting");

        ServerSocket s = new ServerSocket(port);
        Socket S = s.accept();

        //Objects created for data transfer
        ObjectOutputStream sObOut = new ObjectOutputStream(S.getOutputStream());
        //for sending object data
        ObjectInputStream sObIn = new ObjectInputStream(S.getInputStream());
        //for reading object
        DataInputStream sIn = new DataInputStream(S.getInputStream());
        //for reading data
        DataOutputStream sOut = new DataOutputStream(S.getOutputStream());
        //for reading data

//        Activity a=new AppCompatActivity();
        tictactoe2 t = (tictactoe2)(sObIn.readObject());
        int[] values=t.get();
        if (values[4] ==0) {
            values[4]=1;
            t.set(values);
            t.count++;
         //   Button b5=(Button)a.findViewById(id.button6);
         //   b5.setText("1");
        }
        sObOut.writeObject(t);
        System.out.println(sIn.readUTF());
        s.close();

    }


}


