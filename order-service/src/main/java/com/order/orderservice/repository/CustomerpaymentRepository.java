package com.order.orderservice.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.CustomerPayment;

@Repository
public interface CustomerpaymentRepository extends JpaRepository<CustomerPayment, Long> {
	
	@Query("Select q from CustomerPayment q where q.userid=:customerid")
	List<CustomerPayment> findAllOnCutomers(@Param("customerid") Long customerid);

	@Query("Select q from CustomerPayment q where q.orderid=:orderid")
	List<CustomerPayment> findAllOnOrder(@Param("orderid") Long orderid);
	
	

}
