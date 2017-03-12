package com.epam.spring.core.service;

import com.epam.spring.core.domain.User;
import com.epam.spring.core.domain.UserAccount;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by Alexey-Ivanovskiy on 12.03.2017.
 */
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
