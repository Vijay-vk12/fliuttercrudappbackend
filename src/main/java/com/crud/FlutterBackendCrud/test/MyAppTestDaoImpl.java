package com.crud.FlutterBackendCrud.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MyAppTestDaoImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean saveData(MyAppTestEntity myAppTestEntity) {
		Boolean isSave = false;
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			
			try {
				session.save(myAppTestEntity);
				isSave = true;
				tx.commit();
			} catch (Exception e) {
				isSave = false;
				tx.rollback();
				e.printStackTrace();
			}
			return isSave;
		}
	}

}
