package org.jsp.springmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.jsp.springmvc.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
	public EntityManager manager;
    
    public User saveUser(User user) {
    	EntityTransaction transaction=manager.getTransaction();
    	manager.persist(user);
    	transaction.begin();
    	transaction.commit();
    	return user;
    }
    public User updateUser(User user) {
    	EntityTransaction transaction=manager.getTransaction();
    	manager.merge(user);
    	transaction.begin();
    	transaction.commit();
    	return user;
    }
    public User verify(long phone,String password) {
    	Query qry1=manager.createQuery("select u from User u where u.phone=?1 and u.password=?2");
    	qry1.setParameter(1, phone);
    	qry1.setParameter(2, password);
    	try {
			return (User) qry1.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
    }
}
