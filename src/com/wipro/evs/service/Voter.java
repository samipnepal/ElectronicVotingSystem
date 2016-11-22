package com.wipro.evs.service;

import java.util.ArrayList;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.ResultBean;

public interface Voter {
	String castVote(String userId, String electionId, String candiadteId);
	ArrayList<CandidateBean> viewCandidatesByElectionName(String electionName);
	ArrayList<ResultBean> viewListOfElectionsResults();
	String requestVoterId(ApplicationBean aBean);
	ApplicationBean viewGeneratedVoterId(String userId);
	ArrayList<ElectionBean> viewListOfElections();
	ArrayList<ElectionBean> viewCurrentElections();
	
	
}
