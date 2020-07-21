package com.kwon.db.main;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBManager2 {
	public static SqlSession connect() throws Exception {
		String cfgName = "com/kwon/db/main/config.xml";
		InputStream is = Resources.getResourceAsStream(cfgName);
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(is);
		return ssf.openSession();
	}
}






