package pl.myproject.quiz.service;

import java.util.List;

import pl.myproject.quiz.model.User;

public interface IUserService {
	public void addUser(String firstname, String lastname, String email);
	public User addAndReturnUser(String firstname, String lastname, String email);
	public User getUser(Integer id);
	public List<User> getUserList();
	public Integer addUserAndReturnId(String firstname, String lastname, String email);
}
