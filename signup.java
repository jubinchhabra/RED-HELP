package com.example.myapplication.RedHelp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {
EditText t1,t2,t3,t4,t5;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        t1=findViewById(R.id.editTextText4);
        t2=findViewById(R.id.editTextText5);
        t3=findViewById(R.id.editTextText6);
        t4=findViewById(R.id.editTextText7);
        t5=findViewById(R.id.editTextText9);
        b1=findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(t1.getText().toString())){
                    t1.setError("Compulsory");
                }
               else if(TextUtils.isEmpty(t2.getText().toString())){
                    t2.setError("Compulsory");
                }
                else if(TextUtils.isEmpty(t3.getText().toString())){
                    t3.setError("Compulsory");
                }
                else if(TextUtils.isEmpty(t4.getText().toString())){
                    t4.setError("Compulsory");
                }
                else if(TextUtils.isEmpty(t5.getText().toString())){
                    t5.setError("Compulsory");
                }
                else if(validate1()&&validate()){
                    sign();
                    Intent obj= new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(obj);
                }

            }
        });


    }
    public void sign(){

        String url="https://dssbloodneed.000webhostapp.com/blood/signup.php";
        String name=t1.getText().toString();
        String email=t2.getText().toString();
        String password=t3.getText().toString();
        String group=t4.getText().toString();
        String mobile=t5.getText().toString();
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(signup.this, "submit", Toast.LENGTH_SHORT).show();
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
                param.put("user_id",name);
                param.put("user_password",password);
                param.put("user_email",email);
                param.put("user_group",group);
                param.put("user_mobile",mobile);
                return param;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(signup.this);
        queue.add(request);


    }
    private boolean validate1() {

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (t2.length() > 25) {

            Toast.makeText(getApplicationContext(), "pls enter less the 25 character in user name", Toast.LENGTH_SHORT).show();
            return true;

        }  else if (t2.getText().toString().matches(emailPattern)) {

            //Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
            return true;

        } else if(!t2.getText().toString().matches(emailPattern)) {

            Toast.makeText(getApplicationContext(),"Please Enter Valid Email Address",Toast.LENGTH_SHORT).show();
            return false;

        }

        return false;
    }
    private boolean validate() {

        String MobilePattern = "[0-9]{10}";


        if(t5.getText().toString().matches(MobilePattern)) {

            return true;

        } else if(!t5.getText().toString().matches(MobilePattern)) {

            Toast.makeText(getApplicationContext(), "Please enter valid 10 digit phone number", Toast.LENGTH_SHORT).show();
            return false;
        }

        return false;
    }
}