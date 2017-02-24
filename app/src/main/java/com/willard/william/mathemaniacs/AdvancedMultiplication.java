package com.willard.william.mathemaniacs;

/**
 * Created by William on 2/24/2017.
 */

public class AdvancedMultiplication extends Question {

    public AdvancedMultiplication() {
        super();
        super.setMode(1);
        super.setTime_limit(7500); //in milliseconds
        super.setOperation(0); //multiply
        super.setFirstOperand(getBasicNumber()); //range 1-10
        super.setSecondOperand(getAdvancedNumber()); //range 11-30
        super.setResult(firstOperand*secondOperand);
        super.setBlank(chooseBlank());
        super.setFakeAnswer1(0);
        super.setFakeAnswer2(0);
        super.setFakeAnswer3(0);
        if (blank == 0) {
            super.setRealAnswer(firstOperand);
            super.setFakeAnswer1(findFakeOperandInterval(11));
            super.setFakeAnswer2(findFakeOperandInterval(11));
            super.setFakeAnswer3(findFakeOperandInterval(11));
        } else if (blank == 1) {
            super.setRealAnswer(secondOperand);
            super.setFakeAnswer1(findFakeOperandInterval(11));
            super.setFakeAnswer2(findFakeOperandInterval(11));
            super.setFakeAnswer3(findFakeOperandInterval(11));
        } else {
            //TODO make 1 fake answer smarter by having the same base digit as real answer
            super.setRealAnswer(result);
            super.setFakeAnswer1(findFakeFirstOperand());
            super.setFakeAnswer2(findFakeSecondOperand());
            super.setFakeAnswer3(findFakeResultInterval(11));
        }
    }

    // picks number between 11 and 30 from uniform probability
    public int getAdvancedNumber() {
        // table of probabilities:  x   11-20   21-30
        //                          p   .50     .50
        double rand = Math.random();
        double rand2 = Math.random();
        int random_number;
        if (rand < .5) {
            if (rand2 < .1) {
                random_number = 11;
            } else if (rand2 < .2) {
                random_number = 12;
            } else if (rand2 < .3) {
                random_number = 13;
            } else if (rand2 < .4) {
                random_number = 14;
            } else if (rand2 < .5) {
                random_number = 15;
            } else if (rand2 < .6) {
                random_number = 16;
            } else if (rand2 < .7) {
                random_number = 17;
            } else if (rand2 < .8) {
                random_number = 18;
            } else if (rand2 < .9) {
                random_number = 19;
            } else {
                random_number = 20;
            }
        } else {
            if (rand2 < .1) {
                random_number = 21;
            } else if (rand2 < .2) {
                random_number = 22;
            } else if (rand2 < .3) {
                random_number = 23;
            } else if (rand2 < .4) {
                random_number = 24;
            } else if (rand2 < .5) {
                random_number = 25;
            } else if (rand2 < .6) {
                random_number = 26;
            } else if (rand2 < .7) {
                random_number = 27;
            } else if (rand2 < .8) {
                random_number = 28;
            } else if (rand2 < .9) {
                random_number = 29;
            } else {
                random_number = 30;
            }
        }
        return random_number;
    }
}
