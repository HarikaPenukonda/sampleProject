package com.niit.shoppingcart.dao;

import java.util.List;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;

@EnableTransactionManagement
@Repository(value = "categoryDAO")

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public boolean save(Category category) {
		// TODO Auto-generated method stub
		try {
			Session s = sessionFactory.getCurrentSession();
			// Transaction tx=s.beginTransaction();
			
			s.save(category);
			System.out.println("The Category got added Succesfully ");
			 //tx.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try {
			Session s = sessionFactory.getCurrentSession();

			
			s.update(category);
			System.out.println("The Category got updated successfully");

			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		try {
			Session s = sessionFactory.getCurrentSession();

			s.delete(category);
			System.out.println("The Category is deleted sucessfully");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public Category get(String id) {
		// TODO Auto-generated method stub
		String hql = "from Category where id=" + "'" + id + "'";
		System.out.println(hql);
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list = query.list();
		System.out.println("test case");
		if (list == null)

			return null;
		else {
			System.out.println("Test case 4");
			return list.get(0);
		}

	}

	@Transactional
	public List<Category> list() {
		// TODO Auto-generated method stub
		String hql = "from Category";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

}
