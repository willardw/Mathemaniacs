package com.willard.william.mathemaniacs;

/**
 * Created by William on 2/24/2017.
 */

public class Squares extends Question {

    public Squares() {
        super();
        super.setMode(3);
        super.setTime_limit(3000); //in milliseconds
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

    // picks a number between 1 and 13 from uniform probability
    private int getSquaresNumber() {
        return (int)(Math.random()*13)+1;
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
