package org.jsp.onetomanyuni.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.onetomanyuni.dto.Answer;
import org.jsp.onetomanyuni.dto.Question;
public class SaveQuestionAndAnswer {
   public static void main(String[] args) {
	 EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	 EntityTransaction transaction=manager.getTransaction();
	 Question q=new Question();
	 q.setQuestion("what is hibernate");
	 q.setQuestionBy("Sathish");
	 Answer a1=new Answer();
	 a1.setAnswer("hibernate is an open source");
	 a1.setAnsweredBy("Anisha");
	 Answer a2=new Answer();
	 a2.setAnswer("hibernate is an open source,non-invasive,light-weight ORM tool");
	 a2.setAnsweredBy("Bhumika");
	 Answer a3=new Answer();
	 a3.setAnswer("hibernate is a framework");
	 a3.setAnsweredBy("Anas");
	 List<Answer>answers=new ArrayList<Answer>();
	 answers.add(a1);
	 answers.add(a2);
	 answers.add(a3);
	 q.setAnswers(answers);
	 manager.persist(q);
	 transaction.begin();
	 transaction.commit();
   }
}
