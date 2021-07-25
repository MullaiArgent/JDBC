import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        StudentDao dao = new StudentDao();
        Student s1 = dao.getStudent(1);
        System.out.println(s1.sname+ " " + s1.mark);

        dao.removeStudent(2);

        Student s2 = new Student();
        s2.roll = 5;
        s2.sname = "Gosling";
        s2.mark = 90;
        dao.addStudent(s2);

    }

}
class StudentDao {

    public Student getStudent(int rollno) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/testrun";
        String uname = "root";
        String pass = "**Replace with yours**";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        String query = "select * from student where rollno="+rollno;
        ResultSet rs = st.executeQuery(query);
        rs.next();
        Student s = new Student();
        s.sname = rs.getString(2);
        s.mark = rs.getInt(3);
        return s;
    }
    public void addStudent(Student s) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/testrun";
        String uname = "root";
        String pass = "**Replace with yours**";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        String query = "insert into student values(?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,s.roll);
        pst.setString(2,s.sname);
        pst.setInt(3,s.mark);
        pst.executeUpdate();
        System.out.println("Student Added");
    }
    public void removeStudent(int rollno) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/testrun";
        String uname = "root";
        String pass = "**Replace with yours**";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        String query = "delete from student where rollno="+rollno;
        PreparedStatement pst = con.prepareStatement(query);
        pst.executeUpdate();
        System.out.println("Student Deleted");
    }
}
class Student {
    int roll;
    String sname;
    int mark;
}
