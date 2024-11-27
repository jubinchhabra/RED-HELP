package com.example.myapplication.RedHelp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ContentInfoCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    ViewFlipper flipper1;
    EditText user_id,user_password;
    Button login,sign;
    ProgressBar p1;
    int pt=0;



    SharedPreferences sharedpreferences;
    int autoSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedpreferences = getSharedPreferences("autoLogin", Context.MODE_PRIVATE);
        int j = sharedpreferences.getInt("key", 0);

        if(j > 0){
            Intent activity = new Intent(getApplicationContext(), Home_activity.class);
            startActivity(activity);
        }
        flipper1=findViewById(R.id.flipper);
        user_id=findViewById(R.id.userid);
        user_password=findViewById(R.id.password);
        login=findViewById(R.id.btnlogin);
        p1=findViewById(R.id.progressBar);

        sign=findViewById(R.id.btnlogin3);
        user_id.addTextChangedListener(textWatcher);
        user_password.addTextChangedListener(textWatcher);




        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj=new Intent(getApplicationContext(),signup.class);
                startActivity(obj);
                finish();
                overridePendingTransition(R.anim.slideinleft,R.anim.slideoutright);


            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(pt);
                validate();

                if(TextUtils.isEmpty(user_id.getText().toString())){
                    user_id.setError("email is Compulsory");
                }
                else if(TextUtils.isEmpty(user_password.getText().toString())){
                    user_password.setError("Password is Compulsory");
                }
                else {
                    //Once you click login, it will add 1 to shredPreference which will allow autologin in onCreate

                    data();

                }

                user_id.setText("");
                user_password.setText("");

            }});

        int imagelist[]={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};

        for(int i=0;i<imagelist.length;i++)
            pic(imagelist[i]);
    }
    private void update(int pt){
        p1.setProgress(pt);

        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                  Thread.sleep(1000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                update(pt+20);
            }
        });
        t.start();
    }
    public void data(){
        String url="https://dssbloodneed.000webhostapp.com/blood/loginpage.php";
        String uservalue = user_id.getText().toString();
        String uservalue2 = user_password.getText().toString();
        StringRequest request= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
             //   Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_SHORT).show();
                if(response.toString().equals("login")) {



                   Intent obj = new Intent(MainActivity.this, Home_activity.class);

                    obj.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(obj);
                    finish();

                    overridePendingTransition(R.anim.slideinleft,R.anim.slideoutright);

                    autoSave = 1;
                   SharedPreferences.Editor editor = sharedpreferences.edit();
                   editor.putInt("key", autoSave);
                    editor.apply();


                }
                else{
                    Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param=new HashMap<String,String>();
                param.put("user_email",uservalue);
                param.put("user_password",uservalue2);
                return param;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
        queue.add(request);
    }

    public  void pic(int i)
    {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(i);
        flipper1.addView(imageView);
        flipper1.setAutoStart(true);
        flipper1.setFlipInterval(1000);
        flipper1.setInAnimation(this, android.R.anim.slide_in_left);
        flipper1.setOutAnimation(this, android.R.anim.slide_out_right);




    }
    private TextWatcher textWatcher= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String text1= user_id.getText().toString().trim();
            String text2=user_password.getText().toString().trim();
            login.setEnabled(!text1.isEmpty() && !text2.isEmpty() && text2.length()>=8);

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private boolean validate() {

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (user_id.length() > 25) {

            Toast.makeText(getApplicationContext(), "pls enter less the 25 character in user name", Toast.LENGTH_SHORT).show();
            return true;

        }  else if (user_id.getText().toString().matches(emailPattern)) {

            //Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
            return true;

        } else if(!user_id.getText().toString().matches(emailPattern)) {

            Toast.makeText(getApplicationContext(),"Please Enter Valid Email Address",Toast.LENGTH_SHORT).show();
            return false;

        }

        return false;
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        finish();}


}