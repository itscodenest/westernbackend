package com.order.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.CustomerPayment;
import com.tourcoreservice.entity.CustomerPaymentHistory;
import com.tourcoreservice.entity.CustomerQoutes;


@Repository
public interface CustomerPaymentHistoryRepository  extends JpaRepository<CustomerPaymentHistory, Long>{
	
	@Query("Select q from CustomerPaymentHistory q where q.userid=:customerid")
	List<CustomerPaymentHistory> findAllOnCutomers(@Param("customerid") Long customerid);

	@Query("Select q from CustomerPaymentHistory q where q.orderid=:orderid")
	List<CustomerPaymentHistory> findAllOnOrder(@Param("orderid") Long orderid);

	
	
	

}
