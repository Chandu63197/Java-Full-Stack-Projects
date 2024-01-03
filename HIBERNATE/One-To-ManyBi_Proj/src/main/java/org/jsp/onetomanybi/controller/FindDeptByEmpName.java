package org.jsp.onetomanybi.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.onetomanybi.dto.Department;
import org.jsp.onetomanybi.dto.Employee;
public class FindDeptByEmpName {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employee Name to find the Department");
		String name = sc.next();
		String qry1 = "select e.dept from Employee e where e.name=?1";
		Query q = manager.createQuery(qry1);
		q.setParameter(1, name);
		List<Department> dept=q.getResultList();
		if(dept.size()>0) {
			for(Department d:dept) {
				System.out.println("Department id:" + d.getId());
				System.out.println("Department Name:" + d.getName());
				System.out.println("Department LOcation:" + d.getLocation());
				System.out.println("-----*****-----");
			}
		}
		else{
			System.out.println("Invalid department id");
		}
	}
}
