package com.onlineshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlineshop.bean.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String>{

	@Query("select l from Login l where l.typeOfUser = :typeOfUser")
	public List<Login> findUserBytypeOfUser(@Param("typeOfUser") String typeOfUser);

	
}
