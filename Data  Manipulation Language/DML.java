import java.sql.*;

public class DML {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/testrun";
        String uname = "root";
        String pass = "**Replace with yours**";
        Connection con = DriverManager.getConnection(url,uname,pass);

        String query = "insert into student values (4,'tim',50)";
        PreparedStatement st = con.prepareStatement(query);
        int rs = st.executeUpdate();

        System.out.print(rs + "row(s) Affected");



    }
}
