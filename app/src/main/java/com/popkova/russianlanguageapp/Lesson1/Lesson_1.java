package com.popkova.russianlanguageapp.Lesson1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.popkova.russianlanguageapp.R;

public class Lesson_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);
    }

    public void Start_L1_grammar(View view) {
        Intent intent = new Intent(Lesson_1.this, Lesson_1_grammar.class);
        startActivity(intent);
    }
}
