package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bo.khachhangbo;



/**
 * Servlet implementation class dangnhapController
 */
@WebServlet("/dangnhapController")
public class dangnhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("t1");
			String password = request.getParameter("txtpass");
			khachhangbo khbo = new khachhangbo();

			if (username == null || password == null) {
				RequestDispatcher rd  = request.getRequestDispatcher("foodController");
				rd.forward(request, response);
			
			}
			else {
				khachhangbean kh = khbo.ktdn(username, password);
				if (kh!=null) {
					HttpSession session = request.getSession();
						session.setAttribute("dn", kh);
						session.setAttribute("tendn", kh.getHoten());
						session.setAttribute("makh", kh.getMakh());
						
						response.sendRedirect("foodController");
					} else {
						RequestDispatcher rd  = request.getRequestDispatcher("foodController?tb=1");
						rd.forward(request, response);
					}		
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
