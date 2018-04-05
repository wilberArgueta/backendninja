package com.udemy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.UsersConverter;
import com.udemy.entity.Users;
import com.udemy.model.UsersModel;
import com.udemy.repository.UsersRepository;
import com.udemy.service.UsersService;

@Service("usersServiceImpl")
public class UsersServiceImpl implements UsersService {

	@Autowired
	@Qualifier("usersRepository")
	private UsersRepository usersRepository;

	@Autowired
	@Qualifier("usersConverter")
	private UsersConverter usersConverter;

	@Override
	public UsersModel getUser(UsersModel um) {

		return null;
	}

}
