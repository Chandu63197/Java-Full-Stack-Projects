package org.jsp.merchantproduct.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.merchantproduct.dto.Merchant;
public class MerchantDao {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		public Merchant saveMerchant(Merchant merchant) {
			EntityTransaction transaction = manager.getTransaction();
	   		manager.persist(merchant);
	   		transaction.begin();
	   		transaction.commit();
	   		return merchant;
		}

		public Merchant updateMerchant(Merchant merchant) {
			EntityTransaction transaction = manager.getTransaction();
			manager.merge(merchant);
			transaction.begin();
			transaction.commit();
			return merchant;
		}
		public Merchant verifyMerchant(int id, String password) {
			String qry = "select m from Merchant m where m.id=?1 and m.password=?2";
			Query q = manager.createQuery(qry);
			q.setParameter(1, id);
			q.setParameter(2, password);
			return (Merchant) q.getSingleResult();
		}

		public Merchant verifyMerchant(long phone, String password) {
			String qry = "select m from Merchant m where m.phone=?1 and m.password=?2";
			Query q = manager.createQuery(qry);
			q.setParameter(1, phone);
			q.setParameter(2, password);
			return (Merchant) q.getSingleResult();
		}

		public Merchant verifyMerchant(String email, String password) {
			String qry = "select m from Merchant m where m.email=?1 and m.password=?2";
			Query q = manager.createQuery(qry);
			q.setParameter(1, email);
			q.setParameter(2, password);
			return (Merchant) q.getSingleResult();
	   }
}
