/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.util;

import java.util.logging.Logger;

/**
 *
 * @author Mariusz Czarny
 * @param <T>
 */
public class StringWorker<T> {
    private static final Logger LOGGER = Logger.getLogger(StringWorker.class.getName());
    private static final String EXTENSION = "xml";
    
    public String createDirectory(T entity, String directory) throws NoSuchMethodException {
        String filepathWithFilename = "";
        StringBuilder builder = new StringBuilder(filepathWithFilename);
        LOGGER.info("variables " + entity.toString() + " " + directory);
        builder
                .append(directory)
                .append("\\")
                .append(entity.getClass().getSimpleName().toLowerCase())
                .append("\\");

        filepathWithFilename = builder.toString();
        LOGGER.info(filepathWithFilename);

        return filepathWithFilename;
    }

    /**
     *
     * @param entity
     * @param path
     * @param filename
     * @return
     * @throws NoSuchMethodException
     */
    public String createDirectory(T entity, String path, String filename) throws NoSuchMethodException {
        String filepathWithFilename = "";
        StringBuilder builder = new StringBuilder(filepathWithFilename);
        LOGGER.info("filename " + filename + ".xml");
        builder
                .append(path)
                .append("\\")
                .append(entity.getClass().getSimpleName().toLowerCase())
                .append(filename)
                .append(".")
                .append(EXTENSION);

        filepathWithFilename = builder.toString();
        LOGGER.info(filepathWithFilename);

        return filepathWithFilename;
    }     

}
