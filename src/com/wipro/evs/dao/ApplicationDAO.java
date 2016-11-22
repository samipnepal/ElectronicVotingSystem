package com.wipro.evs.dao;

import java.util.ArrayList;

import com.wipro.evs.bean.ApplicationBean;

public interface ApplicationDAO {
	String createApplication(ApplicationBean aBean );
	ArrayList<ApplicationBean> viewAllAdminPendingApplications();
	boolean forwardVoterIDRequest(String userId);
	ArrayList<ApplicationBean> viewAllVoterIdApplications();
	String updateApplication(ApplicationBean aBean);
	ApplicationBean findApplication(String userID);

}
