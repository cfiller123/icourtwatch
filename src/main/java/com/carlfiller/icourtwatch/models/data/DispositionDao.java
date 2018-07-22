package com.carlfiller.icourtwatch.models.data;

import com.carlfiller.icourtwatch.models.Disposition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DispositionDao extends CrudRepository<Disposition, Integer> {
}
