package kang.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KangDAO {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kuldeep", "kuldeep305");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(Student e) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into Student values(?,?,?,?,?,?,?,?,?,?)");
			PreparedStatement ps2 = con.prepareStatement("insert into Grades values(?,?,?,?,?,?,?,?,?)");
			ps2.setString(1, e.getUnm());
			ps2.setString(2, "Not Graded Yet");
			ps2.setString(3, "Not Graded Yet");
			ps2.setString(4, "Not Graded Yet");
			ps2.setString(5, "Not Graded Yet");
			ps2.setString(6, "Not Graded Yet");
			ps2.setString(7, "Not Graded Yet");
			ps2.setString(8, "Not Graded Yet");
			ps2.setString(9, "Not Graded Yet");
			ps.setString(1, e.getUnm());
			ps.setString(2, e.getPwd());
			ps.setString(3, e.getFname());
			ps.setString(4, e.getLname());
			ps.setString(5, e.getCourse());
			ps.setString(6, e.getGender());
			ps.setDate(7, e.getOdob());
			ps.setString(8, e.getMs());
			ps.setString(9, e.getEmail());
			ps.setString(10, e.getPn());

			ps2.executeUpdate();
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static List<Student> getStudentsByName(String like) {
		List<Student> list = new ArrayList<Student>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"select Student_ID, Fname, Lname, Course, Gender, Dob, Merital_S, Email, Phone_n from Student where Fname like ?");

			ps.setString(1, like);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student s = new Student();
				s.setUnm(rs.getString(1));
				s.setFname(rs.getString(2));
				s.setLname(rs.getString(3));
				String course = rs.getString(4);
				switch (course) {
				case "html":
					s.setCourse("Web Development(1-HTML)");
					break;
				case "css":
					s.setCourse("Web Development(2-CSS)");
					break;
				case "js":
					s.setCourse("Web Development(3-JavaScript)");
					break;
				case "javaee":
					s.setCourse("Java EE");
					break;
				case "jq":
					s.setCourse("J Query");
					break;
				case "cs":
					s.setCourse("C Sharp");
					break;
				case "python":
					s.setCourse("Python");
					break;
				case "politics":
					s.setCourse("Politics");
					break;
				default:
					s.setCourse("NA");
					break;
				}
				s.setGender(rs.getString(5));
				s.setOdob(rs.getDate(6));
				s.setMs(rs.getString(7));
				s.setEmail(rs.getString(8));
				s.setPn(rs.getString(9));
				list.add(s);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public static Student getStudentsById(String id) {
		Student s = new Student();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"select Student_ID, Fname, Lname, Course, Gender, Dob, Merital_S, Email, Phone_n from Student where Student_ID=?");

			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				s.setUnm(rs.getString(1));
				s.setFname(rs.getString(2));
				s.setLname(rs.getString(3));
				String course = rs.getString(4);
				switch (course) {
				case "html":
					s.setCourse("Web Development(1-HTML)");
					break;
				case "css":
					s.setCourse("Web Development(2-CSS)");
					break;
				case "js":
					s.setCourse("Web Development(3-JavaScript)");
					break;
				case "javaee":
					s.setCourse("Java EE");
					break;
				case "jq":
					s.setCourse("J Query");
					break;
				case "cs":
					s.setCourse("C Sharp");
					break;
				case "python":
					s.setCourse("Python");
					break;
				case "politics":
					s.setCourse("Politics");
					break;
				default:
					s.setCourse("NA");
					break;
				}
				s.setGender(rs.getString(5));
				s.setOdob(rs.getDate(6));
				s.setMs(rs.getString(7));
				s.setEmail(rs.getString(8));
				s.setPn(rs.getString(9));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return s;
	}

	public static List<Student> getAllStudents() {
		List<Student> list = new ArrayList<Student>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"select Student_ID, Fname, Lname, Course, Gender, Dob, Merital_S, Email, Phone_n from Student");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student s = new Student();
				s.setUnm(rs.getString(1));
				s.setFname(rs.getString(2));
				s.setLname(rs.getString(3));
				String course = rs.getString(4);
				switch (course) {
				case "html":
					s.setCourse("Web Development(1-HTML)");
					break;
				case "css":
					s.setCourse("Web Development(2-CSS)");
					break;
				case "js":
					s.setCourse("Web Development(3-JavaScript)");
					break;
				case "javaee":
					s.setCourse("Java EE");
					break;
				case "jq":
					s.setCourse("J Query");
					break;
				case "cs":
					s.setCourse("C Sharp");
					break;
				case "python":
					s.setCourse("Python");
					break;
				case "politics":
					s.setCourse("Politics");
					break;
				default:
					s.setCourse("NA");
					break;
				}
				s.setGender(rs.getString(5));
				s.setOdob(rs.getDate(6));
				s.setMs(rs.getString(7));
				s.setEmail(rs.getString(8));
				s.setPn(rs.getString(9));
				list.add(s);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public static void deleteStudent(String id) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("delete from Student where Student_Id=?");
			ps.setString(1, id);
			ps.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static int Edit_Student(Student e, String id) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update Student set Fname=?, Lname=?, Course=?, Gender=?, Dob=?, Merital_S=?, Email=?, Phone_n=?  where Student_id=?");
			ps.setString(1, e.getFname());
			ps.setString(2, e.getLname());
			ps.setString(3, e.getCourse());
			ps.setString(4, e.getGender());
			ps.setDate(5, e.getOdob());
			ps.setString(6, e.getMs());
			ps.setString(7, e.getEmail());
			ps.setString(8, e.getPn());
			ps.setString(9, id);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static List<Student> getGrades() {
		List<Student> list = new ArrayList<Student>();
		Connection con = getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select* from grades_v");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setUnm(rs.getString(1));
				s.setname(rs.getString(2));
				String course = rs.getString(3);
				switch (course) {
				case "html":
					s.setCourse("Web Development(1-HTML)");
					break;
				case "css":
					s.setCourse("Web Development(2-CSS)");
					break;
				case "js":
					s.setCourse("Web Development(3-JavaScript)");
					break;
				case "javaee":
					s.setCourse("Java EE");
					break;
				case "jq":
					s.setCourse("J Query");
					break;
				case "cs":
					s.setCourse("C Sharp");
					break;
				case "python":
					s.setCourse("Python");
					break;
				case "politics":
					s.setCourse("Politics");
					break;
				default:
					s.setCourse("NA");
					break;
				}
				s.setA1(rs.getString(4));
				s.setA2(rs.getString(5));
				s.setA3(rs.getString(6));
				s.setA4(rs.getString(7));
				s.setA5(rs.getString(8));
				s.setT1(rs.getString(9));
				s.setT2(rs.getString(10));
				s.setT3(rs.getString(11));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public static List<Student> getGradesByName(String like) {
		List<Student> list = new ArrayList<Student>();
		Connection con = getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select* from grades_v where Name like ?");
			ps.setString(1, like);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setUnm(rs.getString(1));
				s.setname(rs.getString(2));
				String course = rs.getString(3);
				switch (course) {
				case "html":
					s.setCourse("Web Development(1-HTML)");
					break;
				case "css":
					s.setCourse("Web Development(2-CSS)");
					break;
				case "js":
					s.setCourse("Web Development(3-JavaScript)");
					break;
				case "javaee":
					s.setCourse("Java EE");
					break;
				case "jq":
					s.setCourse("J Query");
					break;
				case "cs":
					s.setCourse("C Sharp");
					break;
				case "python":
					s.setCourse("Python");
					break;
				case "politics":
					s.setCourse("Politics");
					break;
				default:
					s.setCourse("NA");
					break;
				}
				s.setA1(rs.getString(4));
				s.setA2(rs.getString(5));
				s.setA3(rs.getString(6));
				s.setA4(rs.getString(7));
				s.setA5(rs.getString(8));
				s.setT1(rs.getString(9));
				s.setT2(rs.getString(10));
				s.setT3(rs.getString(11));
				list.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public static int setGradesById(Student e) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update Grades set assignment1=?,assignment2=?,assignment3=?,assignment4=?,assignment5=?,test1=?,test2=?,test3=? where student_id=?");

			ps.setString(1, e.getA1());
			ps.setString(2, e.getA2());
			ps.setString(3, e.getA2());
			ps.setString(4, e.getA2());
			ps.setString(5, e.getA2());
			ps.setString(6, e.getT1());
			ps.setString(7, e.getT2());
			ps.setString(8, e.getT3());
			ps.setString(9, e.getUnm());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;

	}

	public static Student getGradesbyId(String id) {
		Student s = new Student();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select* from grades_v where student_id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s.setUnm(rs.getString(1));
				s.setname(rs.getString(2));
				String course = rs.getString(3);
				switch (course) {
				case "html":
					s.setCourse("Web Development(1-HTML)");
					break;
				case "css":
					s.setCourse("Web Development(2-CSS)");
					break;
				case "js":
					s.setCourse("Web Development(3-JavaScript)");
					break;
				case "javaee":
					s.setCourse("Java EE");
					break;
				case "jq":
					s.setCourse("J Query");
					break;
				case "cs":
					s.setCourse("C Sharp");
					break;
				case "python":
					s.setCourse("Python");
					break;
				case "politics":
					s.setCourse("Politics");
					break;
				default:
					s.setCourse("NA");
					break;
				}
				s.setA1(rs.getString(4));
				s.setA2(rs.getString(5));
				s.setA3(rs.getString(6));
				s.setA4(rs.getString(7));
				s.setA5(rs.getString(8));
				s.setT1(rs.getString(9));
				s.setT2(rs.getString(10));
				s.setT3(rs.getString(11));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return s;
	}

	public static boolean studentValidation(String studentID, String password) {
		boolean isValid = false;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Student where Student_id=? AND Password = ?");
			ps.setString(1, studentID);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				isValid = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return isValid;
	}

	public static Student getCourse(String id) {
		Student s = new Student();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select Course from Student where Student_ID=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				s.setCourse(rs.getString(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return s;

	}

}
