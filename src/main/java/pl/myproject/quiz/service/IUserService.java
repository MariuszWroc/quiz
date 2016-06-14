package pl.myproject.quiz.service;

import java.util.List;

import pl.myproject.quiz.model.User;

/**
 * @author mariusz
 *
 */
public interface IUserService {
	/**
	 * @param firstname
	 * @param lastname
	 * @param email
	 */
	public void addUser(String firstname, String lastname, String email);
	/**
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @return
	 */
	public User addAndReturnUser(String firstname, String lastname, String email);
	/**
	 * @param id
	 * @return
	 */
	public User getUser(Integer id);
	/**
	 * @return
	 */
	public List<User> getUserList();
	
	/**
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @return
	 */
	public Integer addUserAndReturnId(String firstname, String lastname, String email);
}
