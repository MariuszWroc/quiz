/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service;

import java.util.Set;

import javax.ejb.Local;

import pl.myproject.quiz.model.Question;

/**
 *
 * @author Mariusz Czarny
 */
@Local
public interface IQuestionPoolService {
  /**
     *
     * @param size
     * @return
     */
	public Set<Question> getQuestionPool(int size);

}
