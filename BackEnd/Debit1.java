import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
public class Debit1 extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String accountno=req.getParameter("accountno");
		long credit=Long.parseLong(req.getParameter("amount"));
		
	
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","Nks@90120");
			Statement s1=con.createStatement();
		    ResultSet rs=s1.executeQuery("select balance from accountdata where accountno='"+accountno+"'");
			while(rs.next()){
				
			      long amount=Long.parseLong(rs.getString(1));
			
			      long newbalance=amount-credit;
			      Statement s=con.createStatement();
			      s.executeUpdate("update  accountdata set balance="+newbalance+" where accountno='"+accountno+"'");
				  out.println("<center><div class=image> new balance is "+newbalance+" </div></center>" );
			}
			RequestDispatcher disp=req.getRequestDispatcher("AfterLogin.html");
				disp.include(req,res);
			
			
			
			
		}
		catch(Exception e){System.out.println(e);}
	}
}