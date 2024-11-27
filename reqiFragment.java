package com.example.myapplication.RedHelp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
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


public class reqiFragment extends Fragment {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    Button b1;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_reqi, container, false);


        t1=v.findViewById(R.id.editTextText3);
        t2=v.findViewById(R.id.editTextText16);
        t3=v.findViewById(R.id.editTextText17);
        t4=v.findViewById(R.id.editTextText18);
        t5=v.findViewById(R.id.editTextText19);
        t6=v.findViewById(R.id.editTextText20);
        t7=v.findViewById(R.id.editTextText22);
        t8=v.findViewById(R.id.editTextText23);
        t9=v.findViewById(R.id.editTextText24);
        b1=v.findViewById(R.id.button22);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                     //   Toast.makeText(getContext(),"hello",Toast.LENGTH_SHORT).show();
                        if(TextUtils.isEmpty(t1.getText().toString())){
                            t1.setError(" Compulsory");
                        }
                        else if(TextUtils.isEmpty(t2.getText().toString())){
                            t2.setError(" Compulsory");
                        }
                        else if(TextUtils.isEmpty(t3.getText().toString())){
                            t3.setError(" Compulsory");
                        } else if(TextUtils.isEmpty(t4.getText().toString())){
                            t4.setError(" Compulsory");
                        } else if(TextUtils.isEmpty(t5.getText().toString())){
                            t5.setError(" Compulsory");
                        } else if(TextUtils.isEmpty(t6.getText().toString())){
                            t6.setError(" Compulsory");
                        } else if(TextUtils.isEmpty(t7.getText().toString())){
                            t7.setError(" Compulsory");
                        } else if(TextUtils.isEmpty(t8.getText().toString())){
                            t8.setError(" Compulsory");
                        } else if(TextUtils.isEmpty(t9.getText().toString())){
                            t9.setError(" Compulsory");
                        }
                       else if(validate()){
                            reg();
                            Intent obj=new Intent(getContext(),Home_activity.class);
                            startActivity(obj);
                          //  getActivity().overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
                        }

                    }
                });
            }
        });












        return v;
    }
    public void reg(){
        String url="https://dssbloodneed.000webhostapp.com/blood/requirement.php";
        String ptname=t1.getText().toString();
        String cptname=t2.getText().toString();
        String group=t3.getText().toString();
        String district=t4.getText().toString();
        String city=t5.getText().toString();
        String hospital=t6.getText().toString();
        String units=t7.getText().toString();
        String phone=t8.getText().toString();
        String date=t9.getText().toString();

        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getContext(), response.toString(), Toast.LENGTH_SHORT).show();
          // t1.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "error submit-"+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param=new HashMap<String,String>();
                param.put("userptname",ptname);
                param.put("usercpname",cptname);
                param.put("usergroup",group);
                param.put("userdistrict",district);
                param.put("usercity",city);
                param.put("userhospital",hospital);
                param.put("userunits",units);
                param.put("userphone",phone);
                param.put("userdate",date);


                return param;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(getContext());
       queue.add(request);

    }
    private boolean validate() {

        String MobilePattern = "[0-9]{10}";


        if(t8.getText().toString().matches(MobilePattern)) {

            return true;

        } else if(!t8.getText().toString().matches(MobilePattern)) {

            Toast.makeText(getContext(), "Please enter valid 10 digit phone number", Toast.LENGTH_SHORT).show();
            return false;
        }

        return false;
    }
}
