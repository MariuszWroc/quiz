/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import pl.myproject.quiz.model.ApplicationSetting;
import pl.myproject.quiz.persistence.ISettingDao;
import pl.myproject.quiz.service.ISettingService;

/**
 *
 * @author Mariusz Czarny
 */
@Stateless
public class SettingService implements ISettingService{

    @Inject
    private ISettingDao dao;
    
    @PostConstruct
    public void init() {
    }
    
    @Override
    public ApplicationSetting getSetting() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSetting(ApplicationSetting setting) {
        dao.add(setting);
    }

}
