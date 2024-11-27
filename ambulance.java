package com.example.myapplication.RedHelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ambulance extends AppCompatActivity {
    Button police,ambulance,women,fire,disaster,cyber;
    FloatingActionButton emergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);
                 police = findViewById(R.id.button);
                ambulance = findViewById(R.id.button1);
                 women = findViewById(R.id.button2);
                 fire = findViewById(R.id.button3);
                 disaster = findViewById(R.id.button4);
                cyber = findViewById(R.id.button5);
                emergency= findViewById(R.id.floatingActionButton2);

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:112"));
                startActivity(intent);
                overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
            }
        });

                police.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:100"));
                        startActivity(intent);
                        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
                    }
                });


                ambulance.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:102"));
                        startActivity(intent);
                        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
                    }
                });

                women.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:1091"));
                        startActivity(intent);
                        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
                    }
                });

                fire.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:101"));
                        startActivity(intent);
                        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
                    }
                });

                disaster.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:108"));
                        startActivity(intent);
                        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
                    }
                });

                cyber.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:155620"));
                        startActivity(intent);
                        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
                    }
                });
            }
        }


