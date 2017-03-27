package com.popkova.russianlanguageapp.Lesson1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.popkova.russianlanguageapp.MainActivity;
import com.popkova.russianlanguageapp.R;
import com.popkova.russianlanguageapp.UserLocalStore;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class L1_grammar_results extends AppCompatActivity {
    private int scoreForAGame = 0;
    TextView totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l1_grammar_results);
        TextView mL1_G_RESULTS = (TextView)findViewById(R.id.L1_G_RESULTS);
        String answerReceived = getIntent().getExtras().getString("A1");
        Context context = getBaseContext();
        String text = readRawTextFile(context, getResources().getIdentifier("answers", "raw", "com.popkova.russianlanguageapp"));
        UserLocalStore userLocalData = new UserLocalStore(this);
        try{
            JSONObject jsonObject = new JSONObject(text);
            String answerTrue = jsonObject.getString("A1");
            if (answerTrue.equals(answerReceived)){
                scoreForAGame++;
            }
            } catch (JSONException e){}
        String result = "Правильных ответов: "+ scoreForAGame;
        mL1_G_RESULTS.setText(result);
        userLocalData.setScoreForAGame(scoreForAGame);
        userLocalData.setTotalScore(scoreForAGame);
        TextView totalScore = (TextView)findViewById(R.id.TOTAL_SCORE);
        totalScore.setText(userLocalData.getTotalScore() + "");
    }

    public static String readRawTextFile(Context context, int resId)
    {
        InputStream inputStream = context.getResources().openRawResource(resId);

        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader buffReader = new BufferedReader(inputReader);
        String line;
        StringBuilder builder = new StringBuilder();

        try {
            while (( line = buffReader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
        } catch (IOException e) {
            return null;
        }
        return builder.toString();
    }

    public void ToMainPage(View view) {
        Intent intent = new Intent(L1_grammar_results.this, MainActivity.class);
        startActivity(intent);
    }
}
