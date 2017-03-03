package com.willard.william.mathemaniacs;

/**
 * Expert Multiplication class. Extends parent class Question.
 * Creates an expert multiplication question for the game activity.
 */

class ExpertMultiplication extends Question {

    ExpertMultiplication(int difficulty) {
        super();
        super.setMode(2);
        super.setTime_limit(0);
        switch(difficulty) {
            case 0:
                super.setTime_limit(20000); //easy -> 20 seconds
                break;
            case 1:
                super.setTime_limit(10000); //normal -> 10 seconds
                break;
            case 2:
                super.setTime_limit(6000); //hard -> 6 seconds
        }
        super.setOperation(0); //multiply
        super.setFirstOperand(getBasicNumber()+2); //range: 3-12
        super.setSecondOperand(getExpertNumber()); //range: 31-50
        super.setResult(firstOperand*secondOperand);
        super.setBlank(chooseBlank());
        super.setFakeAnswer1(0);
        super.setFakeAnswer2(0);
        super.setFakeAnswer3(0);
        if (blank == 0) {
            super.setRealAnswer(firstOperand);
            super.setFakeAnswer1(findFakeOperandInterval(15));
            super.setFakeAnswer2(findFakeOperandInterval(15));
            super.setFakeAnswer3(findFakeOperandInterval(15));
        } else if (blank == 1) {
            super.setRealAnswer(secondOperand);
            super.setFakeAnswer1(findFakeOperandInterval(15));
            super.setFakeAnswer2(findFakeOperandInterval(15));
            super.setFakeAnswer3(findFakeOperandInterval(15));
        } else {
            super.setRealAnswer(result);
            super.setFakeAnswer1(findFakeFirstOperand());
            super.setFakeAnswer2(findFakeSecondOperand());
            super.setFakeAnswer3(findFakeResultInterval(15));
        }
    }

    // picks number between 31 and 50 from uniform probability
    private int getExpertNumber() {
        // table of probabilities:  x   31-40   41-50
        //                          p   .50     .50
        double rand = Math.random();
        double rand2 = Math.random();
        int random_number;
        if (rand < .5) {
            if (rand2 < .1) {
                random_number = 31;
            } else if (rand2 < .2) {
                random_number = 32;
            } else if (rand2 < .3) {
                random_number = 33;
            } else if (rand2 < .4) {
                random_number = 34;
            } else if (rand2 < .5) {
                random_number = 35;
            } else if (rand2 < .6) {
                random_number = 36;
            } else if (rand2 < .7) {
                random_number = 37;
            } else if (rand2 < .8) {
                random_number = 38;
            } else if (rand2 < .9) {
                random_number = 39;
            } else {
                random_number = 40;
            }
        } else {
            if (rand2 < .1) {
                random_number = 41;
            } else if (rand2 < .2) {
                random_number = 42;
            } else if (rand2 < .3) {
                random_number = 43;
            } else if (rand2 < .4) {
                random_number = 44;
            } else if (rand2 < .5) {
                random_number = 45;
            } else if (rand2 < .6) {
                random_number = 46;
            } else if (rand2 < .7) {
                random_number = 47;
            } else if (rand2 < .8) {
                random_number = 48;
            } else if (rand2 < .9) {
                random_number = 49;
            } else {
                random_number = 50;
            }
        }
        return random_number;
    }

}
