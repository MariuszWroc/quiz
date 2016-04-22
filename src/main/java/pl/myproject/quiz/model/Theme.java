/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.model;

import java.util.Map;

import javax.faces.context.FacesContext;

import static pl.myproject.quiz.util.constant.ApplicationStrings.DEFAULT_THEME;

/**
 *
 * @author Mariusz Czarny
 */
public class Theme {
    private String name; //default

    public Theme(String name) {
        this.name = name;
    }
    
    public Theme() {
        this.name = DEFAULT_THEME.getName();
    }

    public String getName() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        if (params.containsKey("theme")) {
            name = params.get("theme");
        }

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
