package com.ivanovskiy.spring.core.dao;

import com.ivanovskiy.spring.core.domain.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository  extends JpaRepository<Auditorium, Long> {

	public Auditorium findByName(String name);
	public Auditorium findById(Long id);

}
