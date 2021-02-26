package manager.conference.servl.extern;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JumpToRegConfServlet
 */
@WebServlet("/jumptoregconfservlet")
public class JumpToRegConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JumpToRegConfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String language = request.getParameter("language");
		HttpSession session = request.getSession();
		session.setAttribute("language", language);
		RequestDispatcher rd = request.getRequestDispatcher(language.equals("en")?"addNewConf.jsp":"addNewConfRUS.jsp");
		rd.forward(request, response);
	}

}
