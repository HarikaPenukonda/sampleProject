package com.niit.shoppingcart.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.UserDetails;	
@Repository(value="UserDetailsDAO")

public class UserDetailsDAOImpl implements UserDetailsDAO {

	private static final Query SessionFactory = null;
	@Autowired
	private SessionFactory sessionFactory;

	public UserDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}
   @Transactional
	public boolean save(UserDetails userDetails) {
		try {
			//sessionFactory.getCurrentSession().save(category);
			Session s=sessionFactory.getCurrentSession();
			System.out.println("in test 1");
			s.save(userDetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
   @Transactional
	public boolean update(UserDetails userDetails) {
		try {
			//sessionFactory.getCurrentSession().update(category);
			Session s=sessionFactory.getCurrentSession();
			System.out.println("in test 2");
			s.update(userDetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
@Transactional
	public boolean delete(UserDetails userDetails) {
		try {
			//sessionFactory.getCurrentSession().delete(category);
			Session s=sessionFactory.getCurrentSession();
			System.out.println("in test 3");
			s.delete(userDetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
@Transactional
	public UserDetails get(String id) {

		String hql = "from UserDetails where id='" +id + "'"; System.out.println("inside get");
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}
   
  @Transactional
  public UserDetails isValidUser(String name, String password)
  {
	  
	  //select * UserDetails where id = '101' and password = 'niit'
	  String hql = "from UserDetails where name = '" +name+ "' and password= '" +password + "'";
	 
	  Query query = sessionFactory.getCurrentSession().createQuery(hql);
	  List<UserDetails> list = query.list();
	  
	  if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}
@Transactional
	public List<UserDetails> list() {
		String hql = "from UserDetails";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}


}
		









