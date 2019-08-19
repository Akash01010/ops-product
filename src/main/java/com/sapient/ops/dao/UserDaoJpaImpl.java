package com.sapient.ops.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sapient.ops.model.User;

@Repository
public class UserDaoJpaImpl implements UserDAO{
	@PersistenceContext
	private EntityManager entityManager;
	
	/*
	 * EntityManagerFactory emf =
	 * Persistence.createEntityManagerFactory("ops-spring-jpa-web-app");
	 */
	Logger daoLogger= Logger.getLogger(UserDaoJpaImpl.class);
	@Override
	public Integer addNewUser(User user) throws Exception {
		//EntityManager entityManager=null;
		//EntityTransaction entityTransaction=null;
		try {
			//entityManager= emf.createEntityManager();
			//entityTransaction= entityManager.getTransaction();
			//entityTransaction.begin();
			entityManager.persist(user);
			//entityTransaction.commit();
		}catch(PersistenceException e) {
			//entityTransaction.rollback();
			e.printStackTrace();
			daoLogger.error("Unable to persist user object", e);
		}catch(Exception e) {
			//entityTransaction.rollback();
			daoLogger.error("Unable to persist user object", e);
		}
		finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public User getUserDetails(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserDetails(String userName, String password) throws Exception {
		//EntityManager entityManager=null;
		String jpql= "select u from User u "
				+ "where userName= :uname and password= :pwd ";
		try {
			//entityManager= emf.createEntityManager();
			TypedQuery<User> typedQuery= entityManager
					.createQuery(jpql, User.class)
					.setParameter("uname", userName)
					.setParameter("pwd", password);
			User user= typedQuery.getSingleResult();
			daoLogger.info("user details retreived");
			return user;
		}catch(PersistenceException e) {
			e.printStackTrace();
			daoLogger.error("Unable to persist user object", e);
			throw new Exception("Unable to persist user object",e);
		}catch(Exception e) {
			daoLogger.error("Unable to persist user object", e);
			throw new Exception("Unable to persist user object",e);
		}
		finally {
			entityManager.close();
		}
		
	}

	@Override
	public List<User> getAllUsers() throws Exception {
		//EntityManager entityManager=null;
		String jpql= "Select u from User u";
		try {
			//entityManager= emf.createEntityManager();
			//entityManager.getTransaction().begin();
			TypedQuery<User> typedQuery=
					entityManager.createQuery(jpql, User.class);
			List<User> userList= typedQuery.getResultList();
			//entityManager.getTransaction().commit();
			return userList;
		}catch(PersistenceException e) {
			e.printStackTrace();
			daoLogger.error("Unable to read user objects", e);
			throw new Exception("Unable to read user objects",e);
		}catch(Exception e) {
			daoLogger.error("Unable to read user objects", e);
			throw new Exception("Unable to read user objects",e);
		}
		finally {
			entityManager.close();
		}
		
	}

}
