/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.util;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Singleton;

/**
 *
 * @author Mariusz Czarny
 */
@Singleton
@Startup
public final class LoadData {
    @PostConstruct
    private void postConstruct() {}
}
