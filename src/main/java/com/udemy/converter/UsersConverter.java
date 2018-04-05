package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Users;
import com.udemy.model.UsersModel;
@Component("usersConverter")
public class UsersConverter {

	public UsersModel entityToModel(Users u) {

		UsersModel um = new UsersModel();
		um.setId(u.getId());
		um.setName(u.getName());
		um.setPassword(u.getPassword());

		return um;

	}

	public Users modelToEntity(UsersModel um) {

		Users u = new Users();
		u.setId(um.getId());
		u.setName(um.getName());
		u.setPassword(um.getPassword());

		return u;

	}

}
