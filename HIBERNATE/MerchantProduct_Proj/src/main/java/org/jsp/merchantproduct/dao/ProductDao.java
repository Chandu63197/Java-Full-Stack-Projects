package org.jsp.merchantproduct.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.merchantproduct.dto.Merchant;
import org.jsp.merchantproduct.dto.Product;
public class ProductDao {
    EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
   	public Product saveProduct(Product prod,int id) {
   		Merchant m = manager.find(Merchant.class, id);
		if (m != null) {
			prod.setMerchant(m);
			EntityTransaction transaction = manager.getTransaction();
			manager.persist(prod);
			transaction.begin();
			transaction.commit();
			return prod;
		}
		return null;
   	}
   	public Product updateProduct(Product prod,int mid) {
   		Merchant m = manager.find(Merchant.class, mid);
		if (m != null) {
			prod.setMerchant(m);
			EntityTransaction transaction = manager.getTransaction();
			manager.merge(prod);
			transaction.begin();
			transaction.commit();
			return prod;
		}
		return null;
   	}
   	public List<Product> findProductByMerchantId(int id) {
		String qry = "select m.product from Merchant m where m.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		return q.getResultList();
	}
   	public List<Product> findProdByBrand(String brand) {
 	   String qry="select p from Product p where p.brand=?1";
 	   Query q=manager.createQuery(qry);
 	   q.setParameter(1, brand);
 	   return q.getResultList();
    }
    public List<Product> findProdByCategory(String category) {
 	   String qry="select p from Product p where p.category=?1";
 	   Query q=manager.createQuery(qry);
 	   q.setParameter(1, category);
 	   return q.getResultList();
    }
} 
