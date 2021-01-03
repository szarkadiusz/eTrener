package com.etrener.arch_to_delete;

import com.etrener.arch_to_delete.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrainingRepository extends CrudRepository <Training, Long>{
}
