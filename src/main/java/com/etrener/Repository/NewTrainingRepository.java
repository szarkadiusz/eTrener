package com.etrener.Repository;


import com.etrener.NewTraining;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewTrainingRepository extends CrudRepository<NewTraining, Long> {
}
