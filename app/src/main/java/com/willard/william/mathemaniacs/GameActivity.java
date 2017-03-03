package com.willard.william.mathemaniacs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    //TODO change top of layout to look better

    SharedPreferences sharedPref;
    int mode;
    Question q;
    int real_answer;
    int time_limit;
    ProgressBar pb;
    TextView tv;
    CountDownTimer cdt;
    int time_passed;
    boolean timerDone;
    int streak;
    int previous_best_streak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mode = (int) getIntent().getSerializableExtra("mode");
        streak = (int) getIntent().getSerializableExtra("streak");
        sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        getPreviousBest();
        setQuestion();
        setQuestionText();
        setAnswers();
        setStreak();
        time_limit = q.time_limit;
        time_passed = 0;
        timerDone = false;
        setProgressBar();
    }

    private void getPreviousBest() {
        switch(mode) {
            case 0:
                previous_best_streak = sharedPref.getInt(getString(R.string.basicMultiHighScore), 0);
                break;
            case 1:
                previous_best_streak = sharedPref.getInt(getString(R.string.advancedMultiHighScore), 0);
                break;
            case 2:
                previous_best_streak = sharedPref.getInt(getString(R.string.expertMultiHighScore), 0);
                break;
            case 3:
                previous_best_streak = sharedPref.getInt(getString(R.string.squaresHighScore), 0);
                break;
            case 4:
                previous_best_streak = sharedPref.getInt(getString(R.string.moduloHighScore), 0);
                break;
            case 5:
                previous_best_streak = sharedPref.getInt(getString(R.string.factorialHighScore), 0);
        }
    }

    private void setQuestion() {
        switch (mode) {
            case 0:
                q = new BasicMultiplication(sharedPref.getInt(getString(R.string.basicDifficulty), 1));
                break;
            case 1:
                q = new AdvancedMultiplication(sharedPref.getInt(getString(R.string.advancedDifficulty), 1));
                break;
            case 2:
                q = new ExpertMultiplication(sharedPref.getInt(getString(R.string.expertDifficulty), 1));
                break;
            case 3:
                q = new Squares(sharedPref.getInt(getString(R.string.squaresDifficulty), 1));
                break;
            case 4:
                q = new Modulo(sharedPref.getInt(getString(R.string.moduloDifficulty), 1));
                break;
            case 5:
                q = new Factorial(sharedPref.getInt(getString(R.string.factorialDifficulty), 1));
        }
    }

    private void setQuestionText() {
        String question = "";
        if (q.blank == 0) {
            question += "_ ";
        } else {
            question += q.firstOperand + " ";
        }
        if (q.operation == 0) {
            question += "x ";
        } else if (q.operation == 1) {
            question += "% ";
        } else if (q.operation == 2) {
            question += "! ";
        }
        //TODO more operations here
        if (mode != 5) {
            if (q.blank == 1) {
                question += "_ ";
            } else {
                question += q.secondOperand + " ";
            }
        }
        if (q.blank == 2) {
            question += "= _";
        } else {
            question += "= " + q.result;
        }
        TextView t = (TextView) findViewById(R.id.questionText);
        if (t != null) {
            t.setText(question);
        }
    }

    private void setAnswers() {
        double rand = Math.random();
        if (rand < .25) {
            real_answer = 1;
            setAnswer1(q.real_answer);
            double rand2 = Math.random();
            if (rand2 < .165) {
                setAnswer2(q.fake_answer1);
                setAnswer3(q.fake_answer2);
                setAnswer4(q.fake_answer3);
            } else if (rand2 < .33) {
                setAnswer2(q.fake_answer1);
                setAnswer3(q.fake_answer3);
                setAnswer4(q.fake_answer2);
            } else if (rand2 < .495) {
                setAnswer2(q.fake_answer2);
                setAnswer3(q.fake_answer1);
                setAnswer4(q.fake_answer3);
            } else if (rand2 < .66) {
                setAnswer2(q.fake_answer2);
                setAnswer3(q.fake_answer3);
                setAnswer4(q.fake_answer1);
            } else if (rand2 < .825) {
                setAnswer2(q.fake_answer3);
                setAnswer3(q.fake_answer1);
                setAnswer4(q.fake_answer2);
            } else {
                setAnswer2(q.fake_answer3);
                setAnswer3(q.fake_answer2);
                setAnswer4(q.fake_answer1);
            }
        } else if (rand < .5) {
            real_answer = 2;
            setAnswer2(q.real_answer);
            double rand2 = Math.random();
            if (rand2 < .165) {
                setAnswer1(q.fake_answer1);
                setAnswer3(q.fake_answer2);
                setAnswer4(q.fake_answer3);
            } else if (rand2 < .33) {
                setAnswer1(q.fake_answer1);
                setAnswer3(q.fake_answer3);
                setAnswer4(q.fake_answer2);
            } else if (rand2 < .495) {
                setAnswer1(q.fake_answer2);
                setAnswer3(q.fake_answer1);
                setAnswer4(q.fake_answer3);
            } else if (rand2 < .66) {
                setAnswer1(q.fake_answer2);
                setAnswer3(q.fake_answer3);
                setAnswer4(q.fake_answer1);
            } else if (rand2 < .825) {
                setAnswer1(q.fake_answer3);
                setAnswer3(q.fake_answer1);
                setAnswer4(q.fake_answer2);
            } else {
                setAnswer1(q.fake_answer3);
                setAnswer3(q.fake_answer2);
                setAnswer4(q.fake_answer1);
            }
        } else if (rand < .75) {
            real_answer = 3;
            setAnswer3(q.real_answer);
            double rand2 = Math.random();
            if (rand2 < .165) {
                setAnswer1(q.fake_answer1);
                setAnswer2(q.fake_answer2);
                setAnswer4(q.fake_answer3);
            } else if (rand2 < .33) {
                setAnswer1(q.fake_answer1);
                setAnswer2(q.fake_answer3);
                setAnswer4(q.fake_answer2);
            } else if (rand2 < .495) {
                setAnswer1(q.fake_answer2);
                setAnswer2(q.fake_answer1);
                setAnswer4(q.fake_answer3);
            } else if (rand2 < .66) {
                setAnswer1(q.fake_answer2);
                setAnswer2(q.fake_answer3);
                setAnswer4(q.fake_answer1);
            } else if (rand2 < .825) {
                setAnswer1(q.fake_answer3);
                setAnswer2(q.fake_answer1);
                setAnswer4(q.fake_answer2);
            } else {
                setAnswer1(q.fake_answer3);
                setAnswer2(q.fake_answer2);
                setAnswer4(q.fake_answer1);
            }
        } else {
            real_answer = 4;
            setAnswer4(q.real_answer);
            double rand2 = Math.random();
            if (rand2 < .165) {
                setAnswer1(q.fake_answer1);
                setAnswer2(q.fake_answer2);
                setAnswer3(q.fake_answer3);
            } else if (rand2 < .33) {
                setAnswer1(q.fake_answer1);
                setAnswer2(q.fake_answer3);
                setAnswer3(q.fake_answer2);
            } else if (rand2 < .495) {
                setAnswer1(q.fake_answer2);
                setAnswer2(q.fake_answer1);
                setAnswer3(q.fake_answer3);
            } else if (rand2 < .66) {
                setAnswer1(q.fake_answer2);
                setAnswer2(q.fake_answer3);
                setAnswer3(q.fake_answer1);
            } else if (rand2 < .825) {
                setAnswer1(q.fake_answer3);
                setAnswer2(q.fake_answer1);
                setAnswer3(q.fake_answer2);
            } else {
                setAnswer1(q.fake_answer3);
                setAnswer2(q.fake_answer2);
                setAnswer3(q.fake_answer1);
            }
        }
    }

    private void setAnswer1(int answer) {
        TextView t = (TextView) findViewById(R.id.answer1Text);
        if (t != null) {
            t.setText(""+answer);
        }
    }

    private void setAnswer2(int answer) {
        TextView t = (TextView) findViewById(R.id.answer2Text);
        if (t != null) {
            t.setText(""+answer);
        }
    }

    private void setAnswer3(int answer) {
        TextView t = (TextView) findViewById(R.id.answer3Text);
        if (t != null) {
            t.setText(""+answer);
        }
    }

    private void setAnswer4(int answer) {
        TextView t = (TextView) findViewById(R.id.answer4Text);
        if (t != null) {
            t.setText(""+answer);
        }
    }

    private void setStreak() {
        TextView tv1 = (TextView) findViewById(R.id.streakText);
        if (tv1 != null) {
            tv1.setText("Current Streak: " + streak);
        }
        TextView tv2 = (TextView) findViewById(R.id.previousStreakText);
        if (tv2 != null) {
            tv2.setText("Previous Streak: " + previous_best_streak);
        }
    }

    public void answer1ButtonPressed(View v) {
        if (timerDone) {
            return;
        }
        if (real_answer == 1) {
            correctAnswer();
        } else {
            incorrectAnswer(1);
        }
    }

    public void answer2ButtonPressed(View v) {
        if (timerDone) {
            return;
        }
        if (real_answer == 2) {
            correctAnswer();
        } else {
            incorrectAnswer(2);
        }
    }

    public void answer3ButtonPressed(View v) {
        if (timerDone) {
            return;
        }
        if (real_answer == 3) {
            correctAnswer();
        } else {
            incorrectAnswer(3);
        }
    }

    public void answer4ButtonPressed(View v) {
        if (timerDone) {
            return;
        }
        if (real_answer == 4) {
            correctAnswer();
        } else {
            incorrectAnswer(4);
        }
    }

    public void correctAnswer() {
        cdt.cancel();
        //TODO make a toast saying correct, should be discrete but also inform player that they did good
        newGame(1);
    }

    public void incorrectAnswer(int answer) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Incorrect Answer!");
        String wrong_answer = "";
        if (answer == 1) {
            TextView t = (TextView) findViewById(R.id.answer1Text);
            if (t != null) {
                wrong_answer = (String) t.getText();
            }
        } else if (answer == 2) {
            TextView t = (TextView) findViewById(R.id.answer2Text);
            if (t != null) {
                wrong_answer = (String) t.getText();
            }
        } else if (answer == 3) {
            TextView t = (TextView) findViewById(R.id.answer3Text);
            if (t != null) {
                wrong_answer = (String) t.getText();
            }
        } else {
            TextView t = (TextView) findViewById(R.id.answer4Text);
            if (t != null) {
                wrong_answer = (String) t.getText();
            }
        }
        if (mode == 0 || mode == 1 || mode == 2 || mode == 3) {
            alert.setMessage("Your Answer: " + wrong_answer + "\nCorrect Answer: " + q.firstOperand + " x " + q.secondOperand +
                    " = " + q.result + "\nStreak: " + streak + "\nPrevious Best: " + previous_best_streak);
        } else if (mode == 4) {
            alert.setMessage("Your Answer: " + wrong_answer + "\nCorrect Answer: " + q.firstOperand + " % " + q.secondOperand +
                    " = " + q.result + "\nStreak: " + streak + "\nPrevious Best: " + previous_best_streak);
        } else if (mode == 5) {
            alert.setMessage("Your Answer: " + wrong_answer + "\nCorrect Answer: " + q.firstOperand + " ! = " + q.result + "\nStreak: " + streak
                    + "\nPrevious Best: " + previous_best_streak);
        }
        alert.setCancelable(false);
        alert.setNegativeButton("Back to Menu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                backToMenu();
            }
        });
        alert.setPositiveButton("Next Question", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                newGame(0);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
        cdt.cancel();
    }

    public void outOfTime() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Out of Time!");
        if (mode == 0 || mode == 1 || mode == 2 || mode == 3) {
            alert.setMessage(q.firstOperand + " x " + q.secondOperand + " = " + q.result + "\nStreak: " + streak
                    + "\nPrevious Best: " + previous_best_streak);
        } else if (mode == 4) {
            alert.setMessage(q.firstOperand + " % " + q.secondOperand + " = " + q.result + "\nStreak: " + streak
                    + "\nPrevious Best: " + previous_best_streak);
        } else if (mode == 5) {
            alert.setMessage(q.firstOperand + " ! = " + q.result + "\nStreak: " + streak
                    + "\nPrevious Best: " + previous_best_streak);
        }
        alert.setCancelable(false);
        alert.setNegativeButton("Back to Menu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                backToMenu();
            }
        });
        alert.setPositiveButton("Next Question", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                newGame(0);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
        cdt.cancel();
    }

    public void backToMenu() {
        cdt.cancel();
        if (streak > previous_best_streak) {
            newHighScore();
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void newGame(int correct) {
        Intent intent = new Intent(this, GameActivity.class);
        if (correct == 1) {
            intent.putExtra("streak", streak+1);
        } else {
            if (streak > previous_best_streak) {
                newHighScore();
            }
            intent.putExtra("streak", 0);
        }
        intent.putExtra("mode", mode);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        backToMenu();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            backToMenu();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void newHighScore() {
        SharedPreferences.Editor editor = sharedPref.edit();
        switch (mode) {
            case 0:
                editor.putInt(getString(R.string.basicMultiHighScore), streak);
                break;
            case 1:
                editor.putInt(getString(R.string.advancedMultiHighScore), streak);
                break;
            case 2:
                editor.putInt(getString(R.string.expertMultiHighScore), streak);
                break;
            case 3:
                editor.putInt(getString(R.string.squaresHighScore), streak);
                break;
            case 4:
                editor.putInt(getString(R.string.moduloHighScore), streak);
                break;
            case 5:
                editor.putInt(getString(R.string.factorialHighScore), streak);
        }
        editor.apply();
    }

    public void setProgressBar() {
        pb = (ProgressBar) findViewById(R.id.timeLimitBar);
        if (pb != null) {
            pb.setMax(time_limit/100);
            pb.setScaleY(2f);
            pb.setProgress(time_passed);
        }
        tv = (TextView) findViewById(R.id.timeLeftText);
        if (tv != null) {
            tv.setText("Time Left: " + (time_limit/1000+1));
        }
        cdt = new CountDownTimer(time_limit, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv.setText("Time Left: " + (millisUntilFinished/1000+1));
                time_passed++;
                pb.setProgress(time_passed);
            }
            @Override
            public void onFinish() {
                timerDone = true;
                tv.setText("Time Left: 0");
                outOfTime();
                time_passed++;
                pb.setProgress(time_passed);
            }
        };
        cdt.start();
    }
}
