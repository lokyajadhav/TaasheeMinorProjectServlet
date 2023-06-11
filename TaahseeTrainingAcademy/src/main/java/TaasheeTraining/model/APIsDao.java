package TaasheeTraining.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import TaasheeTraining.controller.Course;
import TaasheeTraining.controller.Instructor;
import TaasheeTraining.controller.Student;



public class APIsDao {
	 
		
	public static boolean addStudent(String name,String city,int id,int age,String username,String password)
	{
		try
		{
			String addQuery="insert into Students(name,city,id,age,username,password) values(?,?,?,?,?,?)";
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement statement=con.prepareStatement(addQuery);
			statement.setString(1, name);
			statement.setString(2, city);
			statement.setInt(3, id);
			statement.setInt(4, age);
			statement.setString(5, username);
			statement.setString(6, password);
			int insertedRows=statement.executeUpdate();
			if(insertedRows>0) return true;
			

		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
		public static boolean addInstructor(String name,String city,int id,int age,String username,String password)
		{
			try
			{
				String addQuery="insert into Instructor(name,city,id,age,username,password) values(?,?,?,?,?,?)";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(addQuery);
				statement.setString(1, name);
				statement.setString(2, city);
				statement.setInt(3, id);
				statement.setInt(4, age);
				statement.setString(5, username);
				statement.setString(6, password);
				int insertedRows=statement.executeUpdate();
				if(insertedRows>0) return true;
				

			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return false;
		}
		public static boolean addCourse(String name,int id,String description)
		{
			try
			{
				String addQuery="insert into Courses(name,id,description) values(?,?,?)";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(addQuery);
				statement.setString(1, name);
				statement.setInt(2, id);
				statement.setString(3, description);
				
				int insertedRows=statement.executeUpdate();
				if(insertedRows>0) return true;
				

			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return false;
		}
		public static List<Course> getAllCourses()
		{
			List<Course> list=new ArrayList<>();
			try
			{
				Connection con=ConnectionFactory.getConnection();
				Statement statement=con.createStatement();
				ResultSet rs=statement.executeQuery("select * from Courses");
				
				
				while(rs.next())
				{
//					System.out.print("\t\t");
//					System.out.printf("%s %s is famous dance in %s",rs.getInt("id"),rs.getString("name"),rs.getString("state_of_origin"));
//					System.out.println();
					String courseName=rs.getString("name");
					String courseDescription=rs.getString("description");
					int courseId=rs.getInt("id");
					Course course=new Course(courseName,courseId,courseDescription);
					list.add(course);
					
					
				}
			con.close();
			statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			return list;
		}
		public static List<Student> getAllStudets()
		{
			List<Student> list=new ArrayList<>();
			try
			{
				Connection con=ConnectionFactory.getConnection();
				Statement statement=con.createStatement();
				ResultSet rs=statement.executeQuery("select name,city,id,age from Students");
				
				
				while(rs.next())
				{
//					System.out.print("\t\t");
//					System.out.printf("%s %s is famous dance in %s",rs.getInt("id"),rs.getString("name"),rs.getString("state_of_origin"));
//					System.out.println();
					String studentName=rs.getString("name");
					String studentCity=rs.getString("city");
					int studentId=rs.getInt("id");
					int studentAge=rs.getInt("age");
					Student student=new Student(studentName,studentId,studentCity,studentAge);
					
					list.add(student);
					
					
				}
			con.close();
			statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			return list;
		}
		public static List<Instructor> getAllInstructors()
		{
			List<Instructor> list=new ArrayList<>();
			try
			{
				Connection con=ConnectionFactory.getConnection();
				Statement statement=con.createStatement();
				ResultSet rs=statement.executeQuery("select name,city,id,age from Instructor");
				
				
				while(rs.next())
				{
//					System.out.print("\t\t");
//					System.out.printf("%s %s is famous dance in %s",rs.getInt("id"),rs.getString("name"),rs.getString("state_of_origin"));
//					System.out.println();
					String instructorName=rs.getString("name");
					String instructorCity=rs.getString("city");
					int instructorId=rs.getInt("id");
					int instructorAge=rs.getInt("age");
					Instructor instructor=new Instructor(instructorName,instructorId,instructorCity,instructorAge);
					
					list.add(instructor);
					
					
				}
			con.close();
			statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			return list;
		}
		public static boolean isStudentAuthenticated(String userName, String password) {
			try {
			String AuthQuery="select * from Students where username=? and password=?";
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement statement=con.prepareStatement(AuthQuery);
			statement.setString(1, userName);
			statement.setString(2, password);
			ResultSet rs=statement.executeQuery();
			while(rs.next())
			{
				//System.out.println("yeass got");
				return true;
				
			}
			con.close();
			statement.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
			return false;
		}
		public static boolean isAdminAuthenticated(String userName, String password) {
			try {
			String AuthQuery="select * from admin where username=? and password=?";
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement statement=con.prepareStatement(AuthQuery);
			statement.setString(1, userName);
			statement.setString(2, password);
			ResultSet rs=statement.executeQuery();
			while(rs.next())
			{
				//System.out.println("yeass got");
				return true;
				
			}
			con.close();
			statement.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
			return false;
		}
		
		public static boolean isInstructorAuthenticated(String userName, String password) {
			try {
			String AuthQuery="select * from Instructor where username=? and password=?";
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement statement=con.prepareStatement(AuthQuery);
			statement.setString(1, userName);
			statement.setString(2, password);
			ResultSet rs=statement.executeQuery();
			while(rs.next())
			{
				//System.out.println("yeass got");
				return true;
				
			}
			con.close();
			statement.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
			return false;
		}
		public static boolean deleteStudent(int id)
		{
			try
			{
				String deleteQuery="delete from Students where id=?";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(deleteQuery);
				statement.setInt(1, id);
				int deletedRows=statement.executeUpdate();
				if(deletedRows>0)
				{
					return true;
					
				}
				con.close();
				statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return false;
		}
		public static boolean deleteInstructor(int id)
		{
			try
			{
				String deleteQuery="delete from Instructor where id=?";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(deleteQuery);
				statement.setInt(1, id);
				int deletedRows=statement.executeUpdate();
				if(deletedRows>0)
				{
					return true;
					
				}
				con.close();
				statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return false;
		}
		public static boolean deleteCourse(int id)
		{
			try
			{
				String deleteQuery="delete from Course where id=?";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(deleteQuery);
				statement.setInt(1, id);
				int deletedRows=statement.executeUpdate();
				if(deletedRows>0)
				{
					return true;
					
				}
				con.close();
				statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return false;
		}
		
		public static boolean updateStudent(String name, String city,int id,int age,String userName, String password)
		{
			try
			{
				String updateDanceQuery="update Students set name=? ,city=?,age=?,userName=?,password=? where id=?";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(updateDanceQuery);
				statement.setString(1, name);
				statement.setString(2, city);
				statement.setInt(3, age);
				statement.setString(4, userName);
				statement.setString(5, password);
				statement.setInt(6, id);
				
				int updatedRow=statement.executeUpdate();
				if(updatedRow>0)
				{
					return true;
					
				}
				con.close();
				statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return false;
		}
		public static boolean updateInstructor(String name, String city,int id,int age)
		{
			try
			{
				System.out.println("id is:"+id);
				System.out.println("id is:"+name);
				System.out.println("id is:"+age);
				System.out.println("id is:"+city);
				String updateInstructorQuery="UPDATE Instructor set name=?,city=?,age=? where id=?";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(updateInstructorQuery);
				statement.setString(1, name);
				statement.setString(2, city);
				statement.setInt(3, age);
				statement.setInt(4, id);
				int updatedRow=statement.executeUpdate();
				System.out.println(updatedRow);
				if(updatedRow>0)
				{
					System.out.println("shfgjsfsj");
					return true;
					
				}
				con.close();
				statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return false;
		}
		
		public static boolean updateCourse(String name,int id, String description)
		{
			try
			{
				
				String updateDanceQuery="update Courses set name=? ,description=? where id=?";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(updateDanceQuery);
				statement.setString(1, name);
				statement.setString(2, description);
				statement.setInt(3, id);
				
				int updatedRow=statement.executeUpdate();
				if(updatedRow>0)
				{
					return true;
					
				}
				con.close();
				statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return false;
		}
		public static Instructor getInstructorByID(int id)
		{
			Instructor instructor=null;
			try
			{
				String getInstructorQuery="select * from Instructor where id=?";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(getInstructorQuery);
				statement.setInt(1, id);
				ResultSet rs=statement.executeQuery();
				while(rs.next())
				{
					//System.out.println();
					String InstructorName=rs.getString("name");
					int InstructorId=rs.getInt("id");
					String InstructorCity=rs.getString("city");
					int InstructorAge=rs.getInt("age");
					
					
					instructor=new Instructor(InstructorName,InstructorId,InstructorCity,InstructorAge);
					
				}
				con.close();
				statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return instructor;
		}
		public static Course getCourseById(int id) {
			Course course=null;
			try
			{
				String getInstructorQuery="select * from Courses where id=?";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(getInstructorQuery);
				statement.setInt(1, id);
				ResultSet rs=statement.executeQuery();
				while(rs.next())
				{
					//System.out.println();
					String CourseName=rs.getString("name");
					int CourseId=rs.getInt("id");
					String CourseDescription=rs.getString("description");
					
					
					
					course=new Course(CourseName,CourseId,CourseDescription);
					
				}
				con.close();
				statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return course;
		}
		public static boolean addCourseToInstructor(int id, int course_id, int instructor_id) {
			try
			{
				System.out.println(id+" "+course_id+" "+instructor_id);
				String addQuery="insert into InstructorsCourseAssigned(id,instructor_id,course_id) values(?,?,?)";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(addQuery);
				statement.setInt(1, id);
				statement.setInt(2, instructor_id);
				statement.setInt(3, course_id);
				
				int insertedRows=statement.executeUpdate();
				if(insertedRows>0) return true;
				

			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return false;
		}
		public static Instructor getInstructorByUserName(String userName) {
			Instructor instructor=null;
			try
			{
				String getInstructorQuery="select * from Instructor where username=?";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(getInstructorQuery);
				statement.setString(1, userName);
				ResultSet rs=statement.executeQuery();
				while(rs.next())
				{
					//System.out.println();
					String InstructorName=rs.getString("name");
					int InstructorId=rs.getInt("id");
					String InstructorCity=rs.getString("city");
					int InstructorAge=rs.getInt("age");
					
					
					instructor=new Instructor(InstructorName,InstructorId,InstructorCity,InstructorAge);
					
				}
				con.close();
				statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return instructor;
		}
		public static boolean addCourseToStudent(int id, int student_id, int course_id) {
			try
			{
				//System.out.println(id+" "+course_id+" "+instructor_id);
				String addQuery="insert into enrollments(enrollment_id,student_id,course_id) values(?,?,?)";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(addQuery);
				statement.setInt(1, id);
				statement.setInt(2, student_id);
				statement.setInt(3, course_id);
				
				int insertedRows=statement.executeUpdate();
				if(insertedRows>0) return true;
				

			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return false;
		}
		public static List<Course> getInstructorCourses(int id) {
			List<Course> list=new ArrayList<>();
			try
			{
				
				String getQuery="SELECT  Courses.name, courses.description,Courses.id\r\n"
						+ "FROM instructor\r\n"
						+ "JOIN  InstructorsCourseAssigned ON instructor.id = InstructorsCourseAssigned.Instructor_id\r\n"
						+ "JOIN Courses ON InstructorsCourseAssigned.course_id = Courses.id\r\n"
						+ "WHERE instructor.id = ?";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(getQuery);
				statement.setInt(1, id);
				
				ResultSet rs=statement.executeQuery();
				
				
				while(rs.next())
				{
//					System.out.print("\t\t");
//					System.out.printf("%s %s is famous dance in %s",rs.getInt("id"),rs.getString("name"),rs.getString("state_of_origin"));
//					System.out.println();
					String courseName=rs.getString("Courses.name");
					String courseDescription=rs.getString("Courses.description");
					int courseId=rs.getInt("Courses.id");
					Course course=new Course(courseName,courseId,courseDescription);
					list.add(course);
					
					
				}
			con.close();
			statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			return list;
			
		}
		public static Student getStudentByUserName(String userName) {
			Student student=null;
			try
			{
				String getInstructorQuery="select * from Students where username=?";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(getInstructorQuery);
				statement.setString(1, userName);
				ResultSet rs=statement.executeQuery();
				while(rs.next())
				{
					//System.out.println();
					String InstructorName=rs.getString("name");
					int InstructorId=rs.getInt("id");
					String InstructorCity=rs.getString("city");
					int InstructorAge=rs.getInt("age");
					
					
					student=new Student(InstructorName,InstructorId,InstructorCity,InstructorAge);
					
				}
				con.close();
				statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return student;
		}
		public static List<Course> getStudentCourses(int id) {
			List<Course> list=new ArrayList<>();
			try
			{
				
				String getQuery="SELECT  Courses.name, courses.description,Courses.id\r\n"
						+ "FROM Students\r\n"
						+ "JOIN  enrollments ON Students.id = enrollments.student_id\r\n"
						+ "JOIN Courses ON enrollments.course_id = Courses.id\r\n"
						+ "WHERE Students.id = ?";
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(getQuery);
				statement.setInt(1, id);
				
				ResultSet rs=statement.executeQuery();
				
				
				while(rs.next())
				{
//					System.out.print("\t\t");
//					System.out.printf("%s %s is famous dance in %s",rs.getInt("id"),rs.getString("name"),rs.getString("state_of_origin"));
//					System.out.println();
					String courseName=rs.getString("Courses.name");
					String courseDescription=rs.getString("Courses.description");
					int courseId=rs.getInt("Courses.id");
					Course course=new Course(courseName,courseId,courseDescription);
					list.add(course);
					
					
				}
			con.close();
			statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			return list;
		}
		}



