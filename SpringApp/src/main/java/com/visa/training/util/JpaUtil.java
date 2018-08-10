/*package com.visa.training.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory mysqlDB;		//maintains a pool of connection
	
	public static EntityManagerFactory getEmf(){
		if(mysqlDB==null){
			mysqlDB = Persistence.createEntityManagerFactory("mysql");	//name "mysql" comes from the tag persistence-unit name in persistence.xml 
		}
		return mysqlDB;
	}

}
*/