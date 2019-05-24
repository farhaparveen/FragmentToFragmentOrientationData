package com.example.fragmenttofragmentorientationdata;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Fragment1 extends Fragment {
    EditText et;
    TextView t;
    Button b;
    FragmentOneListener listener;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_fragment1, container, false);

        et=view.findViewById(R.id.fragEditTxt);
        t=view.findViewById(R.id.fragTxt);
        b=view.findViewById(R.id.fragBtn);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTxtString=et.getText().toString();
                t.setText(editTxtString);

                listener.onButtonClickOfFragmentOne(editTxtString);
            }
        });

        setRetainInstance(true);

        if(savedInstanceState!=null) {
            String s = savedInstanceState.getString("savedTextViewState");
            t.setText(s);
        }
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String editTxtString=et.getText().toString();
        outState.putString("savedTextViewState",editTxtString);
    }


interface FragmentOneListener
    {
        void onButtonClickOfFragmentOne(String str);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener=(FragmentOneListener)context;
    }


}
