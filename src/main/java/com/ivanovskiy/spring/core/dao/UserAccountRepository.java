package com.ivanovskiy.spring.core.dao;

import com.ivanovskiy.spring.core.domain.User;
import com.ivanovskiy.spring.core.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    public UserAccount findByUser(User user);
}
