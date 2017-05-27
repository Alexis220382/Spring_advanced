package com.ivanovskiy.spring.core.web.beans;

import com.ivanovskiy.spring.core.domain.Event;
import com.ivanovskiy.spring.core.domain.User;

public class UserEventBean {
	
	private User user;
	private Event event;
	
	private UserEventBean() {
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}

}
