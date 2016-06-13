package pl.myproject.quiz.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pl.myproject.quiz.model.Game;
import pl.myproject.quiz.model.User;
import pl.myproject.quiz.service.IGameService;

/**
*
* @author Mariusz Czarny
*/
@SessionScoped
@Named
public class UserController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());
    private String firstname;
    private String lastname;
    private String email;
    @Inject
    private IGameService gameService;
    @Inject
    private QuizController quizController;

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
	
    public String goToQuiz() {
        LOGGER.info("User saved");
        return "quiz?faces-redirect=true";
    }
    
    public String saveResult() {
    	int score = quizController.getScore();
        User user = new User(firstname, lastname, email);
        gameService.saveGameResult(user, score);
        LOGGER.info("Quiz result saved " + user.toString() + " with score " + score);

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
	
}
