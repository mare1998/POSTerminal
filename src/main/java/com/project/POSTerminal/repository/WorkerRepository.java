package com.project.POSTerminal.repository;

import com.project.POSTerminal.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, UUID> {


    @Query(value="select * from worker where username=:username",nativeQuery = true)
    Worker searchUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "select * from worker w inner join receipt r on w.id=r.worker_id where YEAR(r.date)=:year and MONTH(r.date)=:month group by w.id order by sum(price) desc limit 3",nativeQuery = true)
    List<Worker> findWorker(@Param("year") String year,@Param("month")String month);


}
