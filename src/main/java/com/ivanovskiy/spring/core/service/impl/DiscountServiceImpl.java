package com.ivanovskiy.spring.core.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.ivanovskiy.spring.core.domain.Event;
import com.ivanovskiy.spring.core.domain.User;
import com.ivanovskiy.spring.core.service.IUserService;
import com.ivanovskiy.spring.core.service.discount.IDiscount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivanovskiy.spring.core.service.IDiscountService;

@Service
public class DiscountServiceImpl implements IDiscountService {

	@Autowired
	private IUserService userService;
	@Resource(name="bunchOfDiscounts")
	private List<IDiscount> discounts;

	@Override
	public double getDiscount(User user, Event event, Date airDateTime, long numberOfTickets) {
		User userFromDB = userService.getById(user.getId());
		User userToCountDiscount = checkIfRegisteredUser(userFromDB, user);
		double discountCurrent = 0;
		for (IDiscount discount : discounts) {
			double obtainedDiscount = discount.getDiscount(userToCountDiscount, event, airDateTime, numberOfTickets);
			if (discountCurrent < obtainedDiscount) {
				discountCurrent = obtainedDiscount;
			}
		}
		return discountCurrent;
	}

	private User checkIfRegisteredUser(User userFromDB, User passeUser) {
		if (userFromDB != null) {
			userFromDB.setRegistered(true);
			return userFromDB;
		}
		return passeUser;
	}

	
}
