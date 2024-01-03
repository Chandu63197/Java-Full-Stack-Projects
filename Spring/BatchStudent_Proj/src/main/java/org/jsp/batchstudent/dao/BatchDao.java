package org.jsp.batchstudent.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.jsp.batchstudent.dto.Batch;
import org.jsp.batchstudent.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BatchDao {
    @Autowired
	public EntityManager manager;

    public Batch saveBatch(Batch batches) {
    	EntityTransaction transaction=manager.getTransaction();
        manager.persist(batches);
        transaction.begin();
        transaction.commit();
        return batches;
    }
    
    public Batch updateBatch(Batch batches) {
    	EntityTransaction transaction=manager.getTransaction();
    	manager.merge(batches);
    	transaction.begin();
    	transaction.commit();
    	return batches;
    }
    
    public List<Batch> findByStudentId(int id){
		String qry="select b.students from Batch b where b.id=?1";
		//String qry1="select b from Batch b where b.students.id=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, id);
		return q.getResultList();
	}
    
    public List<Batch> findByStudentPhone(long phone){
		String qry="select b.students from Batch b where b.phone=?1";
		//String qry1="select b from Batch b where b.students.phone=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1,phone);
		return q.getResultList();
	}    
}
