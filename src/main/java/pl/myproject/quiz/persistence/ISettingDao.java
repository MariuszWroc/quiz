/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence;

import javax.ejb.Local;

import pl.myproject.quiz.model.ApplicationSetting;

/**
 *
 * @author Mariusz Czarny
 */
@Local
public interface ISettingDao extends IAbstractDao<ApplicationSetting>{
    
}
