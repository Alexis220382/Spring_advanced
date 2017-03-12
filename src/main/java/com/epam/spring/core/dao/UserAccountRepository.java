package com.epam.spring.core.dao;

import com.epam.spring.core.domain.User;
import com.epam.spring.core.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alexey-Ivanovskiy on 12.03.2017.
 */
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    public UserAccount findByUser(User user);
}
