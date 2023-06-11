package TaasheeTraining.controller;
import  TaasheeTraining.model.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/")
public class Contoller extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				//boolean r=APIsDao.addStudent("lokya","narayanapet",12,22);
				HttpSession session=req.getSession();
				 if(session.getAttribute("loggenInUser") == null)
				 {
					 resp.sendRedirect("homePage.jsp");		
					 return;
				 }
				 String action=req.getServletPath();
				 System.out.println("Request method is: "+req.getMethod());
				 System.out.println("ServletPath is: "+req.getServletPath());
				 System.out.println("Context Path is: "+ req.getContextPath());
				 System.out.println("Query String is: "+req.getQueryString());
				 
				 switch(action)
				 {
				 case "/getAllInstructorsAndCourses":
					 getAllInstructorsAndCourses(req,resp);
					 break;
				 case "/removeInstructorById":
					 removeInstructorById(req,resp);
					 break;
				 case "/getInstructorById":
					 	getInstructorById(req,resp);
					 	break;
				 case "/updateInstructor":
					 updateInstructor(req,resp);
					 break;
				 case "/removeCourseById":
					 removeCourseById(req,resp);
					 break;
				 case "/getCourseById":
					 	getCourseById(req,resp);
					 	break;
				 case "/updateCourse":
					 updateCourse(req,resp);
					 break;
				 case "/addInstructor":
					 addInstructor(req,resp);
					 break;
				 case "/addCourse":
					 addCourse(req,resp);
					 break;
				 case "/addCourseToInstructor":
					 addCourseToInstructor(req,resp);
					 break;
				 case "/getInstructorByUserName":
					 getInstructorByUserName(req,resp);
					 break;
				 case "/addStudent":
					 addStudent(req,resp);
					 break;
				 case "/addCourseToStudent" :
					 addCourseToStudent(req,resp);
					 break;
				 case "/getStudentByUserName":
					 getStudentByUserName(req,resp);
					 break;
				 default:
				 		resp.sendRedirect("homePage.jsp");
				 		break;
					 
				 }
			}

			private void getStudentByUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				HttpSession session=req.getSession();
				String userName=(String)session.getAttribute("loggenInUser");
				System.out.println(userName);
				Student student=APIsDao.getStudentByUserName(userName);
				 List<Course> list=APIsDao.getStudentCourses(student.id);
				
				//System.out.println(instructor.name);
				req.setAttribute("student", student);
				req.setAttribute("courses", list);
				RequestDispatcher dispatcher=req.getRequestDispatcher("studentHomePage.jsp");
				dispatcher.forward(req, resp);
				
			}
			private void addCourseToStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				int course_id=Integer.parseInt(req.getParameter("cid"));
				int Student_id=Integer.parseInt(req.getParameter("id"));
				int id=Integer.parseInt(req.getParameter("eid"));
				boolean isAdded=APIsDao.addCourseToStudent(id,Student_id,course_id);

				//System.out.println(isAdded);
				req.setAttribute("isAdded", isAdded);
				RequestDispatcher dispatcher=req.getRequestDispatcher("getInstructorByUserName");
				dispatcher.forward(req, resp);
				
			}
			private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				int id=Integer.parseInt(req.getParameter("id"));
				String name=req.getParameter("name");
				String city=req.getParameter("city");
				int age=Integer.parseInt(req.getParameter("age"));
				String password=req.getParameter("password");
				String username=req.getParameter("username");
				boolean isAdded=APIsDao.addStudent(name, city, id, age, username, password);
				req.setAttribute("isAdded", isAdded);
				RequestDispatcher dispatcher=req.getRequestDispatcher("getInstructorByUserName");
				dispatcher.forward(req, resp);
				
			}
			private void getInstructorByUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				HttpSession session=req.getSession();
				String userName=(String)session.getAttribute("loggenInUser");
				System.out.println(userName);
				Instructor instructor=APIsDao.getInstructorByUserName(userName);
				 List<Course> list=APIsDao.getInstructorCourses(instructor.id);
				
				//System.out.println(instructor.name);
				req.setAttribute("instructor", instructor);
				req.setAttribute("courses", list);
				RequestDispatcher dispatcher=req.getRequestDispatcher("instructorHomePage.jsp");
				dispatcher.forward(req, resp);
				
			}
			private void addCourseToInstructor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				int course_id=Integer.parseInt(req.getParameter("cid"));
				int instructor_id=Integer.parseInt(req.getParameter("id"));
				int id=Integer.parseInt(req.getParameter("eid"));
				boolean isAdded=APIsDao.addCourseToInstructor(id,course_id,instructor_id);

				System.out.println(isAdded);
				req.setAttribute("isAdded", isAdded);
				RequestDispatcher dispatcher=req.getRequestDispatcher("getAllInstructorsAndCourses");
				dispatcher.forward(req, resp);
			}
			private void addCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				int id=Integer.parseInt(req.getParameter("id"));
				String name=req.getParameter("name");
				String description=req.getParameter("description");
				
				boolean isAdded=APIsDao.addCourse(name, id, description);
				req.setAttribute("isAdded", isAdded);
				RequestDispatcher dispatcher=req.getRequestDispatcher("getAllInstructorsAndCourses");
				dispatcher.forward(req, resp);
				
			}
			private void addInstructor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				int id=Integer.parseInt(req.getParameter("id"));
				String name=req.getParameter("name");
				String city=req.getParameter("city");
				int age=Integer.parseInt(req.getParameter("age"));
				String password=req.getParameter("password");
				String username=req.getParameter("username");
				boolean isAdded=APIsDao.addInstructor(name, city, id, age, username, password);
				req.setAttribute("isAdded", isAdded);
				RequestDispatcher dispatcher=req.getRequestDispatcher("getAllInstructorsAndCourses");
				dispatcher.forward(req, resp);
				
			}
			private void updateCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				int id=Integer.parseInt(req.getParameter("id"));
				

				String name=req.getParameter("name");
				String description=req.getParameter("description");
				boolean isUpdated=APIsDao.updateCourse(name, id, description);
				//System.out.println(isUpdated);
				req.setAttribute("isUpdated", isUpdated);
				RequestDispatcher dispatcher=req.getRequestDispatcher("getAllInstructorsAndCourses");
				dispatcher.forward(req, resp);
				
			}
			private void getCourseById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				int id=Integer.parseInt(req.getParameter("courseId"));
				Course instructor=APIsDao.getCourseById(id);
				req.setAttribute("course", instructor);
				RequestDispatcher dispatcher=req.getRequestDispatcher("updateCourse.jsp");
				dispatcher.forward(req, resp);
				
			}
			private void removeCourseById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				int id=Integer.parseInt(req.getParameter("courseId"));
				boolean isRemoved=APIsDao.deleteCourse(id);
				req.setAttribute("isRemoved", isRemoved);
				RequestDispatcher dispatcher=req.getRequestDispatcher("adminHomePage.jsp");
				dispatcher.forward(req, resp);
				
			}
			private void updateInstructor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				//System.out.println("comming!!");
				int id=Integer.parseInt(req.getParameter("id"));
				int age=Integer.parseInt(req.getParameter("age"));

				String name=req.getParameter("name");
				String city=req.getParameter("city");
				boolean isUpdated=APIsDao.updateInstructor(name, city, id, age);
				//System.out.println(isUpdated);
				req.setAttribute("isUpdated", isUpdated);
				RequestDispatcher dispatcher=req.getRequestDispatcher("getAllInstructorsAndCourses");
				dispatcher.forward(req, resp);
			}

			private void getInstructorById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				int id=Integer.parseInt(req.getParameter("instructorId"));
				Instructor instructor=APIsDao.getInstructorByID(id);
				req.setAttribute("instructor", instructor);
				RequestDispatcher dispatcher=req.getRequestDispatcher("updateInstructor.jsp");
				dispatcher.forward(req, resp);
				
			}

			private void removeInstructorById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				int id=Integer.parseInt(req.getParameter("instructorId"));
				boolean isRemoved=APIsDao.deleteInstructor(id);
				req.setAttribute("isRemoved", isRemoved);
				RequestDispatcher dispatcher=req.getRequestDispatcher("adminHomePage.jsp");
				dispatcher.forward(req, resp);
				
			}

			private void getAllInstructorsAndCourses(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				List<Instructor> instructorList=APIsDao.getAllInstructors();
				List<Course> courseList=APIsDao.getAllCourses();
				req.setAttribute("instructorsList",instructorList);
				req.setAttribute("coursesList", courseList);
				RequestDispatcher dispatcher=req.getRequestDispatcher("adminHomePage.jsp");
				dispatcher.forward(req, resp);
				
			}

			
}
