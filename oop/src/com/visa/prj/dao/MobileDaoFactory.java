package com.visa.prj.dao;

import java.util.ResourceBundle;

public class MobileDaoFactory {

	private static String NAME = "";
	
	/*
	 * Executed when the class is loaded. Loading of drivers.
	 */
	static {
		ResourceBundle res = ResourceBundle.getBundle("config"); 
		// can read file having properties extension & not others
		NAME = res.getString("MOBILE_DAO").trim();
	}
	
	// There is no state, therefore no need to create an instance method.
	public static MobileDao getMobileDao() {
//		return new MobileDaoMongoImpl();
		try {
			return (MobileDao) Class.forName(NAME).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}