package com.order.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.CustomerInvoice;

@Repository
public interface CustomerInvoiceRepository extends JpaRepository<CustomerInvoice, Long> {
	
	@Query("Select q from CustomerInvoice q where q.orderId=:orderid")
	List<CustomerInvoice> findAllOnOrder(@Param("orderid") Long orderid);

}
