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
import pl.myproject.quiz.model.User;
import pl.myproject.quiz.service.IGameService;
import pl.myproject.quiz.service.IQuestionPoolService;
import pl.myproject.quiz.service.IUserService;
import pl.myproject.quiz.service.impl.QuestionPoolService;
import pl.myproject.quiz.service.impl.UserService;

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
    private String validAnswer;
    private String questionDescription;
    private String firstname;
    private String lastname;
    private String email;
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
    @Inject
    private IUserService userService;
    @Inject
    private IGameService gameService;

    public QuizController() {
        questionDescription = "";
        validAnswer = "";
        questionCounter = 0;
        score = 0;
        questionList = new ArrayList<>();
        answerMap = new LinkedHashMap<>();
        questionPool = new ArrayList<>();
        questionSet = new LinkedHashSet<>();
        poolService = new QuestionPoolService();
        userService = new UserService();
        LOGGER.info("questionCounter " + questionCounter);
    }

    @PostConstruct
    public void init() {
        questionSet = poolService.getQuestionPool(POOL_SIZE);
        questionPool.addAll(questionSet);
        questionPool.forEach(p -> LOGGER.info(p.toString()));
        prepareView();
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

    private void checkPoints(boolean answerCorrect) {
    	if (answerCorrect) {
    		score++;
    	}
    }

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	   
    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            LOGGER.info("page nr " + questionCounter + ", answerMap toString " + answerMap.toString() + " validAnswer " + validAnswer);
            questionCounter++;
            Boolean answerValue = answerMap.get(validAnswer);
            if (answerValue != null) {
            	checkPoints(answerValue);
            } else {
            	LOGGER.warning("Answer Value is null");
            }
			
            LOGGER.info("actual score is" + score);
            prepareView();
            return event.getNewStep();
        }
    }
    
    public String saveResult() {
    	User user = userService.getUser(getUserId());
        if(user != null) {
        	gameService.saveGameResult(user, getScore());
        	LOGGER.info("Quiz result saved");
        } else {
        	LOGGER.warning("Quiz result is NOT saved. User propably not exist");
        }
        return "index?faces-redirect=true";
    }
    
    public void onTimeout(){  
        LOGGER.info("time out");
    }

    public Integer getScore() {
        Integer score = (Integer) FacesContext.getCurrentInstance().getExternalContext().getFlash()
			.get("score");
        if (score == null) {
        	return 0;
        } else  {
        	return score;
        }
    }
    
    public Integer getUserId() {
        Integer userId = (Integer) FacesContext.getCurrentInstance().getExternalContext().getFlash()
			.get("userId");
        if (userId == null) {
        	LOGGER.warning("Id from flash scope is null");
        } 
        
		return userId;
    }
    
    public String saveUser() {
        LOGGER.info("User saved");
        Integer userId = userService.addUserAndReturnId(firstname, lastname, email);
        FacesContext.getCurrentInstance().getExternalContext().getFlash()
			.put("userId", userId);
        userService.getUserList().forEach(p -> LOGGER.info("User is " + p.toString()));
        return "quiz?faces-redirect=true";
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
                LOGGER.info("quiz.controller.QuizController.parseAnswersToList() -> there is no answer description");
            }
        }

        return answerParseList;
    }
    
    private Map<String, Boolean> parseAnswersToMap(List<Answer> answerToParse) {
    	Map<String, Boolean> answerMap = new LinkedHashMap<>();
        for (Answer record : answerToParse) {
            if (record.getDescription() != null) {
            	answerMap.put(record.getDescription(), record.isCorrect());
            	setValidAnswer(record);
            } else {
                LOGGER.info("quiz.controller.QuizController.parseAnswersToMap() -> there is no answer description");
            }
        }

        return answerMap;
    }

	private void setValidAnswer(Answer record) {
		if (record.isCorrect()) {
			validAnswer = record.getDescription();
		}
	}

    private void prepareView() {
        LOGGER.info("counter is " + questionCounter + ", size is " + POOL_SIZE);
        if (questionCounter < POOL_SIZE) {
            final Question selectQuestion = questionPool.get(questionCounter);
            if (selectQuestion != null) {
                questionList = parseQuestionsToList(questionPool);
                answerList = parseAnswersToList(selectQuestion.getAnswerList());
                questionDescription = selectQuestion.getDescription();
                answerMap = parseAnswersToMap(selectQuestion.getAnswerList());
            }
        } else if (questionCounter == 10){
            questionCounter = 0;
            LOGGER.info("last page");
            FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("score", score);
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("result.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
            }
            LOGGER.info("end of quiz ");
        }

    }
	
}
