package com.wipro.evs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EVS_TBL_Application")
public class ApplicationBean {
	@Id
	private String userID;
	private String constituency;
	private int passedStatus;
	private int approvedStatus;
	private String voterID;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public int getPassedStatus() {
		return passedStatus;
	}
	public void setPassedStatus(int passedStatus) {
		this.passedStatus = passedStatus;
	}
	public int getApprovedStatus() {
		return approvedStatus;
	}
	public void setApprovedStatus(int approvedStatus) {
		this.approvedStatus = approvedStatus;
	}
	public String getVoterID() {
		return voterID;
	}
	public void setVoterID(String voterID) {
		this.voterID = voterID;
	}
	public ApplicationBean() {
	}

}
