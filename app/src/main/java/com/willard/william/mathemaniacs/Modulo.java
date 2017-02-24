package com.willard.william.mathemaniacs;

/**
 * Created by William on 2/24/2017.
 */

public class Modulo extends Question {

    public Modulo() {
        super();
        super.setMode(4);
        super.setTime_limit(7500); //in milliseconds
        super.setOperation(1); //modulo
        super.setFirstOperand(getLargeModuloNumber()); //range 1-100
        super.setSecondOperand(getBasicNumber()+3); //range 4-13
        super.setResult(firstOperand%secondOperand);
        super.setBlank(2);
        super.setFakeAnswer1(-1);
        super.setFakeAnswer2(-1);
        super.setFakeAnswer3(-1);
        super.setRealAnswer(result);
        super.setFakeAnswer1(findFakeModuloAnswer());
        super.setFakeAnswer2(findFakeModuloAnswer());
        super.setFakeAnswer3(findFakeModuloAnswer());
    }

    // picks a number between 1 and 100 from uniform probability
    private int getLargeModuloNumber() {
        return (int)(Math.random()*100)+1;
    }

    private int findFakeModuloAnswer() {
        int fake = -1;
        while (fake < 0 || fake >= secondOperand || fake == real_answer || fake == fake_answer1 || fake == fake_answer2 || fake == fake_answer3) {
            int offset = (int) (Math.random()*7)-3;
            fake = real_answer+offset;
        }
        return fake;
    }

}
