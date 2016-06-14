/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.model;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.xml.bind.annotation.XmlRootElement;

import static pl.myproject.quiz.util.constant.ApplicationValues.*;

/**
 *
 * @author Mariusz Czarny
 */

@XmlRootElement
@ApplicationScoped
public class ApplicationSetting implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer questionPoolSize;
    private Integer timeForAnswer;
    private String personalEmail;

    public ApplicationSetting() {
        this.questionPoolSize = DEFAULT_QUIZ_POOL_SIZE.getNumber();
        this.timeForAnswer = DEFAULT_TIME_FOR_ANSWER.getNumber();
    }

    public Integer getQuestionPoolSize() {
        return questionPoolSize;
    }

    public void setQuestionPoolSize(Integer questionPoolSize) {
        this.questionPoolSize = questionPoolSize;
    }

    public Integer getTimeForAnswer() {
        return timeForAnswer;
    }

    public void setTimeForAnswer(Integer timeForAnswer) {
        this.timeForAnswer = timeForAnswer;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    @Override
    public String toString() {
        return "Settings{" + "questionPoolSize=" + questionPoolSize + ", answersNumberPerQuestion=" + timeForAnswer + '}';
    }

}
