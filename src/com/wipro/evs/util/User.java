package com.wipro.evs.util;

import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.bean.ProfileBean;

public interface User {
	String login(CredentialsBean credentialsBean);
	boolean logout(String userId);
	String changePassword(CredentialsBean cbean, String password);
	String register(ProfileBean profileBean);
}
