package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.loaibo;
import bean.loaibean;

/**
 * Servlet implementation class AdminloaiController
 */
@WebServlet("/AdminloaiController")
public class AdminloaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminloaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			loaibo lbo = new loaibo();
			request.setAttribute("dsloai", lbo.getloai());
			String tab = request.getParameter("tab");
			String ml = request.getParameter("txtmaloai");
			String tenloai = request.getParameter("txttenloai");
			ArrayList<loaibean> ds = lbo.getloai();
			if(request.getParameter("butadd")!=null) {
				lbo.themloai(ml, tenloai);
			}else 
				if(request.getParameter("butupdate")!=null) {
					lbo.CapNhap(ml, tenloai);
				}else {
					String maloai = request.getParameter("ml");
					if(tab != null && tab.equals("xoa"))
						lbo.Xoa(maloai);
					else
						if(tab != null && tab.equals("chon")) {
							request.setAttribute("ml", maloai);
//							request.setAttribute(tenloai, lbo.themloai(maloai, tenloai));
						}
				}
			request.setAttribute("dsloai", lbo.getloai());
			RequestDispatcher rd = request.getRequestDispatcher("adminloai.jsp");
			rd.forward(request, response);
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
