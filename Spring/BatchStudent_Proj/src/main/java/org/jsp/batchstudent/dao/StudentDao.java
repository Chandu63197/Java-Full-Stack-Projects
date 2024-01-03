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
public class StudentDao {
	@Autowired
	public EntityManager manager;

	public Student addStudent(Student student,int bid) {
		Batch b=manager.find(Batch.class, bid);
		if(b!=null) {
			EntityTransaction transaction=manager.getTransaction();
			//student.setBatches((List<Batch>) b);
			b.getStudents().add(student);
			manager.persist(student);
			transaction.begin();
			transaction.commit();
			return student;
		}
		return null;
	}
	
	public Student updateStudent(Student student,int bid) {
		Batch b=manager.find(Batch.class, bid);
		if(b!=null) {
			EntityTransaction transaction=manager.getTransaction();
			b.getStudents().add(student);
			//student.setBatches((List<Batch>) b);
			manager.merge(student);
			transaction.begin();
			transaction.commit();
			return student;
		}
		return null;
	}
	

	public List<Student> findByBatchId(int id) {
		String qry = "select b.students from Batch b where b.id=?1";
		//String qry1 = "select b from Batch b where b.students.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		return q.getResultList();
	}

	public List<Student> findByBatchCode(String code) {
		String qry = "select b.students from Batch b where b.batchcode=?1";
		//String qry1 = "select b from Batch b where b.students.batchcode=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, code);
		return q.getResultList();
	}

	public List<Student> findByBatchTrainer(String trainer) {
		String qry = "select b.students from Batch b where b.trainer=?1";
		//String qry1 = "select b from Batch b where b.students.trainer=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1,trainer);
		return q.getResultList();
	}
	
	public List<Student> findBySubject(String subject) {
		String qry = "select b.students from Batch b where b.subject=?1";
		//String qry1 = "select b from Batch b where b.students.subject=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1,subject);
		return q.getResultList();
	}
}
