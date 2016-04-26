package pl.myproject.quiz.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pl.myproject.quiz.model.Game;
import pl.myproject.quiz.model.User;

@Deprecated
@ViewScoped
@ManagedBean(eager=true)
public class GameController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(GameController.class.getName());
	private Game game;
	private User user;
    private String firstname;
    private String lastname;
    private String email;
	
	public GameController() {
		user = new User();
		game = new Game();
	}
	
	@PostConstruct
	public void init() {
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
    public String saveUser() {
        LOGGER.info("User saved");
        return "quiz?faces-redirect=true";
    }
	
}
