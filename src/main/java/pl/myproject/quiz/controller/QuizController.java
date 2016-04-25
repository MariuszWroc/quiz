/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.FlowEvent;

import pl.myproject.quiz.model.Answer;
import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.service.IQuestionPoolService;
import pl.myproject.quiz.service.impl.QuestionPoolService;

/**
 *
 * @author Mariusz Czarny
 */
@ViewScoped
@ManagedBean(eager=true)
public class QuizController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(QuizController.class.getName());
    private static final int POOL_SIZE = 10;
    private String selectedAnswer;
    private String questionDescription;
    private List<String> questionList;
    private List<String> answerList;
    private Map<String, Boolean> answerMap;
    private boolean skip;
    private Integer questionCounter;
    private List<Question> questionPool;
    private Set<Question> questionSet;
    private Integer score;
    @Inject
    private IQuestionPoolService poolService;

    public QuizController() {
        questionDescription = "";
        selectedAnswer = "";
        questionCounter = 0;
        score = 0;
        questionList = new ArrayList<>();
        answerMap = new LinkedHashMap<>();
        questionPool = new ArrayList<>();
        questionSet = new LinkedHashSet<>();
        poolService = new QuestionPoolService();
        LOGGER.info("questionCounter " + questionCounter);
    }

    @PostConstruct
    public void init() {
        questionSet = poolService.getQuestionPool(POOL_SIZE);
        questionPool.addAll(questionSet);
        questionPool.forEach(p -> LOGGER.info(p.toString()));
        prepareView();
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public List<String> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<String> questionList) {
        this.questionList = questionList;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public Map<String, Boolean> getAnswerMap() {
        return answerMap;
    }

    public void setAnswerMap(Map<String, Boolean> answerMap) {
        this.answerMap = answerMap;
    }

    public List<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<String> answerList) {
        this.answerList = answerList;
    }

    public Integer getQuestionCounter() {
        return questionCounter;
    }
    
    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            LOGGER.info("page nr " + questionCounter);
            questionCounter++;
            checkPoints();
            prepareView();
            return event.getNewStep();
        }
    }

    public String saveResult() {
        LOGGER.info("Quiz result saved");
        return "result?faces-redirect=true";
    }
    
    public void onTimeout(){  
        LOGGER.info("time out");
    }

    public Integer getScore() {
        return score;
    }
    
    private List<String> parseQuestionsToList(List<Question> questionsToParse) {
        List<String> questionParseList = new ArrayList<>();
        for (Question record : questionsToParse) {
            if (record.getDescription() != null) {
                questionParseList.add(record.getDescription());
            } else {
                LOGGER.info("quiz.controller.QuizController.parseQuestionsToList() -> there is no question description");
            }
        }

        return questionParseList;
    }

    private List<String> parseAnswersToList(List<Answer> answerToParse) {
        List<String> answerParseList = new ArrayList<>();
        for (Answer record : answerToParse) {
            if (record.getDescription() != null) {
                answerParseList.add(record.getDescription());
            } else {
                LOGGER.info("quiz.controller.QuizController.parseQuestionsToList() -> there is no answer description");
            }
        }

        return answerParseList;
    }

    private void prepareView() {
        LOGGER.info("counter is " + questionCounter + ", size is " + POOL_SIZE);
        if (questionCounter < POOL_SIZE) {
            final Question selectQuestion = questionPool.get(questionCounter);
            if (selectQuestion != null) {
                questionList = parseQuestionsToList(questionPool);
                answerList = parseAnswersToList(selectQuestion.getAnswerList());
                questionDescription = selectQuestion.getDescription();
            }
        } else if (questionCounter == 10){
            questionCounter = 0;
            LOGGER.info("last page");
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("result.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
            }
            LOGGER.info("end of quiz ");
        }

    }

    private void checkPoints() {
        score++;
    }
}
