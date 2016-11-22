package com.wipro.evs.dao;



import java.util.ArrayList;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.ResultBean;



public interface VoterDAO {
	String generateVoterSeq();
	ApplicationBean viewVoterId(String userID);
	ArrayList<ElectionBean> viewCurrentElections();
	String castVote(ResultBean rBean);
	
}
