package org.jsp.hibernatetemplate.dao;

import javax.transaction.Transactional;
import org.jsp.hibernatetemplate.dto.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class UserDao {
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
    
	@Transactional
	public User saveUser(User user) {
		template.save(user);
		return user;
	}
	
	@Transactional
	public User updateUser(User user) {
		template.update(user);
		return user;
	}

	
}
