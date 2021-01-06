package com.etrener;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class NewTraining {
//TODO: Gett, sett, konstr b arg, konstr arg



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Digits(integer = 3, fraction = 0, message = "Niewłaściwy ID Pracownika")
    private Long workerId;
    @NotBlank(message = "Podaj imię Pracownika")
    private String workerName;
    @NotBlank(message = "Podaj nazwisko Pracownika")
    private String workerSurname;
    private boolean isTrainingPrioritized;
    @NotBlank(message = "Podaj swój email")
    private String issuedByLogin;
    @NotBlank(message = "Wybierz Trenera")
    @Autowired
    static DedicatedTrainer dedicatedTrainer;
    @Autowired
    @NotBlank(message = "Wybierz przynajmniej jedną opcję")
    static TrainingType trainingType;
    private Date createdAt;
    private static String trainerList;
    private static String trainingsList;

    @PrePersist
    void placedAt() {
        this.createdAt = new Date();
    }


public static String trainingsListToString(){
    trainerList=addTrainingTypesToList()
            .stream()
            .map(s->String.valueOf(s))
            .collect(Collectors.joining("-"," " ," " ))
            .toString();
        return trainerList;
}
    public static String trainersListtoString(){
        trainingsList=addTrainersToList()
                .stream()
                .map(s->String.valueOf(s))
                .toString();
        return trainingsList;
    }

    public static List addTrainingTypesToList() {
        TrainingType[] trainingTypes = TrainingType.values();
        List<TrainingType> trainingTypesList = List.of(trainingTypes);
        return trainingTypesList;
    }

    public NewTraining() {
    }

    public static void setTrainerList(String trainerList) {
        addTrainersToList();
        trainersListtoString();
    }

    public static void setTrainingsList(String trainingsList) {
        addTrainingTypesToList();
        trainingsListToString();
    }

    public NewTraining(@Digits(integer = 3, fraction = 0, message = "Niewłaściwy ID Pracownika") Long workerId, String workerName, String workerSurname, boolean isTrainingPrioritized, String issuedByLogin, String trainerList, String trainersList) {
        this.workerId = workerId;
        this.workerName = workerName;
        this.workerSurname = workerSurname;
        this.isTrainingPrioritized = isTrainingPrioritized;
        this.issuedByLogin = issuedByLogin;
        this.trainerList = trainerList;
        this.trainingsList = trainersList;
    }

    public static List addTrainersToList() {
        DedicatedTrainer[] trainers = DedicatedTrainer.values();
        List<DedicatedTrainer> trainersList = List.of(trainers);
        return trainersList;


    }

    public String getTrainerList() {
        return trainerList;
    }



    public String getTrainersList() {
        return trainingsList;
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

    public boolean isTrainingPrioritized() {
        return isTrainingPrioritized;
    }

    public void setTrainingPrioritized(boolean trainingPrioritized) {
        isTrainingPrioritized = trainingPrioritized;
    }

    public String getIssuedByLogin() {
        return issuedByLogin;
    }

    public void setIssuedByLogin(String issuedByLogin) {
        this.issuedByLogin = issuedByLogin;
    }


}
