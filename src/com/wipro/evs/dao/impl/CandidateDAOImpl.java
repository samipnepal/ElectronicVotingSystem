package com.wipro.evs.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.dao.CandidateDAO;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.impl.DBUtilImpl;

public class CandidateDAOImpl implements CandidateDAO { 
	DBUtil db = new DBUtilImpl();
	ArrayList<CandidateBean> array=new ArrayList<CandidateBean>();

	@Override
	public String createCandidate(CandidateBean cbean) {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		Object obj = null;
		try {
			obj = session.save(cbean);
		} catch (Throwable e) {
			tx.rollback();
			System.out.println(e);
			return "ERROR";
		}
		if (obj != null) {
			tx.commit();
			return "SUCCESS";
		} else
			return "FAIL";

	}

	@Override
	public int deleteCandidate(ArrayList<String> plist) {
		return 0;
	}

	@Override
	public boolean updateCandidate(CandidateBean cbean) {
		return false;
	}

	@Override
	public CandidateBean findByID(String pid) {
		return null;
	}

	@Override
	public String generateCandidateSeq() {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery("select evs_seq_candidateId.nextval as num from dual").addScalar("num",
				StandardBasicTypes.BIG_INTEGER);
		long id = ((BigInteger) query.uniqueResult()).longValue();
		return String.valueOf(id);
	}

	@Override
	public ArrayList<CandidateBean> viewCandidateDetailsByElectionName(String electionid) {
		Session session = db.getDBConnection().openSession();
		Transaction tx = session.beginTransaction(); 
		Query query = session.createSQLQuery
		("select * FROM EVS_TBL_candidate WHERE electionID = :electid" )
		.addEntity(CandidateBean.class);
		query.setString("electid", electionid);
		array=(ArrayList<CandidateBean>) query.list();	
		return array;
	}


}
