package com.etrener.arch_to_delete;

import com.etrener.arch_to_delete.TrainingProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
TrainingPropertiesRepository extends CrudRepository <TrainingProperties, Long>{
}
