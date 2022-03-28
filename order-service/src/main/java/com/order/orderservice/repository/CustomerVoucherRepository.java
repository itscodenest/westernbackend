package com.order.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.CustomerVoucher;

@Repository
public interface CustomerVoucherRepository extends JpaRepository<CustomerVoucher, Long>{

	@Query("Select q from CustomerVoucher q where q.customerid=:customerid")
	List<CustomerVoucher> findAllOnCutomers(@Param("customerid") String id);

	@Query("Select q from CustomerVoucher q where q.orderid=:orderid")
	List<CustomerVoucher> findAllOnOrder(@Param("orderid") Long orderid);
}
