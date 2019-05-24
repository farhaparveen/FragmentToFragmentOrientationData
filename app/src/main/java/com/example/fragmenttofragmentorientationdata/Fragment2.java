package com.example.fragmenttofragmentorientationdata;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragment2 extends Fragment {


TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

   View view= inflater.inflate(R.layout.fragment_fragment2, container, false);
        textView=view.findViewById(R.id.frag2Txt);
        setRetainInstance(true);
        if(savedInstanceState!=null) {
            String s = savedInstanceState.getString("savedTextViewState");
            textView.setText(s);
        }
        return view;
    }


    void receiveFromActivityToFrag2ViaFrag1(String str)
    {
        textView.setText(str);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String txtString=textView.getText().toString();
        outState.putString("savedTextViewState",txtString);
    }

}
