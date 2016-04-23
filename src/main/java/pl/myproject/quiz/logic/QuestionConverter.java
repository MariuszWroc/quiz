/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.logic;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import pl.myproject.quiz.model.Question;

/**
 *
 * @author Mariusz Czarny
 */
@FacesConverter(forClass=Question.class, value = "questionConverter")
public final class QuestionConverter implements Converter {

    @Override
public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
    if (modelValue == null) {
        return "";
    }

    if (modelValue instanceof Question) {
        return String.valueOf(((Question) modelValue).getId());
    } else {
        throw new ConverterException(new FacesMessage(modelValue + " is not a valid"));
    }
}

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
