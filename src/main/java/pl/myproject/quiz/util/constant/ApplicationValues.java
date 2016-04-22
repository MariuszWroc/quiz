/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.util.constant;

/**
 *
 * @author Mariusz Czarny
 */
public enum ApplicationValues {
    DEFAULT_QUESTION_POOL_SIZE(50),
    DEFAULT_QUIZ_POOL_SIZE(10),
    DEFAULT_TIME_FOR_ANSWER(10),
    DEFAULT_ANSWER_POOL_SIZE(4),
    DEFAULT_STARTING_SCORE(0);

    private final int number;

    private ApplicationValues(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
