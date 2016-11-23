package com.niit.shoppingcart.dao;

import java.util.List;
import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Product;	
@EnableTransactionManagement
@Repository(value="ProductDAO")

public class ProductDAOImpl implements ProductDAO {

	private static final Query SessionFactory = null;
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}
   @Transactional
	public boolean save(Product product) {
		try {
			//sessionFactory.getCurrentSession().save(category);
			Session s=sessionFactory.getCurrentSession();
			System.out.println("in test 1");
		    s.save(product);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
   @Transactional
	public boolean update(Product product) {
		try {
			//sessionFactory.getCurrentSession().update(category);
			Session s=sessionFactory.getCurrentSession();
			System.out.println("in test 2");
			s.update(product);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
@Transactional
	public boolean delete(Product product) {
		try {
			//sessionFactory.getCurrentSession().delete(category);
			Session s=sessionFactory.getCurrentSession();
			System.out.println("in test 3");
			s.delete(product);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}

	}
@Transactional
	public Product get(String id) {

		String hql = "from Product where id=" + "'" + id + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}
@SuppressWarnings("unchecked")
@Transactional
	public List<Product> list() {
		String hql = "from Product";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}
}
		





