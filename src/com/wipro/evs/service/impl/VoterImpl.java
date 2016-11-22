package com.wipro.evs.service.impl;

import java.util.ArrayList;


import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;

import com.wipro.evs.bean.ResultBean;
import com.wipro.evs.dao.ApplicationDAO;
import com.wipro.evs.dao.CandidateDAO;
import com.wipro.evs.dao.ElectionDAO;
import com.wipro.evs.dao.VoterDAO;
import com.wipro.evs.dao.impl.ApplicationDAOImpl;
import com.wipro.evs.dao.impl.CandidateDAOImpl;
import com.wipro.evs.dao.impl.ElectionDAOImpl;
import com.wipro.evs.dao.impl.VoterDAOImpl;
import com.wipro.evs.service.Voter;

public class VoterImpl implements Voter {
	ElectionDAO ed=new ElectionDAOImpl();
	CandidateDAO cd=new CandidateDAOImpl();
	VoterDAO vd=new VoterDAOImpl();
	ApplicationDAO ad=new ApplicationDAOImpl();

	

	@Override
	public String castVote(String userId, String electionId, String candiadteId) {
		ResultBean rBean=new ResultBean();
		rBean.setCandidateID(candiadteId);
		rBean.setElectionID(electionId);
		rBean.setVoteCount(1);
		String result=vd.castVote(rBean);
		return result;
	}

	@Override
	public ArrayList<CandidateBean> viewCandidatesByElectionName(String electionName) {
		ArrayList<CandidateBean> array=new ArrayList<>();
		array=cd.viewCandidateDetailsByElectionName(electionName);
		return array;
	}

	@Override
	public ArrayList<ResultBean> viewListOfElectionsResults() {

		return null;
	}

	@Override
	public String requestVoterId(ApplicationBean aBean) {
		
		String result=ad.createApplication(aBean);
		return result;
		
	}

	@Override
	public ApplicationBean viewGeneratedVoterId(String userId) {
		ApplicationBean aBean=vd.viewVoterId(userId);
				return aBean;
	}

	@Override
	public ArrayList<ElectionBean> viewListOfElections() {
		ArrayList<ElectionBean> list=ed.upcomingElection();
		return list;
	}

	@Override
	public ArrayList<ElectionBean> viewCurrentElections() {
		ArrayList<ElectionBean>  array=vd.viewCurrentElections();
		return array;
	}





	

}
