package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMIResult extends AppCompatActivity {

    float int_bmi, int_height, int_weight;
    String bmi, height, weight;
    RelativeLayout back_ground;
    TextView bmi_display_value, bmi_category, gender;
    Button go_to_main;

    Intent intent;
    ImageView image_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);

        bmi_category = findViewById(R.id.bmi_category_text);
        go_to_main = findViewById(R.id.navigate_bmi);
        bmi_display_value = findViewById(R.id.bmi_display_text);

        back_ground = findViewById(R.id.bmi_result_card);
        gender = findViewById(R.id.gender_text);
        image_view = findViewById(R.id.right_check);

        intent=getIntent();
        weight=intent.getStringExtra(getString(R.string.wt));
        height=intent.getStringExtra(getString(R.string.ht));

        int_height = Float.parseFloat(height);
        int_weight = Float.parseFloat(weight);
        int_height = int_height /100;
        int_bmi = int_weight /(int_height * int_height);
        bmi = Float.toString(int_bmi);

        // giving bmi result according to the calculate
        if(int_bmi <16)
        {
            bmi_category.setText(R.string.severely_thin);
            back_ground.setBackgroundColor(Color.RED);
            image_view.setImageResource(R.drawable.crosss);

        }
        else if(int_bmi <16.9 && int_bmi >16)
        {
            bmi_category.setText(R.string.moderately_thin);
            back_ground.setBackgroundColor(getResources().getColor(R.color.halfwarn));
            image_view.setImageResource(R.drawable.warning);

        }
        else if(int_bmi <18.4 && int_bmi >17)
        {
            bmi_category.setText(R.string.mildly_thin);
            back_ground.setBackgroundColor(getResources().getColor(R.color.halfwarn));
            image_view.setImageResource(R.drawable.warning);
        }
        else if(int_bmi <24.9 && int_bmi >18.5 )
        {
            bmi_category.setText(R.string.normal);
            image_view.setImageResource(R.drawable.right_check);
        }
        else if(int_bmi <29.9 && int_bmi >25)
        {
            bmi_category.setText(R.string.overweight);
            back_ground.setBackgroundColor(getResources().getColor(R.color.halfwarn));
            image_view.setImageResource(R.drawable.warning);
        }
        else if(int_bmi <34.9 && int_bmi >30)
        {
            bmi_category.setText(R.string.obeseC1);
            back_ground.setBackgroundColor(getResources().getColor(R.color.halfwarn));
            image_view.setImageResource(R.drawable.warning);
        }
        else
        {
            bmi_category.setText(R.string.obeseC2);
            back_ground.setBackgroundColor(getResources().getColor(R.color.warn));
            image_view.setImageResource(R.drawable.crosss);
        }
        gender.setText(intent.getStringExtra(getString(R.string.gender_categ)));
        bmi_display_value.setText(bmi);
        go_to_main.setOnClickListener(res -> startActivity(new Intent(getApplicationContext(),BMI.class)));
    }
}