package com.wipro.evs.service.impl;

import java.util.ArrayList;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.dao.ApplicationDAO;
import com.wipro.evs.dao.VoterDAO;
import com.wipro.evs.dao.impl.ApplicationDAOImpl;
import com.wipro.evs.dao.impl.VoterDAOImpl;
import com.wipro.evs.service.ElectoralOfficer;

public class ElectrolOfficerImpl implements ElectoralOfficer {
	ApplicationDAO ad = new ApplicationDAOImpl();
	VoterDAO vd = new VoterDAOImpl();

	@Override
	public String generateVoterId(String userId, String status) {
		int a = Integer.parseInt(status);
		if (a == 1) {
			System.out.println("fsdf");
			ApplicationBean aBean =ad.findApplication(userId);
			aBean.setVoterID(aBean.getUserID().substring(0, 2).toUpperCase()+ aBean.getConstituency().substring(0, 2).toUpperCase()
					+ vd.generateVoterSeq());
			aBean.setPassedStatus(3);
			aBean.setApprovedStatus(1);
			String VoterID = ad.updateApplication(aBean);
			return VoterID;
		}
		else
		{
			ApplicationBean aBean = ad.findApplication(userId);
			aBean.setPassedStatus(3);
			aBean.setApprovedStatus(0);
			ad.updateApplication(aBean);
			return "REJECTED";
		}
	}

	@Override
	public ArrayList<ApplicationBean> viewAllVoterIdApplications() {
		ArrayList<ApplicationBean> list = ad.viewAllVoterIdApplications();
		return list;
	}

}
