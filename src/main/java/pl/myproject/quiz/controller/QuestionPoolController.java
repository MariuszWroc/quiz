/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import pl.myproject.quiz.model.Answer;
import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.service.IQuestionPoolService;

/**
 *
 * @author Mariusz Czarny
 */
@RequestScoped
@Named("questionController")
public class QuestionPoolController implements Serializable {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(QuestionPoolController.class.getName());        
	private static final String QUESTION_SELECTED = "Pytanie zaznaczone";
    private static final String QUESTION_UNSELECTED = "Pytanie odznaczone";
    private List<Question> questionList;
    private Question selectedQuestion;
    private Answer selectedAnswer;
    @Inject
    private IQuestionPoolService questionService;

    public QuestionPoolController() {
        questionList = new ArrayList<>();
        selectedQuestion = new Question();
        selectedAnswer = new Answer();
    }
    
    @PostConstruct
    public void init() {
        questionList = questionService.getQuestionPool();
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Question getSelectedQuestion() {
        return selectedQuestion;
    }

    public void setSelectedQuestion(Question selectedQuestion) {
        this.selectedQuestion = selectedQuestion;
    }

    public Answer getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(Answer selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage(QUESTION_SELECTED, ((Question) event.getObject()).getDescription());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage(QUESTION_UNSELECTED, ((Question) event.getObject()).getDescription());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Row Edited", ((Question) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Question) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    
}
