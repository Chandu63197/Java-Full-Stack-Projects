package org.jsp.merchantproduct.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jsp.merchantproduct.dto.Merchant;
import org.jsp.merchantproduct.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
    public EntityManager manager;
	
	public Product addProduct(Product product,int mid) {
		Merchant m=manager.find(Merchant.class, mid);
		if(m!=null) {
			EntityTransaction transaction=manager.getTransaction();
			m.getProduct().add(product);
			product.setMerchant(m);
			manager.persist(product);
			transaction.begin();
			transaction.commit();
			return product;
		}
		return null;
	}
	
	public Product updateProduct(Product product,int mid) {
		Merchant m=manager.find(Merchant.class, mid);
		if(m!=null) {
			EntityTransaction transaction=manager.getTransaction();
			product.setMerchant(m);
			m.getProduct().add(product);
			manager.merge(product);
			transaction.begin();
			transaction.commit();
			return product;
		}
		return null;
	}
	
	public List<Product> findByMerchantId(int id){
		String qry="select m.product from Merchant m where m.id=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, id);
		return q.getResultList();
	}
	
	public List<Product> findByCategory(String category){
		String qry="select p from Product p where p.category=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, category);
		return q.getResultList();
	}
	
	public List<Product> findByBrand(String brand){
		String qry="select p from Product p where p.brand=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, brand);
		return q.getResultList();
	}
	
	public List<Product> findAll(){
		String qry="select p from Product p";
		Query q=manager.createQuery(qry);
		return q.getResultList();
	}
}
