package com.project.POSTerminal.repository;

import com.project.POSTerminal.dto.ItemDto;
import com.project.POSTerminal.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {


    @Transactional
    @Modifying
    @Query(value="SELECT *\n" +
            "FROM item as i\n" +
            "INNER JOIN items_receipts as ir\n" +
            "    ON i.id = ir.item_id\n" +
            "INNER JOIN receipt as r\n" +
            "    ON ir.receipt_id = r.id\n" +
            "GROUP BY i.id\n" +
                "HAVING COUNT(r.id)>0"
            ,nativeQuery = true)
    List<Item> fiveSales();

    @Transactional
    @Modifying
    @Query(value="select * from item where id not in(select item_id from items_receipts)",nativeQuery = true)
    List<Item> zeroSales();

    @Transactional
    @Modifying
    @Query(value="select count(r.id),i.name,c.name as catname from item as i inner join" +
            " items_receipts as ir on i.id=ir.item_id inner join" +
            " receipt as r on ir.receipt_id=r.id inner join" +
            " country as c on r.country_id=c.id group by i.id,c.name " +
            "order by count(r.id) desc,c.name desc limit 10",nativeQuery = true)






    List<String> topTenByCountry();

}
