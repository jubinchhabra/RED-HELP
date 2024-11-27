package com.example.myapplication.RedHelp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link personFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class personFragment extends Fragment {
    Button b1;
    ImageButton i1,i2,i3,i4,i5,i6,i7;
    SharedPreferences sharedPreferences;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public personFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment personFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static personFragment newInstance(String param1, String param2) {
        personFragment fragment = new personFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_person, container, false);
        b1 = v.findViewById(R.id.button2);
        i1=v.findViewById(R.id.imageButton);
        i2=v.findViewById(R.id.imageButton1);
        i3=v.findViewById(R.id.imageButton2);
        i4=v.findViewById(R.id.imageButton3);
        i5=v.findViewById(R.id.imageButton4); i6=v.findViewById(R.id.imageButton5);
        i7=v.findViewById(R.id.imageButton6);

        sharedPreferences = getActivity().getSharedPreferences("autoLogin", Context.MODE_PRIVATE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("key", 0);
                editor.apply();


                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.remove(personFragment.this);

            }
        });
i1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), firstque.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
    }
});
i2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), sec.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
    }
});
i3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(getContext(), third.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
    }
});
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), four.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
            }
        });
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), five.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
            }
        });
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), six.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
            }
        });
        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), seven.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
            }
        });
        return v;

    }
}