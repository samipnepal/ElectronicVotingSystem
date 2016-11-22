package com.wipro.evs.dao.impl;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.PartyBean;
import com.wipro.evs.dao.ApplicationDAO;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.impl.DBUtilImpl;

public class ApplicationDAOImpl implements ApplicationDAO {
	DBUtil db = new DBUtilImpl();
	@Override
	public String createApplication(ApplicationBean aBean) {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		Object obj = null;
		try {
			obj = session.save(aBean);
		} catch (Throwable e) {
			tx.rollback();
			return "ERROR";
		}
		if (obj != null) {
			tx.commit();
			return "SUCCESS";
		} else
			return "FAIL";
	}

	@Override
	public ArrayList<ApplicationBean> viewAllAdminPendingApplications() {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery("select * from EVS_TBL_Application WHERE Passedstatus = 1")
				.addEntity(ApplicationBean.class);
		ArrayList<ApplicationBean> array = (ArrayList<ApplicationBean>) query.list();
		return array;
	}

	@Override
	public boolean forwardVoterIDRequest(String userId) {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		try{
		ApplicationBean aBean=(ApplicationBean)session.get(ApplicationBean.class, userId);
		aBean.setPassedStatus(2);
		session.update(aBean);
		}catch(Throwable e){
			tx.rollback();
			return false;
		}
		tx.commit();
		return true;
		
	}

	@Override
	public ArrayList<ApplicationBean> viewAllVoterIdApplications() {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery("select * from EVS_TBL_Application WHERE Passedstatus = 2")
				.addEntity(ApplicationBean.class);
		ArrayList<ApplicationBean> array = (ArrayList<ApplicationBean>) query.list();
		return array;
	}

	@Override
	public String updateApplication(ApplicationBean aBean) {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(aBean);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			return "FAIL";
		} 
		return aBean.getVoterID();
	}

	@Override
	public ApplicationBean findApplication(String userID) {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		ApplicationBean aBean=(ApplicationBean)session.get(ApplicationBean.class, userID);
		return aBean;
	}

}
