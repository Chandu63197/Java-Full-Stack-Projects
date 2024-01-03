package org.jsp.usermvcdemo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.usermvcdemo.dto.User;
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
    public User findById(int id) {
    	return manager.find(User.class, id);
    }
    public boolean delete(int id) {
    	User user=findById(id);
    	if(user!=null) {
    		EntityTransaction transaction=manager.getTransaction();
    		manager.remove(user);
    		transaction.begin();
    		transaction.commit();
    		return true;
    	}
    	return false;
    }
    public User verifyId(int id,String password) {
    	Query qry=manager.createQuery("select u from User u where u.id=?1 and u.password=?2");
    	qry.setParameter(1, id);
    	qry.setParameter(2, password);
    	try {
			return (User) qry.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
    }
    public User verifyId(long phone,String password) {
    	Query qry=manager.createQuery("select u from User u where u.phone=?1 and u.password=?2");
    	qry.setParameter(1, phone);
    	qry.setParameter(2, password);
    	try {
			return (User) qry.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
    }
    public User verifyEmail(String email,String password) {
    	Query qry=manager.createQuery("select u from User u where u.email=?1 and u.password=?2");
    	qry.setParameter(1, email);
    	qry.setParameter(2, password);
    	try {
			return (User) qry.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
    }
}
