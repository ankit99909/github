package com.niit.chinesefoodBankend.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Transactional
@Repository("categoryRepository")
public class CategoryRepositoryImpl implements CategoryRepository {

		@Autowired
		public SessionFactory sessionFactory;
		public boolean addCategory(Category category) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			try {
				session.save(category);
				return true;
			}
			catch (HibernateException e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}

		public boolean updateCategory(Category category) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			try{
			session.update(category);
			return true;
			}
			catch(HibernateException e)
			{
				e.printStackTrace();
				return false;
			}
			}

		public boolean deleteCategory(int categoryId) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			try{
			session.delete(getCategoryById(categoryId));
			return true;
			}
			catch(HibernateException e)
			{
				e.printStackTrace();
			
			return false;
			}
		}

		public List<Category> getAllCategory() {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			try{
		Query query=session.createQuery("from Category");
			List<Category> categoryList=(List<Category>)query.getResultList();
			return categoryList;
			}
			catch(HibernateException e)
			{
				e.printStackTrace();
			
			return null;
			}
		}

		public Category getCategoryById(int categoryId) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			try{
		    Category category=(Category)session.get(Category.class,categoryId);
			return category;
			}
			catch(HibernateException e)
			{
				e.printStackTrace();
				return null;
			}
		
		}

		

	}

