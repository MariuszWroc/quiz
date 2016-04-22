/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence.impl;

import javax.ejb.Stateless;

import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.persistence.AbstractDao;
import pl.myproject.quiz.persistence.IQuestionDao;

import static pl.myproject.quiz.util.constant.ApplicationStrings.*;
/**
 *
 * @author Mariusz Czarny
 */
@Stateless
public class QuestionDao extends AbstractDao<Question> implements IQuestionDao{
            
    @Override
    public String choosePathForFile() {
        String pathfile = DEFAULT_PATH.getName().concat(CATALOG_QUESTION.getName());

        return pathfile;
    }
    
}
