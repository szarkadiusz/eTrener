package com.etrener.arch_to_delete;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class TrainingRequest implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    private Date placedAt;

    @NotBlank(message="Podaj swój login")
    private String issuedByLogin;

    @NotBlank(message="Czy szkolenie jest priorytetowe ?")
    private boolean isTrainingPrioritized;

    @Digits(integer=3, fraction=0, message="Niewłaściwy ID Pracownika")
    private Long workerId;

    @NotBlank(message="Podaj imię Pracownika")
    private String workerName;

    @NotBlank(message="Podaj nazwisko Pracownika")
    private String workerSurname;


    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
    @ManyToMany(targetEntity=Training.class)
    private List<Training> trainings = new ArrayList<>();

    public void addTraining(Training trainingRequest) {
        this.trainings.add(trainingRequest);
    }

    public TrainingRequest() {
    }

    public TrainingRequest(  String issuedByLogin, boolean isTrainingPrioritized, @Digits(integer = 3, fraction = 0, message = "Niewłaściwy ID Pracownika") Long workerId, String workerName, String workerSurname, List<Training> trainings) {


        this.issuedByLogin = issuedByLogin;
        this.isTrainingPrioritized = isTrainingPrioritized;
        this.workerId = workerId;
        this.workerName = workerName;
        this.workerSurname = workerSurname;
        this.trainings = trainings;
    }




    public String getIssuedByLogin() {
        return issuedByLogin;
    }

    public void setIssuedByLogin(String issuedByLogin) {
        this.issuedByLogin = issuedByLogin;
    }

    public boolean isTrainingPrioritized() {
        return isTrainingPrioritized;
    }

    public void setTrainingPrioritized(boolean trainingPrioritized) {
        isTrainingPrioritized = trainingPrioritized;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerSurname() {
        return workerSurname;
    }

    public void setWorkerSurname(String workerSurname) {
        this.workerSurname = workerSurname;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }
}
