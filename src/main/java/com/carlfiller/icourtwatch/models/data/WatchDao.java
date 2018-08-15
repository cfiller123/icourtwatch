package com.carlfiller.icourtwatch.models.data;

import com.carlfiller.icourtwatch.models.Judge;
import com.carlfiller.icourtwatch.models.Watch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface WatchDao extends CrudRepository<Watch, Integer> {

    @Override
    List<Watch> findAll();

    List<Watch> findByJudge(Judge judge);

    List<Watch> findByOwnerId(int ownerId);

}
