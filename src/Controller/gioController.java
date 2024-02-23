package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import bo.giohangbo;
/**
 * Servlet implementation class gioController
 */
@WebServlet("/gioController")
public class gioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mf = request.getParameter("mf");
			String tf = request.getParameter("tf");
			String chitiet = request.getParameter("chitiet");
			String giatam = request.getParameter("gia");
			//neu khong phai chay lan dau thi:
			if(mf!=null && tf!=null && giatam!=null){
				//doi gia tu chuoi ra so
				long gia = Long.parseLong(giatam);
				giohangbo gh= null;
				//neu chua tao session("gh") thi tao ra
				
				HttpSession session = request.getSession();
				if(session.getAttribute("gh") == null){
					gh = new giohangbo();
					session.setAttribute("gh", gh);
				}
				gh = (giohangbo)session.getAttribute("gh"); //luu session ra bien
				gh.ThemHang(mf, tf,chitiet, gia, 1);//goi ham them
				//luu bien vao lai session
				session.setAttribute("gh", gh);
				//dieu huong qua tra de hien thi gio hang
				response.sendRedirect("htgioController");
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
