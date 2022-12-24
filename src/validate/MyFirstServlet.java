package validate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyFirstServlet")
public class MyFirstServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		try (PrintWriter out = response.getWriter()) {

			String username = request.getParameter("uname");
			String password = request.getParameter("pwd");

			if (username.equals("admin") && password.equals("admin123")) {
				out.println("welcome Admin");
				
				RequestDispatcher rd =request.getRequestDispatcher("AdminHome.jsp");
				rd.forward(request, response);
			} else {

				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "admin");

				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery("select * from login");
				int flag = 0;
				while (rs.next()) {

					String u = rs.getString("username");
					String p = rs.getString("password");

					if (username.equals(u) && password.equals(p)) {
						out.println("welcomeuser");
						
						RequestDispatcher rd =request.getRequestDispatcher("UserHome.jsp");
						rd.forward(request, response);
						flag = 1;
					}

				}
				if (flag == 0) {
					out.println("sorry");
					RequestDispatcher rd =request.getRequestDispatcher("index.jsp");
					
					rd.include(request, response);
				}
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
