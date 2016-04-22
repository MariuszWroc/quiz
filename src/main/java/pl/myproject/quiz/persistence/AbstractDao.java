/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.myproject.quiz.util.FileSearch;
import pl.myproject.quiz.util.StringWorker;

/**
 *
 * @author Mariusz Czarny
 * @param <T>
 */
public abstract class AbstractDao<T> extends AbstractDaoXml<T> implements IAbstractDao<T>, IPathChooseStrategy {
	private static final Logger LOGGER = Logger.getLogger(AbstractDao.class.getName());
	
    @Override
    public void add(T entity, String path, String filename) {
        try {
            StringWorker<T> stringWorker = new StringWorker();
            String filePath = stringWorker.createDirectory(entity, path, filename);
            convertObjectToXML(entity, filePath);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(AbstractDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void add(T entity) {
        String path = choosePathForFile();
        String filename = "";
        add(entity, path, filename);
    }
    
    @Override
    public void add(T entity, Integer id) {
        String path = choosePathForFile();
        String filename = id.toString();
        add(entity, path, filename);
    }
    
    @Override
    public void update(T entity) {
        add(entity);
    }

    @Override
    public List<T> findAll() {
        File currentDirectory = new File("");
        List<T> entity = new ArrayList<>();
        final List<String> clientfiles = FileSearch.displayDirectoryContents(currentDirectory);
        
        return null;
    }

    @Override
    public T findById(Integer id, String prefix) {
        String filename = prefix.concat(id.toString());
        return findByName(filename);
    }

    private T findByName(String filename) {
        T entity = convertXMLToObject(choosePathForFile());
        if (entity != null) {
            return entity;
        } else {
            LOGGER.info("Can't find client{0}");
            return (T) new Object();
        }
    }

    @Override
    public void delete(Integer id, String prefix) {
        String filename = prefix.concat(id.toString());
        deleteXMLFile(choosePathForFile());
    }

}
