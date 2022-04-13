package com.order.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.CustomerOrderLogs;

@Repository
public interface CustomerOrderLogsRepository extends JpaRepository<CustomerOrderLogs,Long> {
	
	@Query("select l from  CustomerOrderLogs l  where  order_id=:order_id")
	List<CustomerOrderLogs> findAllById(@Param("order_id") Long order_id);

}
