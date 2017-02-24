package com.willard.william.mathemaniacs;

import android.util.Log;

import java.util.Random;

/**
 * Created by William on 2/21/2017.
 */

public abstract class Question {

    int mode;
    int firstOperand;
    int secondOperand;
    int operation;
    int result;
    int real_answer;
    int fake_answer1;
    int fake_answer2;
    int fake_answer3;
    int time_limit;
    int blank;

    Question() { }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setFirstOperand(int operand) {
        this.firstOperand = operand;
    }

    public void setSecondOperand(int operand) {
        this.secondOperand = operand;
    }

    public void setOperation(int op) {
        this.operation = op;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setRealAnswer(int answer) {
        this.real_answer = answer;
    }

    public void setFakeAnswer1(int answer) {
        this.fake_answer1 = answer;
    }

    public void setFakeAnswer2(int answer) {
        this.fake_answer2 = answer;
    }

    public void setFakeAnswer3(int answer) {
        this.fake_answer3 = answer;
    }

    public void setTime_limit(int time) {
        this.time_limit = time;
    }

    public void setBlank(int blank) {
        this.blank = blank;
    }

    //finds a random fake answer for operand blanks on the interval
    public int findFakeOperandInterval(int interval) {
        int fake = 0;
        while (fake < 1 || fake == real_answer || fake == fake_answer1 || fake == fake_answer2 || fake == fake_answer3) {
            int rand = (int)(Math.random()*interval)-(interval/2);
            fake = real_answer+rand;
            if (mode == 0 && fake > 10) {
                fake = 0;
            }
        }
        return fake;
    }

    //finds a random fake answer for result blanks on the interval
    public int findFakeResultInterval(int interval) {
        int fake = 0;
        while (fake < 1 || fake == real_answer || fake == fake_answer1 || fake == fake_answer2 || fake == fake_answer3) {
            int rand = (int)(Math.random()*interval)-(interval/2);
            fake = real_answer+rand;
        }
        return fake;
    }

    //finds a fake answer + or - first operand for result blanks
    public int findFakeFirstOperand() {
        int fake = 0;
        while (fake < 1 || fake == real_answer || fake == fake_answer1 || fake == fake_answer2 || fake == fake_answer3) {
            double rand = Math.random();
            if (rand < .5) {
                fake = real_answer - firstOperand;
            } else {
                fake = real_answer + firstOperand;
            }
        }
        return fake;
    }

    //finds a fake answer + or - seconds operand for result blanks
    public int findFakeSecondOperand() {
        int fake = 0;
        while (fake < 1 || fake == real_answer || fake == fake_answer1 || fake == fake_answer2 || fake == fake_answer3) {
            double rand = Math.random();
            if (rand < .5) {
                fake = real_answer - secondOperand;
            } else {
                fake = real_answer + secondOperand;
            }
        }
        return fake;
    }

    // picks a blank(0->first operand, 1->second operand, 2->result) from non-uniform probability
    public int chooseBlank() {
        // table of probabilities:  x   0   1   2
        //                          p   .2  .2  .6
        double rand = Math.random();
        int blank_position;
        if (rand < .6) {
            blank_position = 2;
        } else if (rand < .8) {
            blank_position = 1;
        } else {
            blank_position = 0;
        }
        return blank_position;
    }

    //picks number between 1 and 10 from non-uniform probability
    public int getBasicNumber() {
        // table of probabilities:  x   1   2   3   4   5   6   7   8   9   10
        //                          p   .06 .11 .11 .11 .11 .11 .11 .11 .11 .06
        double rand = Math.random();
        int random_number;
        if (rand < .06) {
            random_number = 1;
        } else if (rand < .17) {
            random_number = 2;
        } else if (rand < .28) {
            random_number = 3;
        } else if (rand < .39) {
            random_number = 4;
        } else if (rand < .50) {
            random_number = 5;
        } else if (rand < .61) {
            random_number = 6;
        } else if (rand < .72) {
            random_number = 7;
        } else if (rand < .83) {
            random_number = 8;
        } else if (rand < .94) {
            random_number = 9;
        } else {
            random_number = 10;
        }
        return random_number;
    }

}
