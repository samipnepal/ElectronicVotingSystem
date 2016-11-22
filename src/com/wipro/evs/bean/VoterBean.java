package com.wipro.evs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EVS_TBL_Voter_Details")
public class VoterBean {
	
	@Id
	private int serialNo;
	private String candidateID;
	private String Electionid;
	private String Voterid;
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getCandidateID() {
		return candidateID;
	}
	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}
	public String getElectionid() {
		return Electionid;
	}
	public void setElectionid(String electionid) {
		Electionid = electionid;
	}
	public String getVoterid() {
		return Voterid;
	}
	public void setVoterid(String voterid) {
		Voterid = voterid;
	}
	
	
	

}
