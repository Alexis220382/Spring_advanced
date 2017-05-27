package com.ivanovskiy.spring.core.service;

import com.ivanovskiy.spring.core.domain.User;
import com.ivanovskiy.spring.core.domain.UserAccount;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface IUserAccountService extends IAbstractDomainObjectService<UserAccount> {

    /**
     * Finding user account by user
     *
     * @param user
     *            Account of the user
     * @return found user or <code>null</code>
     */
    public @Nullable UserAccount getUserAccountByUser(@Nonnull User user);
}
