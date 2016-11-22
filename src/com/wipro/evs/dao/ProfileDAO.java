package com.wipro.evs.dao;

import com.wipro.evs.bean.ProfileBean;

public interface ProfileDAO {
	ProfileBean findByID(String pid);

}
