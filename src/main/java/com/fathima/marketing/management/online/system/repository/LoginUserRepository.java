package com.fathima.marketing.management.online.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fathima.marketing.management.online.system.model.LoginUser;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Integer> {

	@Query("SELECT c FROM LoginUser AS c WHERE c.luId = ?1 and c.luPassword=?2")
	LoginUser findByIdPassword(int id,String password);
	
	@Query("SELECT c FROM LoginUser AS c WHERE c.luPhone = ?1 and c.luPassword=?2")
	LoginUser findByPhonePassword(String phone,String password);;
}