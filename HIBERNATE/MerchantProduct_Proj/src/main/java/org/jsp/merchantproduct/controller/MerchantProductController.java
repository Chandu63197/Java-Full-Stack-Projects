package org.jsp.merchantproduct.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import org.jsp.merchantproduct.dao.MerchantDao;
import org.jsp.merchantproduct.dao.ProductDao;
import org.jsp.merchantproduct.dto.Merchant;
import org.jsp.merchantproduct.dto.Product;
public class MerchantProductController {
	static Scanner s=new Scanner(System.in);
	static MerchantDao mdao=new MerchantDao();
	static ProductDao pdao=new ProductDao();
    public static void main(String[] args) {
		System.out.println("1.Save Merchant");
		System.out.println("2.Update Merchant");
		System.out.println("3.Add Product");
		System.out.println("4.Update Product");
		System.out.println("5.verify Merchant By Id and Password");
		System.out.println("6.verify Merchant By Phone and Password");
		System.out.println("7.verify Merchant By Email and Password");
		System.out.println("8.Find Product By Merchant ID");
		System.out.println("9.Find Products By Brand");
		System.out.println("10.Find Products By Category");
		System.out.println("enter your choice");
		int choice=s.nextInt();
		switch(choice) {
		    case 1:{
		    	saveMerchant();
		    	break;
		    }
		    case 2:{
		    	updateMerchant();
		    	break;
		    }
		    case 3:{
		    	addProduct();
		        break;
		    }
		    case 4:{
		    	updateProduct();
		    	break;
		    }
		    case 5:{
		    	verifyMerchantById();
		    	break;
		    }
		    case 6:{
		    	verifyMerchantByPhone();
		    	break;
		    }
		    case 7:{
		    	verifyMerchantByEmail();
		    	break;
		    }
		    case 8:{
		    	findProductByMerchantId();
		    	break;
		    }
		    case 9:{
		    	findProductByBrand();
		    	break;
		    }
		    case 10:{
		    	findProductByCategory();
		    	break;
		    }
		}
    }
    public static void saveMerchant() {
    	System.out.println("Enter the name,phone,email,gst,password to add merchant");
		Merchant m = new Merchant();
		m.setName(s.next());
		m.setPhone(s.nextLong());
		m.setEmail(s.next());
		m.setGst(s.next());
		m.setPassword(s.next());
		m=mdao.saveMerchant(m);
		System.out.println("Merchant saved with id:"+m.getId());
    }
    public static void updateMerchant() {
		System.out.println("Enter the Merchant id to update");
		int id = s.nextInt();
		System.out.println("Enter the name,phone,email ,gstand password to save Merchant");
		Merchant m=new Merchant();
		m.setId(id);
		m.setName(s.next());
		m.setEmail(s.next());
		m.setGst(s.next());
		m.setPhone(s.nextLong());
		m.setPassword(s.next());
		m=mdao.updateMerchant(m);
		System.out.println("Merchsnt Updated with id:"+m.getId());
	}
	public static void addProduct() {
		Product p = new Product();
		System.out.println("Enter the merchant id to add product");
		int mid= s.nextInt();
    	System.out.println("Enter the name,brand,description,category,cost");
		p.setName(s.next());
		p.setBrand(s.next());
		p.setCost(s.nextDouble());
		p.setCategory(s.next());
		s.nextLine();
		p.setDescription(s.nextLine());
		p=pdao.saveProduct(p, mid);
		if (p != null)
			System.out.println("Product add with Id:" + p.getId());
		else
			System.err.println("Invalid merchant Id");
	}

