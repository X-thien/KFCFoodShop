package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dangkydao;

/**
 * Servlet implementation class dangkyController
 */
@WebServlet("/dangkyController")
public class dangkyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("t2");
			String password = request.getParameter("txtpass2");
			String hoten = request.getParameter("ht");
			String email = request.getParameter("email");
			String sdt = request.getParameter("sdt");
			String dc = request.getParameter("dc");
			if (username == "" || password == "") {
				RequestDispatcher rd  = request.getRequestDispatcher("foodController");
				rd.forward(request, response);
			}
			else {
				
				dangkydao kh  = new dangkydao();
				kh.themkh(hoten, dc, sdt, email, username, password);
					PrintWriter out = response.getWriter();
					out.print("Xin chao");
					RequestDispatcher rd  = request.getRequestDispatcher("foodController");
					rd.forward(request, response);					
				}
		} catch (Exception e) {
			// TODO: handle exception
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
