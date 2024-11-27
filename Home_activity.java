package com.example.myapplication.RedHelp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class Home_activity extends AppCompatActivity {

SharedPreferences sharedPreferences;
int autoSave;
    com.google.android.material.bottomnavigation.BottomNavigationView b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sharedPreferences = getSharedPreferences("autoLogin", Context.MODE_PRIVATE);
        int j = sharedPreferences.getInt("key", 0);

        if(j < 0){
            Intent activity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(activity);
            overridePendingTransition(R.anim.slideinleft,R.anim.slideoutright);
        }

        replaceFragment(new homeFragment());
        b1 = findViewById(R.id.bottomNavigationView);


        b1.setOnItemSelectedListener(item -> {
//
            int id = item.getItemId();
            if (id == R.id.home1) {
                replaceFragment(new homeFragment());

            } else if (id == R.id.requirement) {
                replaceFragment(new reqiFragment());
            } else if (id == R.id.person) {
                replaceFragment(new personFragment());
            } else {

            }


            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slideinright, R.anim.slideoutleft);
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private Boolean exit = false;

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        finishAndRemoveTask();
    }
}