	public static void updateProduct() {
		System.out.println("Enter the Product id to update");
		int mid = s.nextInt();
		System.out.println("Enter the name,brand,description category to save product");
		Product p = new Product();
		p.setId(mid);
		p.setName(s.next());
		p.setBrand(s.next());
		p.setCost(s.nextDouble());
		p.setCategory(s.next());
		s.nextLine();
		p.setDescription(s.nextLine());
		p=pdao.updateProduct(p, mid);
		if (p != null)
			System.out.println("Product updated with Id:" + p.getId());
		else
			System.err.println("Invalid merchant Id");
	}
	public static void findProductByMerchantId() {
		System.out.println("Enter the Merchant id to find Product");
		int mid = s.nextInt();
		List<Product> product = pdao.findProductByMerchantId(mid);
		if (product.size() > 0) {
			for (Product p : product) {
				System.out.println("Product Id:" + p.getId());
				System.out.println("Product name:" + p.getName());
				System.out.println("Product brand:"+p.getBrand());
				System.out.println("Product Description:"+p.getDescription());
				System.out.println("Cost:"+p.getCost());
				System.out.println("category:"+p.getCategory());
				System.out.println("------------------------------");
			}
		} else {
			System.err.println("Invalid Merchant id");
		}
	}
	public static void verifyMerchantById() {
		Merchant m=new Merchant();
		System.out.println("Enter the Merchant id and password to verify");
		int id = s.nextInt();
		String password = s.next();
		try {
		    m = mdao.verifyMerchant(id, password);
			System.out.println("Merchant Id:" + m.getId());
			System.out.println("Merchant name:" + m.getName());
			System.out.println("gst:" +m.getGst());
			System.out.println("Phone Number:" + m.getPhone());
			System.out.println("Email Id:" + m.getEmail());
		} 
		catch(NoResultException e) {
			System.err.println("Invalid Id or password");
		}
	}

	public static void verifyMerchantByPhone() {
		Merchant m=new Merchant();
		System.out.println("Enter the Merchant phone and password to verify");
	    long phone = s.nextLong();
		String password = s.next();
		try {
		    m = mdao.verifyMerchant(phone, password);
			System.out.println("Merchant Id:" + m.getId());
			System.out.println("Merchant name:" + m.getName());
			System.out.println("gst:" +m.getGst());
			System.out.println("Phone Number:" + m.getPhone());
			System.out.println("Email Id:" + m.getEmail());
		} 
		catch(NoResultException e) {
			System.err.println("Invalid phone or password");
		}
	}

	public static void verifyMerchantByEmail() {
		Merchant m=new Merchant();
		System.out.println("Enter the Merchant email and password to verify");
		String email=s.next();
		String password = s.next();
		try {
		    m = mdao.verifyMerchant(email, password);
			System.out.println("Merchant Id:" + m.getId());
			System.out.println("Merchant name:" + m.getName());
			System.out.println("gst:" +m.getGst());
			System.out.println("Phone Number:" + m.getPhone());
			System.out.println("Email Id:" + m.getEmail());
		} 
		catch(NoResultException e) {
			System.err.println("Invalid Id or password");
		}
	}

	public static void findProductByBrand() {
		String brand=s.next();
		System.out.println("Enter the product brand to fetch");
		List<Product> product=pdao.findProdByBrand(brand);
		if (product.size() > 0) {
			for (Product p : product) {
				System.out.println("Product Id:" + p.getId());
				System.out.println("Product name:" + p.getName());
				System.out.println("Product brand:"+p.getBrand());
				System.out.println("Product Description:"+p.getDescription());
				System.out.println("Cost:"+p.getCost());
				System.out.println("category:"+p.getCategory());
				System.out.println("------------------------------");
			}
		} else {
			System.err.println("Invalid Product brand");
		}
	}
	public static void findProductByCategory() {
		String category=s.next();
		System.out.println("Enter the product category to fetch");
		List<Product> product=pdao.findProdByBrand(category);
		if (product.size() > 0) {
			for (Product p : product) {
				System.out.println("Product Id:" + p.getId());
				System.out.println("Product name:" + p.getName());
				System.out.println("Product brand:"+p.getBrand());
				System.out.println("Product Description:"+p.getDescription());
				System.out.println("Cost:"+p.getCost());
				System.out.println("category:"+p.getCategory());
				System.out.println("------------------------------");
			}
		} else {
			System.err.println("Invalid Product category");
		}
	}
}

