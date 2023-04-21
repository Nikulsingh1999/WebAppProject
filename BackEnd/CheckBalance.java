import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
public class CheckBalance extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String accountno=req.getParameter("accountno");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","Nks@90120");
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select balance from accountdata where accountno='"+accountno+"'");
			while(rs.next()){
				out.println(rs.getString(1)+"Rs.");
			}
			RequestDispatcher disp=req.getRequestDispatcher("AfterLogin.html");
				disp.include(req,res);
			
		}
		catch(Exception e){}
	}
}
		
