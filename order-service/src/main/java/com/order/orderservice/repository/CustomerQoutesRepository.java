package com.order.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.CustomerQoutes;

@Repository
public interface CustomerQoutesRepository extends JpaRepository<CustomerQoutes, Long>{
    
	@Query("Select q from CustomerQoutes q where q.userId=:customerid")
	List<CustomerQoutes> findAllOnCutomers(@Param("customerid") String customerid);

	@Query("Select q from CustomerQoutes q where q.orderId=:orderid")
	List<CustomerQoutes> findAllOnOrder(@Param("orderid") Long orderid);

}
