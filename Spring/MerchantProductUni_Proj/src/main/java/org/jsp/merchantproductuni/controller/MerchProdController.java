package org.jsp.merchantproductuni.controller;

import java.util.List;
import java.util.Scanner;
import org.jsp.merchantproductuni.MerchProdConfig;
import org.jsp.merchantproductuni.dao.MerchantDao;
import org.jsp.merchantproductuni.dao.ProductDao;
import org.jsp.merchantproductuni.dto.Merchant;
import org.jsp.merchantproductuni.dto.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MerchProdController {
	static MerchantDao dao;
	static ProductDao dao1;
	static ApplicationContext context;
	static Scanner sc=new Scanner(System.in);
	static {
		context=new AnnotationConfigApplicationContext(MerchProdConfig.class);
		dao=context.getBean(MerchantDao.class);
		dao1=context.getBean(ProductDao.class);
	}
	public static void main(String[] args) {
		boolean b = true;
		while (b) {
			System.out.println("1.Save Merchant");
			System.out.println("2.Update Merchant");
			System.out.println("3.Add Product");
			System.out.println("4.Update Product");
			System.out.println("5.Find Product By Merchant Id");
			System.out.println("6.Find Products By Category");
			System.out.println("7.Find Products By Brand");
			System.out.println("8.Verify Merchant by phone and password");
			System.out.println("9.Verify Merchant by email and password");
			System.out.println("10.Find All Products");
			System.out.println("Enter Your Choice");
			switch (sc.nextInt()) {
			   case 1: {
				  saveMerchant();
				  break;
			   }
			   case 2: {
				  updateMerchant();
				  break;
			   }
			   case 3: {
				  addProduct();
				  break;
			   }
			   case 4: {
				  updateProduct();
				  break;
			   }
			   case 5: {
				   findProdByMerchId();
				  break;
			   }
			   case 6: {
				  verifyProdByCategory();
				  break;
			   }
			   case 7:{
				  verifyProdByBrand();
				  break;
			   }
			   case 8: {
				  verifyByPhone();
				  break;
			   }
			   case 9:{
				  verifyByEmail();
				  break;
			   }
			   case 10:{
				  findAll();
				  break;
			   }
			   default: {
				  System.out.println("Thank You!!!Application Closed");
				  ((AnnotationConfigApplicationContext) context).close();
				  b = false;
			   }
			}
		}
	}
	public static void saveMerchant() {
		System.out.println("Enter Your name,phone,email,gst and password to register");
		Merchant m = new Merchant();
		m.setName(sc.next());
		m.setPhone(sc.nextLong());
		m.setEmail(sc.next());
		m.setGst(sc.next());
		m.setPassword(sc.next());
		m = dao.saveMerchant(m);
		System.out.println("Merchant saved with Id:" + m.getId());
	}

	public static void updateMerchant() {
		System.out.println("Enter the Merchant Id to update");
		int id = sc.nextInt();
		System.out.println("Enter Your name,phone,email,gst and password to register");
		Merchant m = new Merchant();
		m.setId(id);
		m.setName(sc.next());
		m.setPhone(sc.nextLong());
		m.setEmail(sc.next());
		m.setGst(sc.next());
		m.setPassword(sc.next());
		m = dao.updateMerchant(m);
		System.out.println("Merchant  Updated with Id:"+m.getId());
	}
	
	public static void addProduct() {
		Product p = new Product();
		System.out.println("Enter the Merchant id to add Product");
		int mid= sc.nextInt();
    	System.out.println("Enter the name,brand,description,category and cost");
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setDescription(sc.next());
		p.setCategory(sc.next());
		p.setCost(sc.nextDouble());
		p=dao1.addProduct(p, mid);
		if (p != null)
			System.out.println("Product add with Id:" + p.getId());
		else
			System.err.println("Invalid Merchant Id");
	}

	public static void updateProduct() {
		Product p=new Product();
		System.out.println("Enter the merchant id to update");
		int mid = sc.nextInt();
		System.out.println("Enter the name,brand,description,category and cost");
		p.setId(sc.nextInt());
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setDescription(sc.next());
		p.setCategory(sc.next());
		p.setCost(sc.nextDouble());
		p=dao1.updateProduct(p, mid);
		if (p != null)
			System.out.println("Product updated with Id:" + p.getId());
		else
			System.err.println("Invalid Merchant Id");

	}
	public static void findProdByMerchId() {
		System.out.println("Enter the Merchant id to find Product");
		int mid = sc.nextInt();
		List<Product> product = dao1.findByMerchantId(mid);
		if (product.size() > 0) {
			for (Product p : product) {
				System.out.println("Product Id:" + p.getId());
				System.out.println("Product name:" + p.getName());
				System.out.println("Brand:"+p.getBrand());
				System.out.println("category:"+p.getCategory());
				System.out.println("Description:"+p.getDescription());
				System.out.println("Cost:"+p.getCost());
				System.out.println("------------------------------");
			}
		} else {
			System.err.println("Invalid Merchant id");
		}
	}
	
	public static void verifyProdByCategory() {
		System.out.println("Enter Your category");
		String category = sc.next();
		List<Product> product=dao1.findByCategory(category);
		if (product.size() > 0) {
			for (Product p : product) {
				System.out.println("Product Id:" + p.getId());
				System.out.println("Product name:" + p.getName());
				System.out.println("Brand:"+p.getBrand());
				System.out.println("category:"+p.getCategory());
				System.out.println("Description:"+p.getDescription());
				System.out.println("Cost:"+p.getCost());
				System.out.println("------------------------------");
			}
		} 
		else {
			System.err.println("Invalid Product category");
		}	
	}
	
	public static void verifyProdByBrand() {
		System.out.println("Enter Your brand");
		String brand = sc.next();
		List<Product> product=dao1.findByBrand(brand);
		if (product.size() > 0) {
			for (Product p : product) {
				System.out.println("Product Id:" + p.getId());
				System.out.println("Product name:" + p.getName());
				System.out.println("Brand:"+p.getBrand());
				System.out.println("category:"+p.getCategory());
				System.out.println("Description:"+p.getDescription());
				System.out.println("Cost:"+p.getCost());
				System.out.println("------------------------------");
			}
		} 
		else {
			System.err.println("Invalid Product brand");
		}	
	}

	public static void verifyByPhone() {
		System.out.println("Enter Your Phone Number and password to verify");
		long phone = sc.nextLong();
		String password = sc.next();
		Merchant m = dao.verifyMerchantPP(phone, password);
		if (m != null) {
			System.out.println("Merchant Verified Succesfully");
			System.out.println("Merchant id:" + m.getId());
			System.out.println("Merchant Name:" + m.getName());
			System.out.println("Phone Number:" + m.getPhone());
			System.out.println("Email:" + m.getEmail());
			System.out.println("Gst:"+m.getGst());
			System.out.println("--------------------------");
		} else {
			System.err.println("Invalid Phone Number or Password");
		}
	}

	public static void verifyByEmail() {
		System.out.println("Enter Your Email and password to verify");
		String email = sc.next();
		String password = sc.next();
		Merchant m = dao.verifyMerchantEP(email, password);
		if (m != null) {
			System.out.println("Merchant Verified Succesfully");
			System.out.println("Merchant id:" + m.getId());
			System.out.println("Merchant Name:" + m.getName());
			System.out.println("Phone Number:" + m.getPhone());
			System.out.println("Email:" + m.getEmail());
			System.out.println("Gst:"+m.getGst());
			System.out.println("--------------------------");
		} else {
			System.err.println("Invalid Email or Password");
		}
	}
	
	public static void findAll() {
		System.out.println("Display Product details");
		List<Product> product=dao1.findAll();
		if (product.size() > 0) {
			for (Product p : product) {
				System.out.println("Product Id:" + p.getId());
				System.out.println("Product name:" + p.getName());
				System.out.println("Brand:"+p.getBrand());
				System.out.println("category:"+p.getCategory());
				System.out.println("Description:"+p.getDescription());
				System.out.println("Cost:"+p.getCost());
				System.out.println("------------------------------");
			}
		} 
		else {
			System.err.println("Null");
		}	
	}
}
