/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.controller;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultUploadedFile;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Mariusz Czarny
 */
@RequestScoped
@Named
public class FileController implements Serializable {
	private static final long serialVersionUID = 1L;
	private UploadedFile file;

    public FileController() {
        this.file = new DefaultUploadedFile();
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
