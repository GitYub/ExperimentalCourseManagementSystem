package com.ncu.course.system.repository;

import com.ncu.course.system.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserByJobNumberAndPassword(long jobNumber, String password);

    Optional<User> findUserByUsername(String username);

    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query(value = "update t_user set password = ?2 where job_number = ?1", nativeQuery = true)
    void modifyPwd(long jobNumber, String password);
}
