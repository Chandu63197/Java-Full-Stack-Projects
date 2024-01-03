package org.jsp.merchantproduct.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.jsp.merchantproduct.dto.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
    @Autowired
	public EntityManager manager;

    public Merchant saveMerchant(Merchant merchant) {
    	EntityTransaction transaction=manager.getTransaction();
    	manager.persist(merchant);
    	transaction.begin();
    	transaction.commit();
    	return merchant;
    }
    
    public Merchant updateMerchant(Merchant merchant) {
    	EntityTransaction transaction=manager.getTransaction();
    	manager.merge(merchant);
    	transaction.begin();
    	transaction.commit();
    	return merchant;
    }
    
    public Merchant verifyMerchantPP(long phone,String password) {
    	String qry="select m from Merchant m where m.phone=?1 and m.password=?2";
    	Query q=manager.createQuery(qry);
    	q.setParameter(1,phone);
    	q.setParameter(2, password);
    	try {
			return (Merchant) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
    }
    
    public Merchant verifyMerchantEP(String email,String password) {
    	String qry="select m from Merchant m where m.email=?1 and m.password=?2";
    	Query q=manager.createQuery(qry);
    	q.setParameter(1, email);
    	q.setParameter(2, password);
    	try {
			return (Merchant) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
    }
}
