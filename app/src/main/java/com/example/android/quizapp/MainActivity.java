package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendAnswers(View view) {

        calculateScore();
        displayScore(score);

        // Reset score automatically to play again
        score = 0;

    }

    /**
     * Calculates the score of the quiz.
     *
     */
    private int calculateScore() {

        // Add one point for answer 1 correct
        RadioButton answer1 = (RadioButton) findViewById(R.id.radio_president_1);
        boolean hasAnswer1Correct = answer1.isChecked();

        if (hasAnswer1Correct) {
                score += 1;
        }

        // Add one point for answer 2 correct
        CheckBox blueCheckBox = (CheckBox) findViewById(R.id.checkbox_blue);
        boolean hasBlueCorrect = blueCheckBox.isChecked();

        CheckBox whiteCheckBox = (CheckBox) findViewById(R.id.checkbox_white);
        boolean hasWhiteCorrect = whiteCheckBox.isChecked();

        CheckBox yellowCheckBox = (CheckBox) findViewById(R.id.checkbox_yellow);
        boolean hasYellowCorrect = yellowCheckBox.isChecked();

        if (hasBlueCorrect && hasWhiteCorrect && hasYellowCorrect) {
            score += 1;
        }

        // Add one point for answer 3 correct
        EditText cityNameField = (EditText) findViewById(R.id.city_name);
        String answerCityName = cityNameField.getText().toString();

        if (answerCityName.contains("montevideo")) {
            score += 1;
        }

        // Add one point for answer 4 correct
        RadioButton answer4 = (RadioButton) findViewById(R.id.radio_answer4_2);
        boolean hasAnswer4Correct = answer4.isChecked();

        if (hasAnswer4Correct) {
            score += 1;
        }

        // Add one point for answer 5 correct
        EditText sportNameField = (EditText) findViewById(R.id.sport_name);
        String answerSportName = sportNameField.getText().toString();

        if (answerSportName.contains("soccer")) {
            score += 1;
        }

        return score;

    }

    /**
     * This method displays the score as a toast
     */
    private void displayScore(int score) {

        Toast.makeText(this, "Points: " + score, Toast.LENGTH_SHORT).show();
    }

}
