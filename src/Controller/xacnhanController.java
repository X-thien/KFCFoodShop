package Controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.chitietbo;
import bo.giohangbo;
import bo.hoadonbo;
import bean.giohangbean;
import bean.khachhangbean;

/**
 * Servlet implementation class xacnhanController
 */
@WebServlet("/xacnhanController")
public class xacnhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			khachhangbean kh =(khachhangbean)session.getAttribute("dn");
			String xacnhan = request.getParameter("xacnhan");
			if (xacnhan != null) {
			if(kh==null) { //khach hang chua dang nhap
				RequestDispatcher rd  = request.getRequestDispatcher("foodController");
				rd.forward(request, response);
			}else{
				
				giohangbo gh=(giohangbo)session.getAttribute("gh");
				if(gh!=null) {
					System.out.println(1);
					// co hang trong gio
					//Tao 1 hoa don
					hoadonbo hdbo = new hoadonbo();
					hdbo.Them(kh.getMakh());
					long mahd = hdbo.getMaxHD();
					// Duyet gio de luu vao chi tiet hoa don
					chitietbo ct = new chitietbo();
					for(giohangbean g: gh.ds)
						ct.Them(g.getMafood(), g.getSoluongmua(), mahd);
					// Xoa gio hang
					session.removeAttribute("gh");
					RequestDispatcher rd  = request.getRequestDispatcher("htgioController");
					rd.forward(request, response);
				}
			}
			}
			String[] d = request.getParameterValues("tf");
			if(d!=null){
			giohangbo g= new giohangbo();
			
			g=(giohangbo)session.getAttribute("gh");

			for(int i = 0 ; i<d.length; i++){	
				int sh=g.ds.size();
				for(int j=0; j<sh; j++){
					if(g.ds.get(j).getTenfood().equals(d[i])){
				g.ds.remove(j);
				break;
			}
				}
				
		}

			RequestDispatcher rd  = request.getRequestDispatcher("htgioController");
			rd.forward(request, response);	}
		}catch (Exception e) {
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
