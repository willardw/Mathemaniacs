package com.willard.william.mathemaniacs;

/**
 * Factorial class. Extends parent class Question.
 * Creates a factorial question for the game activity.
 */

class Factorial extends Question {

    Factorial() {
        super();
        super.setMode(5);
        super.setTime_limit(5000); //in milliseconds
        super.setOperation(2); //factorial
        super.setFirstOperand(getFactorialNumber()); //range 1-10
        super.setSecondOperand(0);
        super.setResult(factorial(firstOperand));
        super.setBlank(2);
        super.setFakeAnswer1(0);
        super.setFakeAnswer2(0);
        super.setFakeAnswer3(0);
        super.setRealAnswer(result);
        super.setFakeAnswer1(findFakeResultInterval(15));
        super.setFakeAnswer2(findFakeResultInterval(15));
        super.setFakeAnswer3(findFakeResultInterval(15));
    }

    // picks a number between 1 and 8 from uniform probability
    private int getFactorialNumber() {
       return (int) (Math.random()*8)+1;
    }

    private int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n*(factorial(n-1));
    }
    //TODO remove this method if we never end up using it (highly likely)
    /**
    private int findFakeFactorialAnswer() {
        int fake = 0;
        while (fake < 1 || fake == real_answer || fake == fake_answer1 || fake == fake_answer2 || fake == fake_answer3) {
            int offset = (int) (Math.random()*3)-1;
            fake = factorial(firstOperand+offset);
        }
        return fake;
    }
    */
}
