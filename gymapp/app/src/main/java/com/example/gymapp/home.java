package com.example.gymapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class home extends Fragment {

    CardView cv;
    public home() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment_view= inflater.inflate(R.layout.fragment_home, container, false);
        cv = fragment_view.findViewById(R.id.gym_workout);
        cv.setOnClickListener(res -> startActivity(new Intent(getActivity(),Exercise.class)));
        return fragment_view;
    }
}