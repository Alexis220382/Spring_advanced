package com.ivanovskiy.spring.core.service.discount;

import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.ivanovskiy.spring.core.domain.Event;
import com.ivanovskiy.spring.core.domain.User;

public interface IDiscount {

	public double getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull Date airDateTime, long numberOfTickets);
}
