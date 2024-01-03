package org.jsp.assignment1.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.assignment1.dto.Department;
public class DepartmentDao {
   EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
   public Department findById(int id) {
	   return manager.find(Department.class, id);
   }
   public Department saveDepartment(Department d) {
		manager.persist(d); 
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
		return d;
	}
	public Department updateDepartment(Department d) {
		manager.merge(d);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
		return d;
	}
}
