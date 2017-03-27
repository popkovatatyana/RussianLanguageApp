package com.popkova.russianlanguageapp.Lesson1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.popkova.russianlanguageapp.R;

public class Lesson_1_grammar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_1_grammar);
    }

    public void Check_L1_grammar(View view) {
        EditText mA1 = (EditText)findViewById(R.id.L1_G_A1);
        Intent intent = new Intent(Lesson_1_grammar.this, L1_grammar_results.class);
        intent.putExtra("A1", mA1.getText().toString());
        startActivity(intent);
    }
}
