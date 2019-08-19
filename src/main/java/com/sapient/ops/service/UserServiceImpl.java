package com.sapient.ops.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.ops.dao.UserDAO;
import com.sapient.ops.dao.UserDaoJpaImpl;
import com.sapient.ops.exception.UserException;
import com.sapient.ops.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO; 
	
	@Override
	public Integer addNewUser(User user) throws UserException {
		try {			
			user.setCreateDate(new Date());			
			return userDAO.addNewUser(user);
		}catch(Exception e) {
			throw new UserException(e.getMessage(),e);
		}
		
	}
	@Override
	public User getUserDetails(Integer userId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User getUserDetails(String userName, String password) throws UserException {
		try {									
			return userDAO.getUserDetails(userName, password);
		}catch(Exception e) {
			throw new UserException(e.getMessage(),e);
		}
	}
	@Override
	public List<User> getAllUsers() throws UserException {
		try {									
			return userDAO.getAllUsers();
		}catch(Exception e) {
			throw new UserException(e.getMessage(),e);
		}
	}
	

}
