package com.wipro.evs.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.ResultBean;
import com.wipro.evs.dao.VoterDAO;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.impl.DBUtilImpl;

public class VoterDAOImpl implements VoterDAO {
	DBUtil db = new DBUtilImpl();

	@Override
	public String generateVoterSeq() {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery(
				"select evs_seq_voterid.nextval as num from dual").addScalar(
				"num", StandardBasicTypes.BIG_INTEGER);
		long id = ((BigInteger) query.uniqueResult()).longValue();
		return String.valueOf(id);
	}

	@Override
	public ApplicationBean viewVoterId(String userID) {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		ApplicationBean aBean = (ApplicationBean) session.get(
				ApplicationBean.class, userID);
		return aBean;
	}

	@Override
	public ArrayList<ElectionBean> viewCurrentElections() {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction(); 
		Date date=new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		Query query = session.createSQLQuery
		("select * FROM EVS_TBL_election WHERE electiondate = :sqldate" )
		.addEntity(ElectionBean.class);
		query.setDate("sqldate", sqlDate);
		ArrayList<ElectionBean>  array=(ArrayList<ElectionBean>) query.list();
		return array;
	}

	@Override
	public String castVote(ResultBean rBean) {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		Object obj = null;
		try {
			obj = session.save(rBean);
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

	
}
