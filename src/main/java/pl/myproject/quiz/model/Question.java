package pl.myproject.quiz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Mariusz Czarny
 */
@XmlRootElement(name="QuestionPool")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"id", "description", "answerList"})
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlAttribute    
    private Integer id;
    private String description;
    @XmlElement(name="answer")
    private List<Answer> answerList;

    public Question() {
    }
    
    public Question(Integer id, String description, List<Answer> answerList) {
        this.id = id;
        this.description = description;
        this.answerList = answerList;
    }
        
    public Question(Integer id, String description) {
        this.id = id;
        this.description = description;
        this.answerList = new ArrayList<>();
    }
    
    public void populate(String description, boolean isCorrect, Integer id) {
        this.answerList.add(new Answer(id, description, isCorrect, this));
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }
    
//    @XmlTransient
    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", description=" + description + ", answerList=" + answerList + '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Question other = (Question) obj;
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        return true;
    }

}
