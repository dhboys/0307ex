package org.dongho.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	@Test
	public void testConnectionTest() throws Exception{
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			log.info("1--------------------");
			
			String url = "jdbc:mysql://localhost:3306/dclass?serverTimezone=UTC";
			String userName = "springuser";
			String password = "springuser";
			
			Connection con = DriverManager.getConnection(url , userName , password);
			
			log.info(con);
			
			con.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
}
}
