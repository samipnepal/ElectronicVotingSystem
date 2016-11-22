package com.wipro.evs.service.impl;

import java.util.ArrayList;
import java.util.Map;







import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.PartyBean;
import com.wipro.evs.bean.ProfileBean;
import com.wipro.evs.dao.ApplicationDAO;
import com.wipro.evs.dao.CandidateDAO;
import com.wipro.evs.dao.ElectionDAO;
import com.wipro.evs.dao.PartyDAO;
import com.wipro.evs.dao.VoterDAO;
import com.wipro.evs.dao.impl.ApplicationDAOImpl;
import com.wipro.evs.dao.impl.CandidateDAOImpl;
import com.wipro.evs.dao.impl.ElectionDAOImpl;
import com.wipro.evs.dao.impl.PartyDAOImpl;
import com.wipro.evs.dao.impl.VoterDAOImpl;
import com.wipro.evs.service.Administrator;

public class AdministratorImpl implements Administrator {
	ElectionDAO ed=new ElectionDAOImpl();
	PartyDAO pd=new PartyDAOImpl();
	CandidateDAO cd=new CandidateDAOImpl();
	VoterDAO vd=new VoterDAOImpl();
	ApplicationDAO ad=new ApplicationDAOImpl();
	@Override
	public String addElection(ElectionBean electionBean) {
		electionBean.setElectionID(ed.getElectionSeq());
		String result=ed.createElection(electionBean);
		return result;
	}

	@Override
	public ArrayList<ElectionBean> viewAllUpcomingElections() {
		ArrayList<ElectionBean> array=new ArrayList<ElectionBean>();
		array=ed.upcomingElection();
		return array;
	}
	@Override
	public ArrayList<ElectionBean> viewElections() {
		ArrayList<ElectionBean> array=new ArrayList<ElectionBean>();
		array=ed.findAll();
		return array;
	}
	@Override
	public String addParty(PartyBean partyBean) {
		partyBean.setPartyID(partyBean.getName().substring(0,2).toUpperCase()+pd.getPartySeq());
		String result=pd.createParty(partyBean);
		return result;
	}

	@Override
	public ArrayList<PartyBean> viewAllParty() {
		ArrayList<PartyBean> array=new ArrayList<PartyBean>();
		array=pd.findAll();
		return array;
	}

	@Override
	public String addCandidate(CandidateBean candidateBean) {
		String id= cd.generateCandidateSeq();
		candidateBean.setCandidateID(id);
		String result=cd.createCandidate(candidateBean);
		return result;
	}

	@Override
	public ArrayList<CandidateBean> viewCandidateDetailsByElectionName(String electionName) {
		ArrayList<CandidateBean> list=cd.viewCandidateDetailsByElectionName(electionName);
		return list;
	}

	@Override
	public ArrayList<ApplicationBean> viewAllAdminPendingApplications() {
		ArrayList<ApplicationBean> list=ad.viewAllAdminPendingApplications();
		return list;
	}

	@Override
	public boolean forwardVoterIDRequest(String userId) {
		boolean flag=ad.forwardVoterIDRequest(userId);
		return flag;
	}

	@Override
	public ArrayList<CandidateBean> viewCandidateDetailsByParty(String partyId) {
	
		return null;
	}

	@Override
	public Map<?, ?> approveElectionResults(String electionId) {

		return null;
	}

	@Override
	public ProfileBean getProfile() {
		// TODO Auto-generated method stub
		return null;
	}

}
