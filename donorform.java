package com.example.myapplication.RedHelp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
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

public class donorform extends AppCompatActivity {
    EditText t1,t2,t3,t4;
    RadioButton r1,r2;
    Button b1;
    Spinner s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donorform);

        t1=findViewById(R.id.editTextText3);
        t2=findViewById(R.id.editTextNumber);
        t3=findViewById(R.id.editTextText2);
        t4=findViewById(R.id.editTextText8);
        s1=findViewById(R.id.spinner);
        b1=findViewById(R.id.button);
        r1=findViewById(R.id.radioButton);
        r2=findViewById(R.id.radioButton2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Toast.makeText(donorform.this, "Successfully submit", Toast.LENGTH_SHORT).show();
                if(TextUtils.isEmpty(t1.getText().toString())){
                    t1.setError(" Compulsory");
                }
                else if(TextUtils.isEmpty(t2.getText().toString())){
                    t2.setError("Compulsory");
                }
                else if(TextUtils.isEmpty(t3.getText().toString())){
                    t3.setError("Compulsory");
                } else if(TextUtils.isEmpty(t4.getText().toString())){
                    t4.setError("Compulsory");


                } if (validate() && validate1()){

                    data();
                    Intent obj= new Intent(getApplicationContext(),Home_activity.class);
                    startActivity(obj);
                  //  overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);


                }

            }
        });



        String[] item_list=getResources().getStringArray(R.array.group);

        ArrayAdapter<String> myadp=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,item_list);

        s1.setAdapter(myadp);




    }
    String gender;
    public void data(){
        // gender=null;
        if(r1.isChecked()){
  gender=  r1.getText().toString();
        }
        else{
        gender=    r2.getText().toString();
        }
//   Toast.makeText(getApplicationContext(),"gender-"+)


            String url="https://dssbloodneed.000webhostapp.com/blood/donor.php";
            String name=t1.getText().toString();
            String number=t2.getText().toString();
            String mail =t3.getText().toString();

            String group=s1.getSelectedItem().toString();
            String district=t4.getText().toString();
            StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_SHORT).show();


                }

    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
Toast.makeText(getApplicationContext(),"error-"+error.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }

    }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> param=new HashMap<String,String>();
                    param.put("user_id",name);
                  param.put("user_mobile",number);
                  param.put("user_email",mail);
//                  param.put("user_gender",gender);
                   param.put("user_group",group);

                  param.put("user_district",district);
                  param.put("user_gender",gender);
                    return param;
                }
            };
            RequestQueue queue= Volley.newRequestQueue(donorform.this);
            queue.add(request);


        }

    private boolean validate() {

        String MobilePattern = "[0-9]{10}";
        //String email1 = email.getText().toString().trim();
       // String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

         if(t2.getText().toString().matches(MobilePattern)) {

            return true;

        } else if(!t2.getText().toString().matches(MobilePattern)) {

            Toast.makeText(getApplicationContext(), "Please enter valid 10 digit phone number", Toast.LENGTH_SHORT).show();
            return false;
        }

        return false;
    }
    private boolean validate1() {

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (t3.length() > 25) {

            Toast.makeText(getApplicationContext(), "pls enter less the 25 character in user name", Toast.LENGTH_SHORT).show();
            return true;

        }  else if (t3.getText().toString().matches(emailPattern)) {

            //Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
            return true;

        } else if(!t3.getText().toString().matches(emailPattern)) {

            Toast.makeText(getApplicationContext(),"Please Enter Valid Email Address",Toast.LENGTH_SHORT).show();
            return false;

        }

        return false;
    }

}
