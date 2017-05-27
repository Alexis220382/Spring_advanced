package com.ivanovskiy.spring.core.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.ivanovskiy.spring.core.domain.User;

public interface IUserService extends IAbstractDomainObjectService<User> {

    /**
     * Finding user by email
     * 
     * @param email
     *            Email of the user
     * @return found user or <code>null</code>
     */
    public @Nullable User getUserByEmail(@Nonnull String email);

    /**
     * Finding user by email
     *
     * @param username
     *            Username of the user
     * @return found user or <code>null</code>
     */
    public @Nullable User getUserByUsername(@Nonnull String username);

}
