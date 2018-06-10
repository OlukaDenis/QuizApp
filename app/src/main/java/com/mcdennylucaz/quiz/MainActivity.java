package com.mcdennylucaz.quiz;
/**
 * This app was created by Oluka Denis
 * June 2018
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox question1a;
    CheckBox question1b;
    CheckBox question1c;
    CheckBox question1d;

    CheckBox question2a;
    CheckBox question2b;
    CheckBox question2c;
    CheckBox question2d;

    EditText question3a;

    CheckBox question4a;
    CheckBox question4b;
    CheckBox question4c;
    CheckBox question4d;

    RadioGroup question5;
    RadioButton question5a;
    RadioButton question5b;

    CheckBox question6a;
    CheckBox question6b;
    CheckBox question6c;
    CheckBox question6d;

    EditText question7a;

    CheckBox question8a;
    CheckBox question8b;
    CheckBox question8c;
    CheckBox question8d;

    EditText question9a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting reference to the checkboxes
        question1a = (CheckBox) findViewById(R.id.qn1_1);
        question1b = (CheckBox) findViewById(R.id.qn1_2);
        question1c = (CheckBox) findViewById(R.id.qn1_3);
        question1d = (CheckBox) findViewById(R.id.qn1_4);

        question2a = (CheckBox) findViewById(R.id.qn2_1);
        question2b = (CheckBox) findViewById(R.id.qn2_2);
        question2c = (CheckBox) findViewById(R.id.qn2_3);
        question2d = (CheckBox) findViewById(R.id.qn2_4);

        question3a = (EditText) findViewById(R.id.question3);

        question4a = (CheckBox) findViewById(R.id.qn4_1);
        question4b = (CheckBox) findViewById(R.id.qn4_2);
        question4c = (CheckBox) findViewById(R.id.qn4_3);
        question4d = (CheckBox) findViewById(R.id.qn4_4);

        question5a = (RadioButton) findViewById(R.id.qn5_1);
        question5b = (RadioButton) findViewById(R.id.qn5_2);
        question5 = (RadioGroup) findViewById(R.id.question5);

        question6a = (CheckBox) findViewById(R.id.qn6_1);
        question6b = (CheckBox) findViewById(R.id.qn6_2);
        question6c = (CheckBox) findViewById(R.id.qn6_3);
        question6d = (CheckBox) findViewById(R.id.qn6_4);

        question7a = (EditText) findViewById(R.id.question7);

        question8a = (CheckBox) findViewById(R.id.qn8_1);
        question8b = (CheckBox) findViewById(R.id.qn8_2);
        question8c = (CheckBox) findViewById(R.id.qn8_3);
        question8d = (CheckBox) findViewById(R.id.qn8_4);

        question9a = (EditText) findViewById(R.id.question9);
    }

    /**
     * The method that is called when the submit button is clicked
     */
    public void getAnswer(View view) {
        //this checks whether the user has answered all the questions
        if (
                (!question1a.isChecked() && !question1b.isChecked() && !question1c.isChecked() && !question1d.isChecked()) ||
                        (!question2a.isChecked() && !question2b.isChecked() && !question2c.isChecked() && !question2d.isChecked()) ||
                        (!question4a.isChecked() && !question4b.isChecked() && !question4c.isChecked() && !question4d.isChecked()) |
                                (!question5a.isChecked() && !question5b.isChecked()) ||
                        (!question6a.isChecked() && !question6b.isChecked() && !question6c.isChecked() && !question6d.isChecked()) ||
                        (!question8a.isChecked() && !question8b.isChecked() && !question8c.isChecked() && !question8d.isChecked())
                ) {
            Toast.makeText(this, "Please answer all the questions!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "You have scored " + answers() + "/9 points", Toast.LENGTH_LONG).show();
        }


    }

    /**
     * Method that checks the answer in the checkboxes
     */
    public int answers() {
        int score = 0;

        //Checking question one
        if (question1a.isChecked()) {
            score += 1;
        }
        //Checking question two
        if (question2a.isChecked()) {
            score += 1;
        }

        //Checking question three

        /*question3a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    question3a.setHint("");
                }
            }
        });//this puts a label on the hint, got from stackoverflow*/

        String ans3 = question3a.getText().toString();
        String answer3 = getString(R.string.answer_qn3);
        if (ans3.equals(answer3) || ans3.equals(answer3 + " ")) {
            score += 1;
        }

        //Checking question four
        if (question4c.isChecked()) {
            score += 1;
        }

        //Checking question five
        if (question5a.isChecked()) {
            score += 1;
        }

        //Checking question six
        if (question6b.isChecked()) {
            score += 1;
        }

        //Checking question seven

        /*question7a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    question7a.setHint("");
                }
            }
        });//this puts a label on the hint, got from stackoverflow*/

        String ans7 = question7a.getText().toString();
        String answer7 = getString(R.string.answer_qn7);//Fetching the answer from the string file
        if (ans7.equals(answer7) || ans7.equals(answer7 + " ")) {
            score += 1;
        }

        //Checking question eight
        if (question8a.isChecked()) {
            score += 1;
        }

        //Checking question nine
        String ans9 = question9a.getText().toString();
        String answer9 = getString(R.string.answer_qn9);
        if (ans9.equals(answer9) || ans9.equals(answer9 + " ")) {
            score += 1;
        } else {

        }

        return score;
    }

    //Method  that is called when the reset button is clicked
    public void resetBtn(View view) {

        question1a.setChecked(false);
        question1b.setChecked(false);
        question1c.setChecked(false);
        question1d.setChecked(false);

        question2a.setChecked(false);
        question2b.setChecked(false);
        question2c.setChecked(false);
        question2d.setChecked(false);

        question3a.setText("");

        question4a.setChecked(false);
        question4b.setChecked(false);
        question4c.setChecked(false);
        question4d.setChecked(false);

        question5.clearCheck();

        question6a.setChecked(false);
        question6b.setChecked(false);
        question6c.setChecked(false);
        question6d.setChecked(false);

        question7a.setText("");

        question8a.setChecked(false);
        question8b.setChecked(false);
        question8c.setChecked(false);
        question8d.setChecked(false);

        question9a.setText("");

        Toast.makeText(this, "Give it another try, this can be your chance", Toast.LENGTH_LONG).show();
    }


    public void goAnswer(View view){
        if (
                (!question1a.isChecked() && !question1b.isChecked() && !question1c.isChecked() && !question1d.isChecked()) ||
                        (!question2a.isChecked() && !question2b.isChecked() && !question2c.isChecked() && !question2d.isChecked()) ||
                        (!question4a.isChecked() && !question4b.isChecked() && !question4c.isChecked() && !question4d.isChecked()) |
                                (!question5a.isChecked() && !question5b.isChecked()) ||
                        (!question6a.isChecked() && !question6b.isChecked() && !question6c.isChecked() && !question6d.isChecked()) ||
                        (!question8a.isChecked() && !question8b.isChecked() && !question8c.isChecked() && !question8d.isChecked())
                ) {
            Toast.makeText(this, "Please submit your answers first!", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(this, Answers.class);
            startActivity(intent);
        }

    }


    // This method hides the keyboard when the user clicks away from the EditText box

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    } // this solution was found on stackOverflow - https://stackoverflow.com/questions/4165414/how-to-hide-soft-keyboard-on-android-after-clicking-outside-edittext/16176277#16176277

}
