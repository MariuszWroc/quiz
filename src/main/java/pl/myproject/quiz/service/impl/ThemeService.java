/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Singleton;

import pl.myproject.quiz.model.Theme;
import pl.myproject.quiz.service.IThemeService;

/**
 *
 * @author Mariusz Czarny
 */
@Singleton
@Startup
public class ThemeService implements IThemeService {
    private Map<String, Theme> themes;

    @PostConstruct
    public void init() {
        themes = new TreeMap<String, Theme>();
        themes.put("Aristo", new Theme("aristo"));
        themes.put("Black-Tie", new Theme("black-tie"));
        themes.put("Blitzer", new Theme("blitzer"));
        themes.put("Bluesky", new Theme("bluesky"));
        themes.put("Casablanca", new Theme("casablanca"));
        themes.put("Cupertino", new Theme("cupertino"));
        themes.put("Dark-Hive", new Theme("dark-hive"));
        themes.put("Dot-Luv", new Theme("dot-luv"));
        themes.put("Eggplant", new Theme("eggplant"));
        themes.put("Excite-Bike", new Theme("excite-bike"));
        themes.put("Flick", new Theme("flick"));
        themes.put("Glass-X", new Theme("glass-x"));
        themes.put("Hot-Sneaks", new Theme("hot-sneaks"));
        themes.put("Humanity", new Theme("humanity"));
        themes.put("Le-Frog", new Theme("le-frog"));
        themes.put("Midnight", new Theme("midnight"));
        themes.put("Mint-Choc", new Theme("mint-choc"));
        themes.put("Overcast", new Theme("overcast"));
        themes.put("Pepper-Grinder", new Theme("pepper-grinder"));
        themes.put("Redmond", new Theme("redmond"));
        themes.put("Rocket", new Theme("rocket"));
        themes.put("Sam", new Theme("sam"));
        themes.put("Smoothness", new Theme("smoothness"));
        themes.put("South-Street", new Theme("south-street"));
        themes.put("Start", new Theme("start"));
        themes.put("Sunny", new Theme("sunny"));
        themes.put("Swanky-Purse", new Theme("swanky-purse"));
        themes.put("Trontastic", new Theme("trontastic"));
        themes.put("UI-Darkness", new Theme("ui-darkness"));
        themes.put("UI-Lightness", new Theme("ui-lightness"));
        themes.put("Vader", new Theme("vader"));
    }

    @Override
    public Map<String, Theme> getThemes() {
        return themes;
    }

}
