package com.etrener;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class NewTraining {
//TODO: Gett, sett, konstr b arg, konstr arg

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private Date createdAt;
    private Object trainigReq;
    private Object trainingProp;

    //    @NotBlank(message="Wybierz Trenera")
    private DedicatedTrainer dedicatedTrainer;

    //    @NotBlank(message="Wybierz przynajmniej jedną opcję")
    private TrainingType type;


    private Date placedAt;

    @NotBlank(message = "Podaj swój login")
    private String issuedByLogin;

    @NotBlank(message = "Czy szkolenie jest priorytetowe ?")
    private boolean isTrainingPrioritized;

    @Digits(integer = 3, fraction = 0, message = "Niewłaściwy ID Pracownika")
    private Long workerId;

    @NotBlank(message = "Podaj imię Pracownika")
    private String workerName;

    @NotBlank(message = "Podaj nazwisko Pracownika")
    private String workerSurname;


    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }


    public static enum TrainingType {
        INTRO, HEALTHSAFETY, PRODUCT, WORKSTATION;


    }

    public static enum DedicatedTrainer {
        SZYMON, AREK, JOANNA, PRZEMEK;
    }


    public static List addTrainingTypesToList() {
        NewTraining.TrainingType[] trainingType = NewTraining.TrainingType.values();
        List<NewTraining.TrainingType> trainingTypesList = List.of(trainingType);
        return trainingTypesList;
    }

    public static List addTrainersToList() {
        NewTraining.DedicatedTrainer[] trainers = NewTraining.DedicatedTrainer.values();
        List<NewTraining.DedicatedTrainer> trainersList = List.of(trainers);
        return trainersList;

    }
}
