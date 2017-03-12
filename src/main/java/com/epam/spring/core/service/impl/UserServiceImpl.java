package com.epam.spring.core.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.spring.core.dao.UserRepository;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.service.IUserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author alehstruneuski
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User object) {
		return userRepository.save(object);
	}

	@Override
	public void remove(User object) {
		userRepository.delete(object.getId());
	}

	@Override
	public User getById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public Collection<User> getAll() {
		List<User> targetCollection = new ArrayList<User>();
		Iterable<User> eventIterator = userRepository.findAll();
		CollectionUtils.addAll(targetCollection, eventIterator.iterator());
		return targetCollection;
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Nullable
	@Override
	public User getUserByUsername(@Nonnull String username) {
		return userRepository.findByUsername(username);
	}

}