package com.wipro.evs.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import com.wipro.evs.bean.PartyBean;
import com.wipro.evs.dao.PartyDAO;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.impl.DBUtilImpl;

public class PartyDAOImpl implements PartyDAO {
	DBUtil db = new DBUtilImpl();
	ArrayList<PartyBean> list;

	@Override
	public String createParty(PartyBean pbean) {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		Object obj = null;
		try {
			obj = session.save(pbean);
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
	public int deleteParty(ArrayList<String> plist) {
		return 0;
	}

	@Override
	public boolean updateParty(PartyBean pbean) {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(pbean);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			return false;
		}
		return true;
	}

	@Override
	public PartyBean findByID(String pid) {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		PartyBean pbean = (PartyBean) session.get(PartyBean.class, pid);
		return pbean;
	}

	@Override
	public ArrayList<PartyBean> findAll() {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		list = (ArrayList<PartyBean>) session.createCriteria(PartyBean.class)
				.list();
		return list;
	}

	@Override
	public String getPartySeq() {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery(
				"select evs_seq_partyId.nextval as num from dual").addScalar(
				"num", StandardBasicTypes.BIG_INTEGER);
		long id = ((BigInteger) query.uniqueResult()).longValue();
		return String.valueOf(id);
	}

}
