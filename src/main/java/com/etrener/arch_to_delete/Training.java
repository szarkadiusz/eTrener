package com.etrener.arch_to_delete;



import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity

public class Training {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long id;
    private String name;
    private Date createdAt;
    private Object trainigReq;
    private Object trainingProp;

    public Object getTrainigReq() {
        return trainigReq;
    }

    public void setTrainigReq(Object trainigReq) {
        this.trainigReq = trainigReq;
    }

    public Object getTrainingProp() {
        return trainingProp;
    }

    public void setTrainingProp(Object trainingProp) {
        this.trainingProp = trainingProp;
    }

    public Training(Object trainigReq, Object trainingProp) {
        this.trainigReq = trainigReq;
        this.trainingProp = trainingProp;
    }

    @ManyToMany(targetEntity=TrainingProperties.class)
    @Size(min=1, message="Wybierz przynajmniej 1 opcję")
    private List<TrainingProperties> ingredients = new ArrayList<>();

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<TrainingProperties> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<TrainingProperties> ingredients) {
        this.ingredients = ingredients;
    }

    public Training() {
    }

    public Training(Long id, String name, Date createdAt, @Size(min = 1, message = "Wybierz przynajmniej 1 opcję") List<TrainingProperties> ingredients) {


        this.name = name;
        this.createdAt = createdAt;
        this.ingredients = ingredients;
    }
}
