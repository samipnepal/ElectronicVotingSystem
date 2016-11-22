package com.wipro.evs.util;

import org.hibernate.SessionFactory;

public interface DBUtil {
	SessionFactory getDBConnection();
}
