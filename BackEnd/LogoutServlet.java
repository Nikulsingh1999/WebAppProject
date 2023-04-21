import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;
public class LogoutServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		RequestDispatcher disp=req.getRequestDispatcher("home.html");
		disp.include(req,res);
		HttpSession session=req.getSession(false);
		session.invalidate();
		out.println("succesfully logged out");
	}
}