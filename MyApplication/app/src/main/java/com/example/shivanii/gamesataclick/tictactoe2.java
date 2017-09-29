package com.example.shivanii.gamesataclick;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;

import java.io.Serializable;

/**
 * Created by tanishashrotriya on 24/9/17.
 */

public class tictactoe2 implements Parcelable, Serializable {

    /*
    Parcelable is used to enable movement of the object of this class between activities.
    Serializable is used t enable movement of object over a network.
     */


        public static int count=0;
        int done,d,d1,don,dd,d2,dn,d3,d4;
        //Button b1;
       // Button b5;
    //BUTTON NOT SERIALIZABLE
        @Override

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {

            dest.writeInt(done);
            dest.writeInt(d);
            dest.writeInt(d1);
            dest.writeInt(don);
            dest.writeInt(dd);
            dest.writeInt(d2);
            dest.writeInt(dn);
            dest.writeInt(d3);
            dest.writeInt(d4);

        }


        public tictactoe2(int done,int d,int d1,int don,int dd,int d2,int dn,int d3,int d4) {
            this.done=done;
            this.d=d;
            this.d1=d1;
            this.don=don;
            this.dd=dd;
            this.d2=d2;
            this.dn=dn;
            this.d3=d3;
            this.d4=d4;
        }

        /**
         * Retrieving tictactoe data from Parcel object
         * This constructor is invoked by the method createFromParcel(Parcel source) of
         * the object CREATOR
         **/
        private tictactoe2(Parcel in){

            done=in.readInt();
            d=in.readInt();
            d1=in.readInt();
            don=in.readInt();
            dd=in.readInt();
            d2=in.readInt();
            dn=in.readInt();
            d3=in.readInt();
            d4=in.readInt();

        }

        public static final Parcelable.Creator<com.example.shivanii.gamesataclick.tictactoe2> CREATOR = new Parcelable.Creator<com.example.shivanii.gamesataclick.tictactoe2>() {
            @Override
            public com.example.shivanii.gamesataclick.tictactoe2 createFromParcel(Parcel source) {
                return new com.example.shivanii.gamesataclick.tictactoe2(source);
            }

            @Override
            public com.example.shivanii.gamesataclick.tictactoe2[] newArray(int size) {
                return new com.example.shivanii.gamesataclick.tictactoe2[size];
            }
        };

        public int[] get() {

            int[] a = new int[9];
            a[0]=done;
            a[1]=d;
            a[2]=d1;
            a[3]=don;
            a[4]=dd;
            a[5]=d2;
            a[6]=dn;
            a[7]=d3;
            a[8]=d4;
            return a;
        }

        public void set(int[] a) {

            done=a[0];
            d=a[1];
            d1=a[2];
            don=a[3];
            dd=a[4];
            d2=a[5];
            dn=a[6];
            d3=a[7];
            d4=a[8];

        }
    }

