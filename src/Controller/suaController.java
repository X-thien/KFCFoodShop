package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class suaController
 */
@WebServlet("/suaController")
public class suaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		giohangbo g = (giohangbo)session.getAttribute("gh");
		String mf = request.getParameter("mf");
		String maf = request.getParameter("maf");
		String sol = request.getParameter("sol");
		String sl = request.getParameter("sl");
		long slc = 0;
		if(sl !=null){
		slc = Long.parseLong(sl);
		}
		long slt = 0;
		if(sol!=null){
		slt = Long.parseLong(sol);
		}
		
		if(slc >= 0){
		g.Sua(mf, slc+1);
		}
		 
		 if(slt >= 0){
			 g.Sua(maf, slt-1);
		 }
		 session.setAttribute("gh", g);
		 RequestDispatcher rd  = request.getRequestDispatcher("htgioController");
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
