package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import entity.User;
import model.Table1Model;


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Resource(name = "jdbc/project")
  private DataSource ds;

  	@Override
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	
  		String var2= request.getParameter("form");
  		var2 = var2.toLowerCase();
  		switch(var2) {
  		case "email":
  			User newUser = new User(request.getParameter("email"));
  			new Table1Model().addEmail(ds,newUser);
  			listEmail(request, response);
  			break;
  		case "updateemail":
  			User updateUser = new User(Integer.parseInt(request.getParameter("userid")),request.getParameter("email"));
  			new Table1Model().updateEmail(ds,updateUser);
  			listEmail(request, response);
  			break;
  			default:
  				request.getRequestDispatcher("error.jsp").forward(request,response);
  				
  		}
  		
  		
  	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String var = request.getParameter("page");
		var = var.toLowerCase();
		
		switch(var){
		case "home":
			request.getRequestDispatcher("index.jsp").forward(request, response);
		break;
		case "list":
		listEmail(request, response);
		break;
		case "delete":
			deleteEmail(request, response);
			break;
		case "add":
			request.getRequestDispatcher("add.jsp").forward(request, response);
			break;
		case "update":
			updateEmail(request, response);
			break;
		default:
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
	
	}
	private void deleteEmail(HttpServletRequest request, HttpServletResponse response) {
		User deleteUser = new User(Integer.parseInt(request.getParameter("UID")));
			new Table1Model().deleteEmail(ds,deleteUser);
		
		try {
			listEmail(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void listEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<User> list = new ArrayList<>();// for recieving
			list = new Table1Model().email(ds);// 
			request.setAttribute("list", list);//setting attribute
		request.getRequestDispatcher("listUser.jsp").forward(request, response);
	}
	void updateEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}
}
