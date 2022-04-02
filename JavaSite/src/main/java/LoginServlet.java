

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectionBD.sqliteConnection;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("Cp1251");
		request.setCharacterEncoding("Cp1251");
		response.setCharacterEncoding("Cp1251");
		String login = request.getParameter("Login");
        String password = request.getParameter("Password");
        
        
        sqliteConnection connect =new sqliteConnection();  
        String query = "SELECT * FROM UserInfo WHERE loginUser = ?";
        PreparedStatement statement;
		ResultSet rs = null;
		try {
			
			statement = connect.dbConnector().prepareStatement(query);
			statement.setString(1, login);			
			rs = statement.executeQuery();
			//System.out.println(rs.isClosed());
			if(!rs.isClosed()) {
			while (rs.next()) {				
				
				String paswords = rs.getString("passwordUser");
				String name = rs.getString("nameUser");
				String email = rs.getString("emailUser");
				
				if(paswords.equals(password) ) 
				{
					SetCookie(response, name,email);
					SetSession(request, login, password);
					GetCookie(request, response);
				}
				else 
				{
					pw.println("PASSWORD EROR");
				}
			}
		
		
	}	
			else {pw.println("LOGIN EROR");}
	} 
		catch (SQLException e) 
		{
			System.out.println("EROORRR!");
			e.printStackTrace();
		}		
	
	}

	private void SetCookie(HttpServletResponse response, String name, String email) {
		Cookie cookieName = new Cookie("name_User", name); 
		Cookie cookieEmail = new Cookie("email_User", email);	
		
		cookieName.setMaxAge(30 * 24 * 60 * 60);
		cookieEmail.setMaxAge(30 * 24 * 60 * 60);	
		
		response.addCookie(cookieName);
		response.addCookie(cookieEmail);
		
		
	}

	private void GetCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("Cp1251");           
        response.setCharacterEncoding("Cp1251"); 
		
		PrintWriter pw = response.getWriter();
		Cookie [] cookies = request.getCookies();
		
		pw.println("<h1>");
		pw.println("cookies, ");
		for (Cookie cookie : cookies) {			
				pw.println(cookie.getValue()+ " " + cookie.getName() + "<br>") ;					
		}
		pw.println("</h1>");
		
	}

	private void SetSession(HttpServletRequest request, String login, String password) {
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", login);
		session.setAttribute("passwordUser", password);
		
	}
        
}
