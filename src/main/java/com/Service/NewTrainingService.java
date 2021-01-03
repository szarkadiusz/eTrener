package com.Service;

import com.etrener.NewTraining;
import com.etrener.Repository.NewTrainingRepository;
import org.springframework.stereotype.Service;

@Service
public class NewTrainingService {
    NewTrainingRepository newTrainingRepository;

    public NewTrainingService(NewTrainingRepository newTrainingRepository) {
        this.newTrainingRepository = newTrainingRepository;
    }

    public NewTraining saveNewTraining (NewTraining newTraining){
        return newTrainingRepository.save(newTraining);
    }

    public Iterable <NewTraining> findAllNewTrainings (){
        return newTrainingRepository.findAll();
    }
}
