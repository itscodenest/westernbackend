package com.events.westernevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.events.MainEventBlogs;

@Repository
public interface MainEventBlogsRepository extends JpaRepository<MainEventBlogs, Long>  {

}
