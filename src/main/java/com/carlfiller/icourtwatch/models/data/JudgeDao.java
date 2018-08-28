package com.carlfiller.icourtwatch.models.data;

import com.carlfiller.icourtwatch.models.Judge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface JudgeDao extends CrudRepository<Judge, Integer> {

    @Override
    List<Judge> findAll();

}
