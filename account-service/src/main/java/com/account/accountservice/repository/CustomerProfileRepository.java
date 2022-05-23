package com.account.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.CustomerProfile;



@Repository
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile,Long> {
	CustomerProfile findById(long id);
	
	@Query(value="SELECT * FROM customer_profile  as t1 left join traveller_profilejoin as t2 on t1.id = t2.id where traveller_id =:travellerid", nativeQuery = true)
	CustomerProfile findByuserid(@Param("travellerid") String travellerid);
}
