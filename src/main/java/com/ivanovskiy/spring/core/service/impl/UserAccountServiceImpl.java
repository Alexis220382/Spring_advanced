package com.ivanovskiy.spring.core.service.impl;

import com.ivanovskiy.spring.core.dao.UserAccountRepository;
import com.ivanovskiy.spring.core.domain.User;
import com.ivanovskiy.spring.core.domain.UserAccount;
import com.ivanovskiy.spring.core.service.IUserAccountService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserAccountServiceImpl implements IUserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    @Transactional
    public UserAccount save(@Nonnull UserAccount object) {
        return userAccountRepository.save(object);
    }

    @Override
    @Transactional
    public void remove(@Nonnull UserAccount object) {
        userAccountRepository.delete(object.getId());
    }

    @Override
    @Transactional
    public UserAccount getById(@Nonnull Long id) {
        return userAccountRepository.findOne(id);
    }

    @Nonnull
    @Override
    @Transactional
    public Collection<UserAccount> getAll() {
        List<UserAccount> targetCollection = new ArrayList<>();
        Iterable<UserAccount> eventIterator = userAccountRepository.findAll();
        CollectionUtils.addAll(targetCollection, eventIterator.iterator());
        return targetCollection;
    }

    @Nullable
    @Override
    @Transactional
    public UserAccount getUserAccountByUser(@Nonnull User user) {
        return userAccountRepository.findByUser(user);
    }

}
