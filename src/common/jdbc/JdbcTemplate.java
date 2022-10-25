package common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTemplate {

	public static Connection getConnection() {
		Connection conn = null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); 이것도 가능 (부모클래스)
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"scott", 
					"TIGER"); 
			if(conn != null) {
				System.out.println("===== DB 연결 성공 =====");
			} else {
				System.out.println("===== DB 연결 실패 =====");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("===== ojdbc6.jar 드라이버 찾지 못함 =====");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		
		return conn;
	}
}
