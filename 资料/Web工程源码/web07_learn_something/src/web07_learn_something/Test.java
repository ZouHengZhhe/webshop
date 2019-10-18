package web07_learn_something;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test {
	public static void main(String[] args) throws Exception {
		
		DataSource ds = new ComboPooledDataSource();//使用c3p0的数据源
		Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from goods");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}
		rs.close();
		ps.close();
		con.close();
		
		
	}
}
