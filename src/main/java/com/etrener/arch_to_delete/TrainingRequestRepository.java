package com.etrener.arch_to_delete;

import com.etrener.arch_to_delete.TrainingRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrainingRequestRepository extends CrudRepository<TrainingRequest,Long>  {
}
