package com.ivanovskiy.spring.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivanovskiy.spring.core.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	public void delete(Event event);
	public Event findByName(String name);
	
}
