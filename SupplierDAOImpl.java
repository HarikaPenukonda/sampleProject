package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Supplier;	
@Repository(value="SupplierDAO")

public class SupplierDAOImpl implements SupplierDAO {

	//private static final Query SessionFactory;
	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}
   @Transactional
	public boolean save(Supplier supplier) {
		try {
			//sessionFactory.getCurrentSession().save(category);
			Session s=sessionFactory.getCurrentSession();
			System.out.println("in test 1");
			s.save(supplier);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
   @Transactional
	public boolean update(Supplier supplier) {
		try {
			//sessionFactory.getCurrentSession().update(category);
			Session s=sessionFactory.getCurrentSession();
		
			s.update(supplier);
			System.out.println("in test 2");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
@Transactional
	public boolean delete(Supplier supplier) {
		try {
			//sessionFactory.getCurrentSession().delete(category);
			Session s=sessionFactory.getCurrentSession();
			
			s.delete(supplier);
			System.out.println("in test 3");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
@SuppressWarnings("unchecked")
@Transactional
	public Supplier get(String id) {

		String hql = "from Supplier where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}
@SuppressWarnings("unchecked")
@Transactional
	public List<Supplier> list() {
		String hql = "from Supplier";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}
}
		





