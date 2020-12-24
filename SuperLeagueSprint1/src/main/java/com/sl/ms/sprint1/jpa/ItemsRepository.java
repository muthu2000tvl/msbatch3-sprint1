package com.sl.ms.sprint1.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ItemsRepository extends JpaRepository<Items, Long>{

	
	
	@Query("select name , quantity from ITEMS ")
	Object[] findAllStock();
	
//	@Query("select name,quantity from ITEMS where ITEMS_DATE = :itemsDate")
//    List<Items> findByitemsDate(@Param("itemsDate") Date itemsDate);
	
	@Query("select SUM(quantity) from ITEMS ")
    int findByQuantity();

}
