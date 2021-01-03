package com.etrener.arch_to_delete;

import com.etrener.arch_to_delete.TrainingPropertiesRepository;
import com.etrener.arch_to_delete.TrainingRepository;
import com.etrener.arch_to_delete.TrainingRequestRepository;
import com.etrener.arch_to_delete.Training;
import com.etrener.arch_to_delete.TrainingProperties;
import com.etrener.arch_to_delete.TrainingRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainingService {

    private TrainingPropertiesRepository trainingPropertiesRepository;
    private TrainingRequestRepository trainingRequestRepository;
    private TrainingRepository trainingRepository;

    public TrainingService(TrainingPropertiesRepository trainingPropertiesRepository,
                           TrainingRequestRepository trainingRequestRepository,
                           TrainingRepository trainingRepository) {

        this.trainingPropertiesRepository = trainingPropertiesRepository;
        this.trainingRequestRepository = trainingRequestRepository;
        this.trainingRepository = trainingRepository;
    }

    public Optional<TrainingProperties> getTrainingProperties(Long id) {
        return trainingPropertiesRepository.findById(id);
    }
    public Optional<TrainingRequest> getTrainingRequest(Long id) {
        return trainingRequestRepository.findById(id);
    }

    public Optional<Training> getTraining(Long id) {
        return trainingRepository.findById(id);
    }

    public TrainingProperties saveTrainingProperties(TrainingProperties trainingProperties) {
        return trainingPropertiesRepository.save(trainingProperties);

    }

    public TrainingRequest saveTrainingRequest (TrainingRequest trainingRequest){
        return trainingRequestRepository.save(trainingRequest);
    }


    public Training saveTraining (Training training, Long id){

        training.setTrainigReq(  getTrainingRequest(id));
        training.setTrainingProp(getTrainingProperties(id));

       return trainingRepository.save(training);

    }
}
