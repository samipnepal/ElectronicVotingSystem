package com.wipro.evs.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="EVS_TBL_election")
public class ElectionBean {
	
	@Id
	private String electionID;
	private String name;
	private Date electionDate;
	private String district;
	private String constituency;
	private Date countingDate;
	public String getElectionID() {
		return electionID;
	}
	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getElectionDate() {
		return electionDate;
	}

	public void setElectionDate(Date electionDate) {
		this.electionDate = electionDate;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	public Date getCountingDate() {
		return countingDate;
	}

	public void setCountingDate(Date countingDate) {
		this.countingDate = countingDate;
	}

	public ElectionBean() {
	}
	

}
