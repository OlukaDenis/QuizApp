package com.mcdennylucaz.quiz;
/**
 * This app was created by Oluka Denis
 * June 2018
 */

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String score_result = "";

    EditText name;
    String nameEntry;

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

    RadioGroup question10;
    RadioButton question10a;
    RadioButton question10b;

    TextView scores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting reference to the checkboxes
        name = (EditText) findViewById(R.id.username);
       // nameEntry = name.getText().toString();
        //if (TextUtils.isEmpty(nameEntry)) {
          // Toast.makeText(getApplicationContext(), "You must provide your name before continuing", Toast.LENGTH_SHORT).show();
      // }


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

        question10a = (RadioButton) findViewById(R.id.qn10_1);
        question10b = (RadioButton) findViewById(R.id.qn10_2);
        question10 = (RadioGroup) findViewById(R.id.question10);

        scores = (TextView) findViewById(R.id.score_view);
    }

    public void checkName(View view){
        if(name.getText().toString().isEmpty()){
            name.setError("You must provide your name first before answering \n");
        }
    }

    /**
     * The method that is called when the submit button is clicked
     */
    public void getAnswer(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Are you sure you want to submit?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //this checks whether the user has answered all the questions


                if (

                         (!question1a.isChecked() && !question1b.isChecked() && !question1c.isChecked() && !question1d.isChecked()) ||
                                (!question2a.isChecked() && !question2b.isChecked() && !question2c.isChecked() && !question2d.isChecked()) ||
                                (!question4a.isChecked() && !question4b.isChecked() && !question4c.isChecked() && !question4d.isChecked()) |
                                        (!question5a.isChecked() && !question5b.isChecked()) ||
                                (!question6a.isChecked() && !question6b.isChecked() && !question6c.isChecked() && !question6d.isChecked()) ||
                                (!question8a.isChecked() && !question8b.isChecked() && !question8c.isChecked() && !question8d.isChecked()) ||
                                (!question10a.isChecked() && !question10b.isChecked()) ||
                                question3a.getText().toString().isEmpty() ||
                                question7a.getText().toString().isEmpty() ||
                                question9a.getText().toString().isEmpty() ||
                               name.getText().toString().isEmpty()

                        ) {
                          name.setError("You must provide your name first \n");
                    Toast.makeText(getApplicationContext(), "Please answer all the questions!", Toast.LENGTH_SHORT).show();
                }

                else {

                    //Fetching the user answers


                    boolean one1 = question1a.isChecked();
                    boolean one2 = question1b.isChecked();
                    boolean one3 = question1c.isChecked();
                    boolean one4 = question1d.isChecked();
                    if (one1) {
                        score_result += "Qn 1: " + getString(R.string.q_a) + "\n";
                    }
                    if (one2) {
                        score_result += "Qn 1: " + getString(R.string.q_b) + "\n";
                    }
                    if (one3) {
                        score_result += "Qn 1: " + getString(R.string.q_c) + "\n";
                    }
                    if (one4) {
                        score_result += "Qn 1: " + getString(R.string.q_d) + "\n";
                    }

                    boolean two1 = question2a.isChecked();
                    boolean two2 = question2b.isChecked();
                    boolean two3 = question2c.isChecked();
                    boolean two4 = question2d.isChecked();
                    if (two1) {
                        score_result += "Qn 2: " + getString(R.string.q2_a) + "\n";
                    }
                    if (two2) {
                        score_result += "Qn 2: " + getString(R.string.q2_b) + "\n";
                    }
                    if (two3) {
                        score_result += "Qn 2: " + getString(R.string.q2_c) + "\n";
                    }
                    if (two4) {
                        score_result += "Qn 2: " + getString(R.string.q2_d) + "\n";
                    }

                    score_result += "Qn 3: " + question3a.getText().toString() + "\n";

                    boolean four1 = question4a.isChecked();
                    boolean four2 = question4b.isChecked();
                    boolean four3 = question4c.isChecked();
                    boolean four4 = question4d.isChecked();
                    if (four1) {
                        score_result += "Qn 4: " + getString(R.string.q4_a) + "\n";
                    }
                    if (four2) {
                        score_result += "Qn 4: " + getString(R.string.q4_b) + "\n";
                    }
                    if (four3) {
                        score_result += "Qn 4: " + getString(R.string.q4_c) + "\n";
                    }
                    if (four4) {
                        score_result += "Qn 4: " + getString(R.string.q4_d) + "\n";
                    }

                    boolean five1 = question5a.isChecked();
                    boolean five2 = question5b.isChecked();
                    if (five1) {
                        score_result += "Qn 5: " + getString(R.string.q5_a) + "\n";
                    }
                    if (five2) {
                        score_result += "Qn 5: " + getString(R.string.q5_b) + "\n";
                    }

                    boolean six1 = question6a.isChecked();
                    boolean six2 = question6b.isChecked();
                    boolean six3 = question6c.isChecked();
                    boolean six4 = question6d.isChecked();
                    if (six1) {
                        score_result += "Qn 6: " + getString(R.string.q6_a) + "\n";
                    }
                    if (six2) {
                        score_result += "Qn 6: " + getString(R.string.q6_b) + "\n";
                    }
                    if (six3) {
                        score_result += "Qn 6: " + getString(R.string.q6_c) + "\n";
                    }
                    if (six4) {
                        score_result += "Qn 6: " + getString(R.string.q6_d) + "\n";
                    }

                    score_result += "Qn 7: " + question7a.getText().toString() + "\n";

                    boolean eight1 = question8a.isChecked();
                    boolean eight2 = question8b.isChecked();
                    boolean eight3 = question8c.isChecked();
                    boolean eight4 = question8d.isChecked();
                    if (eight1) {
                        score_result += "Qn 8: " + getString(R.string.q8_a) + "\n";
                    }
                    if (eight2) {
                        score_result += "Qn 8: " + getString(R.string.q8_b) + "\n";
                    }
                    if (eight3) {
                        score_result += "Qn 8: " + getString(R.string.q8_c) + "\n";
                    }
                    if (eight4) {
                        score_result += "Qn 8: " + getString(R.string.q8_d) + "\n";
                    }

                    score_result += "Qn 9: " + question9a.getText().toString() + "\n";

                    boolean ten1 = question10a.isChecked();
                    boolean ten2 = question10b.isChecked();
                    if (ten1) {
                        score_result += "Qn 10: " + getString(R.string.q10_a) + "\n";
                    }
                    if (ten2) {
                        score_result += "Qn 10: " + getString(R.string.q10_b) + "\n";
                    }

                    scores.setText("Name: "+name.getText().toString() +" \nYour points:  " + answers() + "/10 \n\n" + score_result);
                    scores.setVisibility(View.VISIBLE);
                    //Toast.makeText(this, "You have scored " + answers() + "/9 points", Toast.LENGTH_LONG).show();
                }
            }
        })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.setCancelable(true);
                        Toast.makeText(getApplication(), "Okay, Continue answering", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.create().show();
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
        if (ans9.equals(answer9) || (ans9.equals("Intent")) || ans9.equals(answer9 + " ") || (ans9.equals("Intent ")) ) {
            score += 1;
        }

        //Checking question ten
        if (question10b.isChecked()) {
            score += 1;
        } else {

        }

        return score;
    }

    //Method  that is called when the retry button is clicked
    public void resetBtn(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("\tTRY AGAIN \n");
        builder.setPositiveButton("ANSWERS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //this checks whether the user has answered all the questions
                if (
                        (!question1a.isChecked() && !question1b.isChecked() && !question1c.isChecked() && !question1d.isChecked()) ||
                                (!question2a.isChecked() && !question2b.isChecked() && !question2c.isChecked() && !question2d.isChecked()) ||
                                (!question4a.isChecked() && !question4b.isChecked() && !question4c.isChecked() && !question4d.isChecked()) |
                                        (!question5a.isChecked() && !question5b.isChecked()) ||
                                (!question6a.isChecked() && !question6b.isChecked() && !question6c.isChecked() && !question6d.isChecked()) ||
                                (!question8a.isChecked() && !question8b.isChecked() && !question8c.isChecked() && !question8d.isChecked()) ||
                                (!question10a.isChecked() && !question10b.isChecked()) ||
                                question3a.getText().toString().isEmpty() ||
                                question7a.getText().toString().isEmpty() ||
                                question9a.getText().toString().isEmpty()

                        ){
                    Toast.makeText(getApplicationContext(), "You should submit your answers first!", Toast.LENGTH_SHORT).show();
                } else{

                    Intent intent = new Intent(MainActivity.this, Answers.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "These are the expected answers!", Toast.LENGTH_LONG).show();
                }
            }
        })
                .setNegativeButton("RETRY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

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

                        question10.clearCheck();

                        score_result ="";

                        scores.setText("");
                        scores.setVisibility(View.INVISIBLE);

                        Toast.makeText(getApplicationContext(), "Give it another try, this can be your chance", Toast.LENGTH_LONG).show();
                    }
                });

        builder.create().show();


    }


    // This method below hides the keyboard when the user clicks away from the EditText box

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
    } // this solution above was found on stackOverflow - https://stackoverflow.com/questions/4165414/how-to-hide-soft-keyboard-on-android-after-clicking-outside-edittext/16176277#16176277


}
