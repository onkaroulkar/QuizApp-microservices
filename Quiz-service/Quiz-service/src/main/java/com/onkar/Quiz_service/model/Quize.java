package com.onkar.Quiz_service.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Quize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ElementCollection
    private List<Integer> questionIds;

    public Quize() {
    }

    public Quize(int id, String title, List<Integer> questions) {
        this.id = id;
        this.title = title;
        this.questionIds = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getQuestionsIds() {
        return questionIds;
    }

    public void setQuestions(List<Integer> questionIds) {
        this.questionIds = questionIds;
    }

    @Override
    public String toString() {
        return "Quize{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", questions=" + questionIds +
                '}';
    }
}
