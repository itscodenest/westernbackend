package com.order.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.CustomisedOrderPackage;

@Repository
public interface CustomisedOrderPackageRepository extends JpaRepository<CustomisedOrderPackage, Long>{

	@Query("Select q from CustomisedOrderPackage q where q.userId=:userId")
	List<CustomisedOrderPackage> findAllOnCutomersid(@Param("userId") String userId);

	@Query("Select q from CustomisedOrderPackage q where q.accepetedby=:employid")
	List<CustomisedOrderPackage> findAllOnemployid(@Param("employid")String employid);
}
