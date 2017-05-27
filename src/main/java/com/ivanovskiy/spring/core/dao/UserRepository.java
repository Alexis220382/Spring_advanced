package com.ivanovskiy.spring.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivanovskiy.spring.core.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{	

	public User findByEmail(String email);

	public User findByUsername(String username);

}
