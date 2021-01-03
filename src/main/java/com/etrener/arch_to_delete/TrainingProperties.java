package com.etrener.arch_to_delete;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;


@Entity
public class TrainingProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainingId;
//    @NotBlank(message="Wybierz Trenera")
    private String dedicatedTrainer;

//    @NotBlank(message="Wybierz przynajmniej jedną opcję")
    private TrainingType type;


    public static enum TrainingType {
        INTRO, HEALTHSAFETY, PRODUCT, WORKSTATION;


    }

    public static enum DedicatedTrainer{
        SZYMON, AREK, JOANNA, PRZEMEK;
    }

    public static List addTrainingTypesToList() {
        TrainingType[] trainingType = TrainingType.values();
        List<TrainingType> trainingTypesList = List.of(trainingType);
        return trainingTypesList;
    }

    public static List addTrainersToList(){
        DedicatedTrainer[] trainers = DedicatedTrainer.values();
        List <DedicatedTrainer> trainersList = List.of(trainers);
        return trainersList;

    }



    public String getDedicatedTrainer() {
        return dedicatedTrainer;
    }

    public void setDedicatedTrainer(String dedicatedTrainer) {
        this.dedicatedTrainer = dedicatedTrainer;
    }

    public TrainingType getType() {
        return type;
    }

    public void setType(TrainingType type) {
        this.type = type;
    }

    public TrainingProperties() {
    }

    public TrainingProperties(String dedicatedTrainer, TrainingType type) {
        this.dedicatedTrainer = dedicatedTrainer;
        this.type = type;
    }


}
