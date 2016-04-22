/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence.impl;

import javax.ejb.Stateless;

import pl.myproject.quiz.model.ApplicationSetting;
import pl.myproject.quiz.persistence.AbstractDao;
import pl.myproject.quiz.persistence.ISettingDao;

import static pl.myproject.quiz.util.constant.ApplicationStrings.*;
/**
 *
 * @author Mariusz Czarny
 */
@Stateless
public class SettingDao extends AbstractDao<ApplicationSetting> implements ISettingDao{
    @Override
    public String choosePathForFile() {
        String pathfile = DEFAULT_PATH.getName().concat(CATALOG_SETTING.getName());

        return pathfile;
    }

}
