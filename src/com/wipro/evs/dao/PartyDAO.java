package com.wipro.evs.dao;

import java.util.ArrayList;

import com.wipro.evs.bean.PartyBean;

public interface PartyDAO {
	String createParty(PartyBean pbean );
	int deleteParty(ArrayList<String> plist);
	boolean updateParty(PartyBean pbean);
	PartyBean findByID(String pid);
	ArrayList<PartyBean> findAll();
	String getPartySeq();
}
