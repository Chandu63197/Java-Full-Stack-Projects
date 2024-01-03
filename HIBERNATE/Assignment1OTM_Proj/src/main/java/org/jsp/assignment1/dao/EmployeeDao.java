package org.jsp.assignment1.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.assignment1.dto.Employee;
public class EmployeeDao {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	public Employee saveEmployee(Employee e) {
		manager.persist(e); 
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
		return e;
	}
	public Employee updateEmployee(Employee e) {
		manager.merge(e); 
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
		return e;
	}
	public List<Employee> FindEmpByDeptId(int id) {
		String hql="select e from Employee e where e.dept.id=?1";
		Query q=manager.createQuery(hql);
		q.setParameter(1, id);
		return q.getResultList();
	}
	public List<Employee> FindEmpByDeptName(String name) {
		String hql="select e from Employee e where e.dept.name=?1";
		Query q=manager.createQuery(hql);
		q.setParameter(1, name);
		return q.getResultList();
	}
	public Employee VerifyEmployee(long phone, String password) {
		String hql = "select e from Employee e where e.phone=?1 and e.password=?2";
		Query q = manager.createQuery(hql);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		return (Employee) q.getSingleResult();
	}
	public Employee VerifyEmployee(int id, String password) {
		String hql = "select e from Employee e where e.id=?1 and e.password=?2";
		Query q = manager.createQuery(hql);
		q.setParameter(1, id);
		q.setParameter(2, password);
		return (Employee) q.getSingleResult();
	}
	public Employee VerifyEmployee(String email,String password) {
		String hql = "select e from Employee e where e.email=?1 and e.password=?2";
		Query q = manager.createQuery(hql);
		q.setParameter(1, email);
		q.setParameter(2, password);
		return (Employee) q.getResultList();
	} 
}
