package com.wipro.evs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EVS_TBL_Result")
public class ResultBean {
	@Id
	private int serialNo;
	private String electionID;
	private String candidateID;
	private int voteCount;
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getElectionID() {
		return electionID;
	}
	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}
	public String getCandidateID() {
		return candidateID;
	}
	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	public ResultBean() {
		// TODO Auto-generated constructor stub
	}
	

}
