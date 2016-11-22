package com.wipro.evs.util.impl;

import java.math.BigInteger;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;
import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.bean.ProfileBean;
import com.wipro.evs.util.Authentication;
import com.wipro.evs.util.User;

public class UserImpl implements User {
	Authentication auimpl = new AuthenticationImpl();
	HttpSession httpsession;

	DBUtilImpl dbu = new DBUtilImpl();

	@Override
	public String login(CredentialsBean credentialsBean) {
		boolean flag = auimpl.authenticate(credentialsBean);
		if (flag) {
			String type = auimpl.authorize(credentialsBean.getUserID());
			return type;
		} else
			return "INVALID";
	}

	@Override
	public boolean logout(String userId) {
		CredentialsBean cb = new CredentialsBean();
		cb.setUserID(userId);
		boolean flag = auimpl.changeLoginStatus(cb, 0);
		return flag;
	}

	@Override
	public String changePassword(CredentialsBean cbean, String password) {
		CredentialsBean cb = new CredentialsBean();
		Session session = dbu.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		cb = (CredentialsBean) session.get(CredentialsBean.class,
				cbean.getUserID());

		if (cbean.getPassword().equals(cb.getPassword())) {
			cb.setPassword(password);
			cb.setLoginStatus(0);
			session.update(cb);
			tx.commit();
			return "SUCCESS";
		}

		else {
			return "INVALID";
		}

	}

	@Override
	public String register(ProfileBean profileBean) {
		Session session = dbu.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		Object obj = null;
		Object obj1 = null;
		try {

			CredentialsBean cb = new CredentialsBean();
			Query query = session.createSQLQuery(
					"select evs_seq_userid.nextval as num from dual")
					.addScalar("num", StandardBasicTypes.BIG_INTEGER);
			long id = ((BigInteger) query.uniqueResult()).longValue();
			profileBean.setUserID(profileBean.getFirstName().substring(0, 2)
					.toUpperCase()
					+ String.valueOf(id));
			cb.setUserID(profileBean.getUserID());
			cb.setPassword(profileBean.getPassword());
			cb.setLoginStatus(0);
			cb.setUserType("V");
			obj = session.save(cb);
			obj1 = session.save(profileBean);
			tx.commit();
		} catch (Throwable e) {
			tx.rollback();
		}
		if (obj1 == null || obj == null)
			return "FAIL";
		else
			return profileBean.getUserID();
	}

}
