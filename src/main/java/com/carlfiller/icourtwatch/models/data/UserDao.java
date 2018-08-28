package com.carlfiller.icourtwatch.models.data;

import com.carlfiller.icourtwatch.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
