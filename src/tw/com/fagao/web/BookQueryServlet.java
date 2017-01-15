package tw.com.fagao.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book/query")
public class BookQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookQueryServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print("<form action='"+request.getContextPath()+"/BookServlet' method='get'>");
		out.print("<input type='text' name='id'/>");
		out.print("<input type='submit' >");
		out.print("</form>");
		
	}

}
