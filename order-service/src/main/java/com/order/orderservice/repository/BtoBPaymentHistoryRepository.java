package com.order.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.BtoBPaymentHistory;

@Repository
public interface BtoBPaymentHistoryRepository extends JpaRepository<BtoBPaymentHistory, Long> {
	
	@Query("Select q from BtoBPaymentHistory q where q.userid=:customerid")
	List<BtoBPaymentHistory> findAllOnCutomers(@Param("customerid") Long customerid);

	@Query("Select q from BtoBPaymentHistory q where q.orderid=:orderid")
	List<BtoBPaymentHistory> findAllOnOrder(@Param("orderid") Long orderid);

	
}
