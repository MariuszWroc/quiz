/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import pl.myproject.quiz.model.ApplicationSetting;

/**
 *
 * @author Mariusz Czarny
 */
@Named
@RequestScoped
public class SettingController implements Serializable{
    private static final Logger LOGGER = Logger.getLogger(SettingController.class.getName());
	private static final long serialVersionUID = 1L;
	private static final String ACCEPT_CHANGES = "Zmiany zostały";
    @Inject
    private ApplicationSetting setting;
     
    public SettingController() {
    }
    
    @PostConstruct
    public void init() {
        LOGGER.info(setting.toString());
    }

    public ApplicationSetting getSetting() {
        LOGGER.info(setting.toString());
        return setting;
    }

    public void setSetting(ApplicationSetting setting) {
        LOGGER.info(setting.toString());
        this.setting = setting;
    }

    public void buttonAction(ActionEvent actionEvent) {
        addMessage(ACCEPT_CHANGES);
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
