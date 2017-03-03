package com.willard.william.mathemaniacs;

/**
 * Basic Multiplication class. Extends parent class Question.
 * Creates a basic multiplication question for the game activity.
 */

class BasicMultiplication extends Question {

    BasicMultiplication(int difficulty) {
        super();
        super.setMode(0);
        super.setTime_limit(0);
        switch(difficulty) {
            case 0:
                super.setTime_limit(10000); //easy -> 10 seconds
                break;
            case 1:
                super.setTime_limit(3000); //normal -> 3 seconds
                break;
            case 2:
                super.setTime_limit(2000); //hard -> 2 seconds
        }
        super.setOperation(0); //multiply
        super.setFirstOperand(getBasicNumber()); //range 1-10
        super.setSecondOperand(getBasicNumber()); //range 1-10
        super.setResult(firstOperand*secondOperand);
        super.setBlank(chooseBlank());
        super.setFakeAnswer1(0);
        super.setFakeAnswer2(0);
        super.setFakeAnswer3(0);
        if (blank == 0) {
            super.setRealAnswer(firstOperand);
            super.setFakeAnswer1(findFakeOperandInterval(7));
            super.setFakeAnswer2(findFakeOperandInterval(7));
            super.setFakeAnswer3(findFakeOperandInterval(7));
        } else if (blank == 1) {
            super.setRealAnswer(secondOperand);
            super.setFakeAnswer1(findFakeOperandInterval(7));
            super.setFakeAnswer2(findFakeOperandInterval(7));
            super.setFakeAnswer3(findFakeOperandInterval(7));
        } else {
            super.setRealAnswer(result);
            super.setFakeAnswer1(findFakeFirstOperand());
            super.setFakeAnswer2(findFakeSecondOperand());
            super.setFakeAnswer3(findFakeResultInterval(7));
        }
    }

}
