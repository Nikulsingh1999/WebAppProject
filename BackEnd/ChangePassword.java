import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import javax.swing.*;
public class ChangePassword extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException{
	    res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String pass3=req.getParameter("passname3");
		String pass1=req.getParameter("passname1");
	    String pass2=req.getParameter("passname2");
		try{
		    Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","Nks@90120");
			Statement s=con.createStatement();
			
			if(pass1.equals(pass2)){
			s.executeUpdate("update employee set password='"+pass1+"' where password='"+pass3+"'");
			RequestDispatcher disp=req.getRequestDispatcher("index.html");
			out.println("password updated login again");
			disp.include(req,res);
			
			}
			else{
				JOptionPane.showMessageDialog(null,"passwords donot match","Alert message",JOptionPane.WARNING_MESSAGE);
					RequestDispatcher dispatcher=req.getRequestDispatcher("Changepassword.html");
					dispatcher.forward(req,res);
			}
		}
		catch(Exception e){}
	
	}
}
	
	
	