package com.wipro.evs.service;

import java.util.ArrayList;
import java.util.Map;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.PartyBean;
import com.wipro.evs.bean.ProfileBean;

public interface Administrator {
	String addElection(ElectionBean electionBean);
	ArrayList<ElectionBean> viewAllUpcomingElections();
	ArrayList<ElectionBean> viewElections();
	String addParty(PartyBean partyBean);
	ArrayList<PartyBean> viewAllParty();
	String addCandidate(CandidateBean candidateBean);
	ArrayList<CandidateBean> viewCandidateDetailsByElectionName(String electionName);
	ArrayList<ApplicationBean> viewAllAdminPendingApplications();
	boolean forwardVoterIDRequest(String userId);
	ArrayList<CandidateBean> viewCandidateDetailsByParty(String partyId);
	Map approveElectionResults(String electionId);
	ProfileBean getProfile();
}
