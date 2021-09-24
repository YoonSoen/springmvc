package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "thy";
	private String password = "1234";

	@org.junit.Test
	public void test() throws ClassNotFoundException {
		Class.forName(driver);
		try (Connection con = DriverManager.getConnection(url, user, password)) {

		} catch (Exception e) {
			System.out.println("!!짱!!");
		}
	}

}
