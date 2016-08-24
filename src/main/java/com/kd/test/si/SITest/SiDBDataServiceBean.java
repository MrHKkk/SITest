package com.kd.test.si.SITest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class SiDBDataServiceBean {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(SiDBDataServiceBean.class);
	
	public static Connection getConn() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.116:1521:xe", "hr", "hr");
		return conn;
	}
	
	
	public List<String> findEmpNames() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		try {
			System.out.println(("polling from database..."));
			conn = SiDBDataServiceBean.getConn();
			StringBuilder sqlQry = new StringBuilder();
			sqlQry.append("SELECT FIRST_NAME FROM EMPLOYEES");
			pstmt = conn.prepareStatement(sqlQry.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("FIRST_NAME"));
				System.out.println(("polling " + rs.getString("FIRST_NAME")));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void writeService(Message msg) {
		msg.getPayload();
		System.out.println(msg.getPayload());
		
	}
	
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			conn = SiDBDataServiceBean.getConn();
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
