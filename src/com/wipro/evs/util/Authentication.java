package com.wipro.evs.util;

import com.wipro.evs.bean.CredentialsBean;

public interface Authentication {
	boolean authenticate(CredentialsBean user);
	String authorize(String userId);
	boolean changeLoginStatus(CredentialsBean user, int loginStatus);

}
