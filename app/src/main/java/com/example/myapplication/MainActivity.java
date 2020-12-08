package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
private Button yesBtn;
private Button noBtn;
private Button showAnswer;
    private static String ArrayList;
    private Question[] questions = new Question[]{
        new Question(R.string.question,true),
        new Question(R.string.question1,false),
        new Question(R.string.question2,false),
        new Question(R.string.question3,false),
        new Question(R.string.question4,false),
        new Question(R.string.question5,false)
};
private int questionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SYSTEM INFO","Метод onCreate() запущен");
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        yesBtn =(Button) findViewById(R.id.yesBtn);
        showAnswer = (Button) findViewById(R.id.showAnswer);
        if (savedInstanceState != null){// Если есть сохранённая информация, то достаём её.
            questionIndex = savedInstanceState.getInt("questionIndex");
        }
        textView.setText(questions[questionIndex].getQuestionReId());
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions[questionIndex].isAnswerTrue())
                Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();
                questionIndex=(questionIndex + 1)%questions.length;
                textView.setText(questions[questionIndex].getQuestionReId());}});


noBtn = (Button) findViewById(R.id.noBtn);
noBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
    if (questions[questionIndex].isAnswerTrue())

        Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();
    else
        Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
    questionIndex=(questionIndex + 1)%questions.length;
    textView.setText(questions[questionIndex].getQuestionReId());}});
        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer",questions[questionIndex].isAnswerTrue());
                startActivity(intent);

            }
        });}


    @Override
    public void onStart(){
        super.onStart();
        Log.d("SYSTEM INFO","Метод onStart() запущен");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d("SYSTEM INFO","Метод onResume() запущен");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("SYSTEM INFO","Метод onPause() запущен");
    } @Override
    public void onStop(){
        super.onStop();
        Log.d("SYSTEM INFO","Метод onStop() запущен");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){ // Метод сохранения данных перед уничтожением активности
        super.onSaveInstanceState(savedInstanceState);
        Log.d("SYSTEM INFO","Метод onSaveInstanceState() запущен");
        savedInstanceState.putInt("questionIndex",questionIndex); // Добавили элемент по ключу
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("SYSTEM INFO","Метод onDestroy() запущен");
    }
}
