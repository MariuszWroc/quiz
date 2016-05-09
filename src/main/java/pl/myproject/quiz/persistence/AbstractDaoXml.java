/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence;

//import java.io.File;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Mariusz Czarny
 * @param <T>
 */
public abstract class AbstractDaoXml<T> implements IAbstractDaoXml<T> {
	private static final Logger LOGGER = Logger.getLogger(AbstractDaoXml.class.getName());

    private final Class<T> type;

    /**
     *
     * @return
     */
    protected Class<T> getType() {
        return this.type;
    }

    /**
     *
     * @return
     */
    protected String getClassName() {
        return type.getName();
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    public AbstractDaoXml() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public StringWriter convertObjectToXML(T entity, String filePath) {
        StringWriter stringWriter = new StringWriter();

        LOGGER.log(Level.INFO, "convertObjectToXML with path {0}", filePath);
        try {
            LOGGER.info("start writing..");
            try {
//                checkDirectory(directory);
                checkFile(filePath);
            } catch (IOException ex) {
                Logger.getLogger(AbstractDaoXml.class.getName()).log(Level.SEVERE, null, ex);
            }

            File file = new File(filePath);

            LOGGER.info("created file");
            JAXBContext jaxbContext = JAXBContext.newInstance(type);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(entity, file);
            jaxbMarshaller.marshal(entity, stringWriter);
        } catch (JAXBException e) {
            e.getMessage();
        }

        return stringWriter;
    }

    @SuppressWarnings("unused")
	private void checkDirectory(final String directory) throws IOException {
        Path path = Paths.get(directory);
        if (Files.isDirectory(path)) {
            LOGGER.info("it's a directory");
            if (Files.exists(path)) {
                LOGGER.info("Directory exist..");
            } else {
                LOGGER.info("Directory not exist..");
                Files.createDirectories(path);
                LOGGER.info("Directory created");
            }
        } else {
            LOGGER.info("it's not a directory");
        }
    }

    private void checkFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
            LOGGER.info("File exist..");
            if (Files.isWritable(path)) {
                Files.deleteIfExists(path);
                LOGGER.info("File deleted..");              
            } else {
                LOGGER.info("File is not writable..");
            }
        } else {
            LOGGER.info("File is not exist..");            
        }
    }

    @SuppressWarnings("unchecked")
	@Override
    public T convertXMLToObject(String path) {
        LOGGER.info("convertXMLToObject");
        T entity = null;

        try {
            File file = new File(path);
            LOGGER.info("open file");
            JAXBContext jaxbContext = JAXBContext.newInstance(type);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            entity = (T) jaxbUnmarshaller.unmarshal(file);
            LOGGER.info("Result of mapping xml is " + entity.toString());

        } catch (JAXBException e) {
            LOGGER.info(e.getMessage() + ", " + e);
        }

        return entity;
    }

    /**
     *
     * @param path
     */
    public void deleteXMLFile(String path) {

        try {
            File file = new File(path);

            if (file.delete()) {
                LOGGER.info(file.getName() + " is deleted!");
            } else {
                LOGGER.info("Delete operation is failed.");
            }
        } catch (Exception e) {
            LOGGER.info(e.getMessage() + ", " + e);
        }

    }

    /**
     *
     * @param path
     */
    public void updateXMLFile(String path) {

    }

}
