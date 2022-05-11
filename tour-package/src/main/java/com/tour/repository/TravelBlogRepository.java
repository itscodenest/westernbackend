package com.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.TravelBlog;

@Repository
public interface TravelBlogRepository extends JpaRepository<TravelBlog, Long> {

	@Query("Select t from TravelBlog t where t.isenable=true")
	List<TravelBlog> findAllactive();

	@Query("Select t from TravelBlog t where t.istravelstories=true")
	List<TravelBlog> findAllactiveStories();



}
