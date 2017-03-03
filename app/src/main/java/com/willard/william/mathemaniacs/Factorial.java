package com.willard.william.mathemaniacs;

/**
 * Factorial class. Extends parent class Question.
 * Creates a factorial question for the game activity.
 */

class Factorial extends Question {

    Factorial(int difficulty) {
        super();
        super.setMode(5);
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
        super.setOperation(2); //factorial
        super.setFirstOperand(getBasicNumber()); //range 1-10
        super.setSecondOperand(0);
        super.setResult(factorial(firstOperand));
        super.setBlank(2);
        super.setFakeAnswer1(0);
        super.setFakeAnswer2(0);
        super.setFakeAnswer3(0);
        super.setRealAnswer(result);
        super.setFakeAnswer1(findFakeFactorialAnswer());
        super.setFakeAnswer2(findFakeFactorialAnswer());
        super.setFakeAnswer3(findFakeFactorialAnswer());
    }

    private int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n*(factorial(n-1));
    }

    private int findFakeFactorialAnswer() {
        int fake = 0;
        while (fake < 1 || fake == real_answer || fake == fake_answer1 || fake == fake_answer2 || fake == fake_answer3) {
            int offset = (int) (Math.random()*7)-3;
            fake = factorial(firstOperand+offset);
        }
        return fake;
    }
}
