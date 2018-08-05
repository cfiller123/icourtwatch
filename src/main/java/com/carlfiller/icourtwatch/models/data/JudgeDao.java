package com.carlfiller.icourtwatch.models.data;


import com.carlfiller.icourtwatch.models.Disposition;
import com.carlfiller.icourtwatch.models.Judge;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Date;

@Repository
@Transactional
public interface JudgeDao extends CrudRepository<Judge, Integer> {

    @Modifying
    @Query("update Judge j set j.name = ?1, j.court = ?2, j.date = ?3, j.defendant = ?4, j.disposition = ?5 where j.id = ?6")
    void setUserInfoById(String name, int court, Date date, String defendant, Disposition disposition, Integer id);
}
