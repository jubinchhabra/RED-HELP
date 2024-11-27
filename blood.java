package com.example.myapplication.RedHelp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class blood extends AppCompatActivity {
ViewFlipper f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood);
        f1=findViewById(R.id.flipper);
        int imagelist[]={R.drawable.pic3,R.drawable.pic4};

        for(int i=0;i<imagelist.length;i++)
            pic(imagelist[i]);
    }
    public  void pic(int i)
    {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(i);
        f1.addView(imageView);
        f1.setAutoStart(true);
        f1.setFlipInterval(1000);
        f1.setInAnimation(this, android.R.anim.slide_in_left);
        f1.setOutAnimation(this, android.R.anim.slide_out_right);




    }
}