package manager.conference.servl.extern;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managment.conference.db.daoImpl.ConferenceDaoImpl;
import managment.conference.db.daoImpl.SpeechDaoImpl;
import manegment.conference.classes.Conference;
import manegment.conference.classes.Speech;

/**
 * Servlet implementation class ChangeSpeechServlet
 */
@WebServlet("/changespeechservlet")
public class ChangeSpeechServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeSpeechServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpeechDaoImpl speachDaoImpl = new SpeechDaoImpl();
		ConferenceDaoImpl conferenceDaoImpl = new ConferenceDaoImpl();
		String nameSpeech = request.getParameter("nameSpeech");
		String time = request.getParameter("time");
		String interval = request.getParameter("interval");
		String login = request.getParameter("login");
		HttpSession session = request.getSession();
		Speech speach = (Speech) session.getAttribute("speach");
		Conference conference = (Conference) session.getAttribute("conference");
		try {
			List<Conference> conferences = conferenceDaoImpl.getAllConferences();
			speachDaoImpl.changeParamSpeech(nameSpeech, time, interval, login, speach.getCode());
			List<Speech> speaches = speachDaoImpl.getSpeachbyConference(conference);
			RequestDispatcher rd = request.getRequestDispatcher("setSpeaches.jsp");
			request.setAttribute("conferences", conferences);
			request.setAttribute("speaches", speaches);
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
