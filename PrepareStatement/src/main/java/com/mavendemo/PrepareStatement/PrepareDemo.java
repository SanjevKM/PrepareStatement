package com.mavendemo.PrepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepareDemo {

	public static void main(String[] args) {
		//Connection con;
		final String URL="jdbc:oracle:thin:@localhost:1521:xe";
		final String userName="SYSTEM";
		final String passWord="Sanjev123";
		//String insert="insert into DATABASE.TEST_CHECK values(?,?,?)";
		//String update="update DATABASE.TEST_CHECK SET TESTSCORE=? WHERE TESTNAME=?";
		String Q="Select DEPTNO,COUNT(*) FROM DATABASE.EMP GROUP BY DEPTNO";
		//String K="Delete from DATABASE.TEST_CHECK where TESTSCORE=?";
		
		//step1:
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//step2:
			Connection con=DriverManager.getConnection(URL,userName,passWord);
			if(con!=null) {
				System.out.println("Connected!");
			}else
				System.out.println("Not Connected");
			
			//INSERT
			//PreparedStatement stat=con.prepareStatement(insert);
			
//			stat.setInt(1,15);
//			stat.setString(2,"React");
//			stat.setFloat(3,25.25f);
			
//			int row=stat.executeUpdate();
//			if(row>0) System.out.println("Updated");
//			else System.out.println("Not Updated");
			
			//UPDATE
//			PreparedStatement stat1=con.prepareStatement(K);
//            stat1.setFloat(1,75.0f);
//            int row=stat1.executeUpdate();
//			if(row>0) System.out.println("Updated");
//			else System.out.println("Not Updated");
				
			//SELECT
			Statement st=con.createStatement();
			ResultSet res=st.executeQuery(Q);
			while(res.next())
				System.out.println(res.getInt(1)+" "+res.getInt(2));
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
