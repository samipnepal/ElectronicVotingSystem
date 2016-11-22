package com.wipro.evs.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wipro.evs.bean.ProfileBean;
import com.wipro.evs.dao.ProfileDAO;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.impl.DBUtilImpl;

public class ProfileDAOImpl implements ProfileDAO {
	DBUtil db = new DBUtilImpl();

	@Override
	public ProfileBean findByID(String pid) {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		ProfileBean pbean = (ProfileBean) session.get(ProfileBean.class, pid);
		return pbean;
	}

}
