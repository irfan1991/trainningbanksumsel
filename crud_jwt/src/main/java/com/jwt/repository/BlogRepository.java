package com.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.model.Blog;
import com.jwt.model.UserInfo;

@Repository
public interface BlogRepository extends 
JpaRepository<Blog,Integer>{
	
	 List<Blog> findByTitleContainingOrContentContaining
	    (String text, String textAgain);

}
