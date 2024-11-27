package com.example.myapplication.RedHelp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;


public class homeFragment extends Fragment {

    LottieAnimationView i1,i4,i2,i3;
Button b1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View v= inflater.inflate(R.layout.fragment_home, container, false);
        i1=v.findViewById(R.id.i1);
        i2=v.findViewById(R.id.i3);
        i4=v.findViewById(R.id.i4);
        i3=v.findViewById(R.id.i2);
        b1=v.findViewById(R.id.button);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj=new Intent(getContext(),donorform.class);
                startActivity(obj);
              //  getActivity().overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj=new Intent(Intent.ACTION_VIEW);
                obj.setData(Uri.parse("https://www.aajtak.in/"));
                startActivity(obj);
            //    getActivity().overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj= new Intent(getContext(),ambulance.class);
                startActivity(obj);
          //      getActivity().overridePendingTransition(R.anim.slideinright, R.anim.slideoutleft);
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj=new Intent(getContext(), blood.class);
                startActivity(obj);
           //     getActivity().overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast.makeText(getContext(), "finding", Toast.LENGTH_SHORT).show();
                Intent obj=new Intent(getContext(),donorlist.class);
                startActivity(obj);
                getActivity().overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
            }
        });


        return v;
    }
}