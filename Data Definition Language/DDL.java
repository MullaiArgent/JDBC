import java.sql.*;

class DDL {
	public static void main(String[] args) throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/testrun";
		String uname = "root";
		String pass = "**Replace with yours**";
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		String query = "select * from student";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		String userdata;
		while(rs.next()) {
			userdata = rs.getInt(1) + " " + rs.getString(2)+ " " +rs.getInt(3)+ "\n";
			System.out.print(userdata);
		}	
	}
}