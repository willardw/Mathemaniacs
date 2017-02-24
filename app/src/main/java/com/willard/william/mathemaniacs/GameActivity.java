package com.willard.william.mathemaniacs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    int mode;
    Question q;
    int real_answer;
    int time_limit;
    ProgressBar pb;
    CountDownTimer cdt;
    int time_passed;
    boolean timerDone;
    int streak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mode = (int) getIntent().getSerializableExtra("mode");
        streak = (int) getIntent().getSerializableExtra("streak");
        setQuestion();
        setQuestionText();
        setAnswers();
        setStreak();
        time_limit = q.time_limit;
        time_passed = 0;
        timerDone = false;
        setProgressBar();
    }

    private void setQuestion() {
        switch (mode) {
            case 0:
                q = new BasicMultiplication();
                break;
            case 1:
                q = new AdvancedMultiplication();
                break;
            case 2:
                q = new ExpertMultiplication();
                break;
            case 3:
                q = new Squares();
                break;
            case 4:
                q = new Modulo();
                break;
            case 5:
                q = new Factorial();
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
        t.setText(question);
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
        Button b = (Button) findViewById(R.id.answer1Button);
        b.setText(""+answer);
    }

    private void setAnswer2(int answer) {
        Button b = (Button) findViewById(R.id.answer2Button);
        b.setText(""+answer);
    }

    private void setAnswer3(int answer) {
        Button b = (Button) findViewById(R.id.answer3Button);
        b.setText(""+answer);
    }

    private void setAnswer4(int answer) {
        Button b = (Button) findViewById(R.id.answer4Button);
        b.setText(""+answer);
    }

    private void setStreak() {
        TextView tv = (TextView) findViewById(R.id.streakText);
        tv.setText("Streak: "+streak);
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
        newGame(1);
    }

    public void incorrectAnswer(int answer) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Incorrect Answer!");
        String wrong_answer;
        if (answer == 1) {
            Button b = (Button) findViewById(R.id.answer1Button);
            wrong_answer = (String) b.getText();
        } else if (answer == 2) {
            Button b = (Button) findViewById(R.id.answer2Button);
            wrong_answer = (String) b.getText();
        } else if (answer == 3) {
            Button b = (Button) findViewById(R.id.answer3Button);
            wrong_answer = (String) b.getText();
        } else {
            Button b = (Button) findViewById(R.id.answer4Button);
            wrong_answer = (String) b.getText();
        }
        if (mode == 0 || mode == 1 || mode == 2 || mode == 3) {
            //TODO add best streak for current mode taken from database in message
            //Best Streak: x
            alert.setMessage("Your Answer: " + wrong_answer + "\nCorrect Answer: " + q.firstOperand + " x " + q.secondOperand +
                    " = " + q.result + "\nStreak: " + streak);
        } else if (mode == 4) {
            alert.setMessage("Your Answer: " + wrong_answer + "\nCorrect Answer: " + q.firstOperand + " % " + q.secondOperand +
                    " = " + q.result + "\nStreak: " + streak);
        } else if (mode == 5) {
            alert.setMessage("Your Answer: " + wrong_answer + "\nCorrect Answer: " + q.firstOperand + " ! = " + q.result + "\nStreak: " + streak);
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
            //TODO add best streak for current mode taken from database in message
            //Best Streak: x
            alert.setMessage(q.firstOperand + " x " + q.secondOperand + " = " + q.result + "\nStreak: " + streak);
        } else if (mode == 4) {
            alert.setMessage(q.firstOperand + " % " + q.secondOperand + " = " + q.result + "\nStreak: " + streak);
        } else if (mode == 5) {
            alert.setMessage(q.firstOperand + " ! = " + q.result + "\nStreak: " + streak);
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
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void newGame(int correct) {
        Intent intent = new Intent(this, GameActivity.class);
        if (correct == 1) {
            intent.putExtra("streak", streak+1);
        } else {
            intent.putExtra("streak", 0);
        }
        intent.putExtra("mode", mode);
        startActivity(intent);
        finish();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            backToMenu();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void setProgressBar() {
        pb = (ProgressBar) findViewById(R.id.timeLimitBar);
        pb.setMax(time_limit/100);
        pb.setProgress(time_passed);
        cdt = new CountDownTimer(time_limit, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                time_passed++;
                pb.setProgress(time_passed);
            }
            @Override
            public void onFinish() {
                timerDone = true;
                outOfTime();
                time_passed++;
                pb.setProgress(time_passed);
            }
        };
        cdt.start();
    }
}
