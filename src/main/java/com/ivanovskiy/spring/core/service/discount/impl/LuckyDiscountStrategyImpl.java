package com.ivanovskiy.spring.core.service.discount.impl;

import java.util.Date;

import com.ivanovskiy.spring.core.domain.Event;
import com.ivanovskiy.spring.core.domain.User;
import com.ivanovskiy.spring.core.service.discount.IDiscount;

public class LuckyDiscountStrategyImpl implements IDiscount {

	private static final double LUCKY_DISCOUNT = 0.50;
	private static final long EACH_TH_TICKET = 10; 

	@Override
	public double getDiscount(User user, Event event, Date airDateTime, long numberOfTickets) {
		if (user.isRegistered()) {
			return numberOfTickets % EACH_TH_TICKET == 0 ? LUCKY_DISCOUNT : 0;
		} else {
			long numberOfUserTickets = user.getTickets().size() + numberOfTickets;
			return numberOfUserTickets % EACH_TH_TICKET == 0 ? LUCKY_DISCOUNT : 0;
		}
	}

}
