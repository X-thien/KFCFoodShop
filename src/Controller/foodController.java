package Controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.foodbean;
import bean.loaibean;
import bo.foodbo;
import bo.loaibo;



/**
 * Servlet implementation class foodController
 */
@WebServlet("/foodController")
public class foodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public foodController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			try {
				response.setCharacterEncoding("utf-8");
		 		request.setCharacterEncoding("utf-8");
				
				ArrayList<foodbean> ds ;
				foodbo fbo = new foodbo();
				ds = fbo.getfood();
				String ml = request.getParameter("ml");
				String key = request.getParameter("txttim");
					if(ml!= null ) 
					{					
						ds=fbo.getTimMa(ml);
					}
					else 
						if(key!=null) 
							ds= fbo.getTimKey(key);
						loaibo lbo= new loaibo();
						ArrayList<loaibean> dsloai = lbo.getloai();	
						request.setAttribute("dsfood", ds);	
						request.setAttribute("dsloai", dsloai);
						
						RequestDispatcher rd  = request.getRequestDispatcher("thucdon.jsp");
						rd.forward(request, response);
						
			}	catch (Exception e) {
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
