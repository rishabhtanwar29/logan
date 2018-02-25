package com.example.android.digitalhome;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import okhttp3.OkHttpClient;
import okhttp3.Request;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    View view;
    public Button lightbtn;
    public Button fanbtn;
    public Button logoutbtn;


    OkHttpClient client;
    Request request;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_main, container, false);
        lightbtn= (Button) view.findViewById(R.id.blight);
        fanbtn= (Button) view.findViewById(R.id.bfan);
        logoutbtn= (Button) view.findViewById(R.id.blogout);

        lightbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getActivity(), LightActivity.class);
                startActivity(i);
            }
        });
        fanbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getActivity(), FanActivity.class);
                startActivity(i);
            }
        });
        logoutbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sharedPreferences = getContext().getSharedPreferences("myToken", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("token", null);
                editor.commit();
                BlankFragment fragmentOne= new BlankFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,fragmentOne);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
