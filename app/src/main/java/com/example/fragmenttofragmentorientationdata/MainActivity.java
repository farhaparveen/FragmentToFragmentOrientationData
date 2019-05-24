package com.example.fragmenttofragmentorientationdata;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.FragmentOneListener{
    Fragment1 fragment1;
    Fragment2 fragment2;

    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager=getSupportFragmentManager();
        fragment1 = (Fragment1) manager.findFragmentByTag("TagFragment1");
        if (fragment1==null) {
            fragment1 = new Fragment1();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.add(R.id.frag_container,fragment1,"TagFragment1");
            transaction.commit();
        }
        fragment2 = (Fragment2) manager.findFragmentByTag("TagFragment2");
        if (fragment2==null) {
            fragment2=new Fragment2();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.frag_container1, fragment2, "TagFragment2");
            transaction.commit();
        }


    }

    @Override
    public void onButtonClickOfFragmentOne(String s) {
        fragment2.receiveFromActivityToFrag2ViaFrag1(s);
    }


}
