package org.jsp.adminhospital.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jsp.adminhospital.dto.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

	@Autowired
	public EntityManager manager;

	public Admin saveAdmin(Admin admin) {
	    	EntityTransaction transaction=manager.getTransaction();
	    	manager.persist(admin);
	    	transaction.begin();
	    	transaction.commit();
	    	return admin;
	}

	public Admin updateAdmin(Admin admin) {
		EntityTransaction transaction = manager.getTransaction();
		manager.merge(admin);
		transaction.begin();
		transaction.commit();
		return admin;
	}	

	public Admin verify(long phone, String password) {
		String qry = "select a from Admin a where a.phone=?1 and a.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (Admin) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public Admin verify(String email, String password) {
		String qry = "select a from Admin a where a.email=?1 and a.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (Admin) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}

