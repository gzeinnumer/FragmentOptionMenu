package com.gzeinnumer.fragmentoptionmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState ==null){
            Fragment fragment = new FirstFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fr_1, fragment)
                    .commit();
        }
    }
}