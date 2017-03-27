package com.popkova.russianlanguageapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.popkova.russianlanguageapp.Lesson1.Lesson_1;

public class ListActivity extends android.app.ListActivity {
    final static int number = 10;
    final String [] Lessons = new String [number];
    private ArrayAdapter<String> mArrayAdapter;

    public void LessonsCreation(int number){
        String NameOfLesson = "Lesson ";
        for (int i=0; i<number; i++){
            int numberFollowing = i+1;
            String numberName  = "" + numberFollowing;
            Lessons[i] = new String(NameOfLesson.concat(numberName));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LessonsCreation(number);
        mArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Lessons);
        setListAdapter(mArrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        int LessonNumber = position + 1;
        String className = "Lesson_"+LessonNumber;
        Intent intent = new Intent( ListActivity.this, Lesson_1.class);
        startActivity(intent);
    }
}
