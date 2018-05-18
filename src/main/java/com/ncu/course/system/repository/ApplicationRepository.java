package com.ncu.course.system.repository;

import com.ncu.course.system.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query(value = "update t_apply set status = ?2 where id = ?1", nativeQuery = true)
    void modifyStatus(int id, int status);

    @Query(value = "select * from t_apply where status = ?1", nativeQuery = true)
    List<Application> findApplicationByStatus(int status);

    @Query(value = "select * from t_apply left join t_course on t_apply.course = t_course.id where user = ?1", nativeQuery = true)
    List<Application> findApplicationByStatus(long jobNumber);

    @Query(value = "select * from t_apply where status = 0 or status = 2", nativeQuery = true)
    List<Application> findApplicationByStatus();
}
