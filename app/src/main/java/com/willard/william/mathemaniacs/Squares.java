package com.willard.william.mathemaniacs;

/**
 * Squares class. Extends parent class Question.
 * Creates a squares question for the game activity.
 */

class Squares extends Question {

    Squares(int difficulty) {
        super();
        super.setMode(3);
        super.setTime_limit(0);
        switch(difficulty) {
            case 0:
                super.setTime_limit(10000); //easy -> 10 seconds
                break;
            case 1:
                super.setTime_limit(5000); //normal -> 5 seconds
                break;
            case 2:
                super.setTime_limit(3000); //hard -> 3 seconds
        }
        super.setOperation(0); //multiply
        super.setFirstOperand(getSquaresNumber()); //range 1-13
        super.setSecondOperand(firstOperand);
        super.setResult(firstOperand*secondOperand);
        super.setBlank(2);
        super.setFakeAnswer1(0);
        super.setFakeAnswer2(0);
        super.setFakeAnswer3(0);
        super.setRealAnswer(result);
        super.setFakeAnswer1(findFakeSquare());
        super.setFakeAnswer2(findFakeSquare());
        super.setFakeAnswer3(findFakeSquare());
    }

    // picks a number between 1 and 25 from uniform probability
    private int getSquaresNumber() {
        return (int)(Math.random()*25)+1;
    }

    // picks a square that isn't the result that is close to result
    private int findFakeSquare() {
        int fake = 0;
        while (fake < 1 || fake == real_answer || fake == fake_answer1 || fake == fake_answer2 || fake == fake_answer3) {
            int offset = (int)(Math.random()*7)-3;
            fake = (firstOperand+offset)*(secondOperand+offset);
        }
        return fake;
    }
}
