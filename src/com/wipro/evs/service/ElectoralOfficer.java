package com.wipro.evs.service;

import java.util.ArrayList;

import com.wipro.evs.bean.ApplicationBean;

public interface ElectoralOfficer {
	String generateVoterId(String userId, String status);
	ArrayList<ApplicationBean> viewAllVoterIdApplications();
}
