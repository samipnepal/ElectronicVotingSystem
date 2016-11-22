package com.wipro.evs.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EVS_TBL_User_Credentials")
public class CredentialsBean {
	
	@Id
	@Column(name="userid")
	private String userID;

	@Column(name="password")
	private String password;
	
	@Column(name="usertype")
	private String userType;
	
	@Column(name="loginstatus")
	private int loginStatus;
	
	/*@OneToOne
    @JoinColumn(name = "userid")
	private ProfileBean pbean;
	
	public ProfileBean getPbean() {
		return pbean;
	}
	public void setPbean(ProfileBean pbean) {
		this.pbean = pbean;
	}*/
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
	public CredentialsBean() {
	}

}
