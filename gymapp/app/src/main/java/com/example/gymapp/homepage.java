package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class homepage extends AppCompatActivity {

    private long bp;
    private static final int TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        SmoothBottomBar bar = findViewById(R.id.navigation_bar);
        changeFragment(new home());

        bar.setOnItemSelectedListener((OnItemSelectedListener) res -> {
            // switch condition for home, fitness, login fragment and profile
            switch (res){
                case 0:
                    changeFragment(new home());
                    break;

                case 1:
                    changeFragment(new fitness());
                    break;

            }
            return true;
        });
    }
    public void changeFragment(Fragment f) {
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.frame,f);
        t.commit();
    }

    // onBackPressed method
    @Override
    public void onBackPressed(){
        if(bp + TIME > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
            return;
        }
        else{
            Toast.makeText(getBaseContext(),R.string.press_back,Toast.LENGTH_SHORT).show();
        }
        bp = System.currentTimeMillis();
    }
}