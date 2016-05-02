package pl.myproject.quiz.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import pl.myproject.quiz.model.User;
import pl.myproject.quiz.service.IUserService;

@Singleton
public class UserService implements IUserService{
	private static List<User> userList;
	
	@PostConstruct
	public void init() {
		userList = new LinkedList<User>();
	}

	@Override
	public void addUser(String firstname, String lastname, String email) {
		addAndReturnUser(firstname, lastname, email);
	}

	@Override
	public User getUser(Integer id) {
		User user = userList.get(id);
		if (user != null) {
			return user;
		} else {
			return new User();
		}
	}
	
	@Override
	public User addAndReturnUser(String firstname, String lastname, String email) {
		User user = new User(generateId(), firstname, lastname, email);
		userList.add(user);
		return user;
	}
	
	@Override
	public List<User> getUserList() {
		return userList;
	}
	
	@Override
	public Integer addUserAndReturnId(String firstname, String lastname, String email) {
		User user = addAndReturnUser(firstname, lastname, email);
		return user.getId();
	}
	
	private static Integer generateId() {
		if (userList != null) {
			return userList.size();
		} else {
			return 0;
		}
	}

}
