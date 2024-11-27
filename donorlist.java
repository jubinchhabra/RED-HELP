package com.example.myapplication.RedHelp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class donorlist extends AppCompatActivity {

    ListView l1;
    TextView t1;
    SearchView s1;
    ArrayAdapter<String> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donorlist);
        l1 = findViewById(R.id.list1);
        s1 = findViewById(R.id.sear);
        s1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                adp.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adp.getFilter().filter(s);
                return false;
            }
        });
        ArrayList<String> listdata;
        listdata = new ArrayList<String>();
        RequestQueue requestqueue;
        requestqueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://dssbloodneed.000webhostapp.com/blood/find.php", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    String str;
                    // Toast.makeText(getApplicationContext(), "length-"+response.length(), Toast.LENGTH_SHORT).show();

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);
                        str = jsonObject.getString("Name");
                        str += "\n";
                        str += jsonObject.getString("number");
                        str += "          ";
                        str += jsonObject.getString("bloodgroup");
                        str += "          ";
                        str += jsonObject.getString("District");

                        listdata.add(str);
                    }
                    adp = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, listdata);
                    l1.setAdapter(adp);
                    //   Toast.makeText(getApplicationContext(), "all ok", Toast.LENGTH_SHORT).show();
                } catch (JSONException ex) {
                    Toast.makeText(getApplicationContext(), "error-" + ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error-" + error.getMessage(), Toast.LENGTH_SHORT).show();
                t1.setText(error.getMessage());
            }
        });
Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();

        requestqueue.add(jsonArrayRequest);
    }
}


