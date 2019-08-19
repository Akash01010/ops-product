package com.sapient.ops.service;

import java.util.List;

import com.sapient.ops.entity.User;
import com.sapient.ops.exception.UserException;

public interface UserService {
	public abstract Integer addNewUser(User user) throws UserException;
	public abstract User getUserDetails(Integer userId) throws UserException;
	public abstract User getUserDetails(String userName, String password) throws UserException;
	public abstract List<User> getAllUsers() throws UserException;
}
