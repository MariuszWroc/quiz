/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import pl.myproject.quiz.model.Ranking;
import pl.myproject.quiz.service.IRankingService;
import pl.myproject.quiz.service.impl.RankingService;

/**
 *
 * @author Mariusz Czarny
 */
@RequestScoped
@Named
public class RankingController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String RANKING_SELECTED = "Pytanie zaznaczone";
    private static final String RANKING_UNSELECTED = "Pytanie odznaczone";
    private List<Ranking> rankingList;
    private Ranking selectedRanking;
    @Inject
    private IRankingService rankingService;

    public RankingController() {
        rankingService = new RankingService();
        rankingList = new ArrayList<>();
        selectedRanking = new Ranking();
    }
    
    @PostConstruct
    public void init() {
        this.rankingList = rankingService.getRankingList();
    }

    public List<Ranking> getRankingList() {
        return rankingList;
    }

    public void setRankingList(List<Ranking> rankingList) {
        this.rankingList = rankingList;
    }

    public Ranking getSelectedRanking() {
        return selectedRanking;
    }

    public void setSelectedRanking(Ranking selectedRanking) {
        this.selectedRanking = selectedRanking;
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage(RANKING_SELECTED, ((Ranking) event.getObject()).getDescription());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage(RANKING_UNSELECTED, ((Ranking) event.getObject()).getDescription());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Row Edited", ((Ranking) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Ranking) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
