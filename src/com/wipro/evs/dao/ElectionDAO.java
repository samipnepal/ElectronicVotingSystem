package com.wipro.evs.dao;

import java.util.ArrayList;
import com.wipro.evs.bean.ElectionBean;

public interface ElectionDAO {
	String createElection(ElectionBean ebean );
	int deleteElection(ArrayList<String> plist);
	boolean updateElection(ElectionBean ebean);
	ElectionBean findByID(String pid);
	ArrayList<ElectionBean> findAll();
	ArrayList<ElectionBean> upcomingElection();
	String getElectionSeq();
	

}
