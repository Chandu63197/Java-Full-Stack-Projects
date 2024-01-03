package org.jsp.adminhospital.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.jsp.adminhospital.dto.Admin;
import org.jsp.adminhospital.dto.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDao {
	
	@Autowired
  	public EntityManager manager;
	
	public Hospital addHospital(Hospital hospital,int aid) {
		Admin a=manager.find(Admin.class, aid);
		if(a!=null) {
			EntityTransaction transaction=manager.getTransaction();
			a.getHospital().add(hospital);
			hospital.setAdmin(a);
			manager.persist(hospital);
			transaction.begin();
			transaction.commit();
			return hospital;
		}
		return null;
	}
	
	public Hospital updateHospital(Hospital hospital,int aid) {
		Admin a=manager.find(Admin.class, aid);
		if(a!=null) {
			EntityTransaction transaction=manager.getTransaction();
			hospital.setAdmin(a);
			a.getHospital().add(hospital);
			manager.merge(hospital);
			transaction.begin();
			transaction.commit();
			return hospital;
		}
		return null;
	}
	
	public List<Hospital> findByAdminId(int id){
		String qry="select a.hospital from Admin a where a.id=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, id);
		return q.getResultList();
	}
	
	public List<Hospital> findByName(String name){
		String qry="select h from Hospital h where h.name=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, name);
		return q.getResultList();
	}
 

}