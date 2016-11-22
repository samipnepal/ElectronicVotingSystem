package com.wipro.evs.dao;

import java.util.ArrayList;

import com.wipro.evs.bean.CandidateBean;



public interface CandidateDAO {
	String createCandidate(CandidateBean cbean );
	int deleteCandidate(ArrayList<String> plist);
	boolean updateCandidate(CandidateBean cbean);
	CandidateBean findByID(String pid);
	ArrayList<CandidateBean> viewCandidateDetailsByElectionName(String electionID);
	String generateCandidateSeq();

}
