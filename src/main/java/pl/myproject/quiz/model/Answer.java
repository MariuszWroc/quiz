package pl.myproject.quiz.model;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Mariusz Czarny
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"id", "description", "correct"})
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlAttribute
    private Integer id;
    private String description;
    private boolean correct;
//    @XmlTransient
//    private Question question;

    public Answer() {
    }

    public Answer(String description, boolean correct) {
        this.description = description;
        this.correct = correct;
    }
    
    public Answer(Integer id, String description, boolean isCorrect) {
        this.id = id;
        this.description = description;
        this.correct = isCorrect;
//        question = new Question();
    }
    
    public Answer(Integer id, String description, boolean isCorrect, Question question) {
        this.description = description;
        this.correct = isCorrect;
//        this.question = question;
        this.id = id;
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

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean isCorrect) {
        this.correct = isCorrect;
    }

    @Override
    public String toString() {
        return "Answer [description=" + description + ", isCorrect=" + correct + "]";
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
        Answer other = (Answer) obj;
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
