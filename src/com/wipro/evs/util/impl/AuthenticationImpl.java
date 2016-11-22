package com.wipro.evs.util.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.util.Authentication;
import com.wipro.evs.util.DBUtil;


public class AuthenticationImpl implements Authentication {
	DBUtil db = new DBUtilImpl();
	

	
	@Override
	public boolean authenticate(CredentialsBean cbean) {
		CredentialsBean cb;
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		cb = (CredentialsBean) session.get(CredentialsBean.class, cbean.getUserID());
		if (cb == null)
			return false;
		if (cb.getUserID().equals(cbean.getUserID()) && cb.getPassword().equals(cbean.getPassword()))
			return true;
		else
			return false;
	}

	@Override
	public String authorize(String userId) {
		CredentialsBean cb;
			Session session = db.getDBConnection().openSession();
			Transaction tx = session.beginTransaction();
			cb = (CredentialsBean) session.get(CredentialsBean.class, userId);
			if (cb.getLoginStatus() == 1) {
				return "FAIL";
			}
			changeLoginStatus(cb, 1);
			return cb.getUserType();
	}
	@Override
	public boolean changeLoginStatus(CredentialsBean user, int loginStatus) {
		CredentialsBean cb = new CredentialsBean();
		try {
			Session session = db.getDBConnection().openSession();
			Transaction tx = session.beginTransaction();
			cb = (CredentialsBean) session.get(CredentialsBean.class, user.getUserID());
			cb.setLoginStatus(loginStatus);
			session.update(cb);
			tx.commit();
		} catch (Throwable e) {
			return false;
		}
		return true;
	}

}
