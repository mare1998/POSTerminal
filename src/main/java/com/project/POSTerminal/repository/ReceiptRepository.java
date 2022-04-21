package com.project.POSTerminal.repository;

import com.project.POSTerminal.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, UUID> {

    @Transactional
    @Modifying
    @Query(value = "delete from receipt where id=:id",nativeQuery = true)
    void delete(@Param("id") UUID id);


    @Transactional
    @Query(value="select sum(r.price)+sum(c.pdv),c.name from receipt as r inner join country as c on r.country_id=c.id where r.date between :startDate and :endDate group by c.id",nativeQuery = true)
    List<String> totalTransactions(@Param("startDate") Date startDate, @Param("endDate") Date endDate);


}
