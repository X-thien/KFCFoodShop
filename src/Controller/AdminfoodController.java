package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import bean.foodbean;
import bo.foodbo;


/**
 * Servlet implementation class AdminfoodController
 */
@WebServlet("/AdminfoodController")
public class AdminfoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminfoodController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
//		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
//		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "imagefood";
//		response.getWriter().println(dirUrl1);
//		
//		
// 		try {
//			response.setCharacterEncoding("utf-8");
//			request.setCharacterEncoding("utf-8");
//			foodbo fbo = new foodbo();
//			String mf = null, tenfood = null, maloai=null, chitiet = null, bta=null ;
//			long gia=0, soluong=0;
//			String nameimg = null;
//			List<FileItem> fileItem = upload.parseRequest(request);
//				for(FileItem fileitem1: fileItem) {
//					if(!fileitem1.isFormField()){ //neu ko phai la controller
//						 nameimg = fileitem1.getName();
//						if(!nameimg.equals("")) {
//							String dirUrl = "C:\\Users\\Admin\\eclipse-workspace\\foodshop\\WebContent\\imagefood";
//							File dir = new File(dirUrl);
//							if(!dir.exists()) {
//								dir.mkdir();
//							}
//							String fileImg = dirUrl + File.separator + nameimg;
//							File file = new File(fileImg);
//								try {
//									fileitem1.write(file);
//									System.out.println("Upload Thanh Cong");
//									System.out.println("Duong dan luu file la: " + dirUrl);
//								} catch (Exception e) {
//									e.printStackTrace();
//								}
//						}
//					}
//					else { //Neu la controller
//						ArrayList<foodbean> ds = new ArrayList<foodbean>();
//						String tentk = fileitem1.getFieldName();
//						if(tentk.equals("txtmafood")) {
//							mf = fileitem1.getString();
//						}
//						if(tentk.equals("txttenfood")) {
//							tenfood = new String(fileitem1.getString().getBytes("ISO-8859-1"), "utf-8");
//						}
//						if(tentk.equals("txtsoluong")) {
//							soluong = Long.parseLong(fileitem1.getString());
//						}
//						if(tentk.equals("txtgia")) {
//							gia = Long.parseLong(fileitem1.getString());
//						}
//						if(tentk.equals("txtmaloai")) {
//							maloai = fileitem1.getString();
//						}
//						if(tentk.equals("txtchitiet")) {
//							chitiet = fileitem1.getString();
//						}
//						if(tentk.equals("butadd")) {
//							bta = fileitem1.getString();
//						}
//						if(tentk.equals("butupdate")) {
//							bta = fileitem1.getString();
//						}
//						
//					}
//				}
//				if(bta.equals("Add")) {
//					System.out.println("Hello");
//					fbo.themfood(mf, tenfood, soluong, gia, maloai, chitiet, nameimg);
//				}
//				else {
//					if(bta.equals("Update")) {
//						fbo.CapNhapfood(mf, tenfood, soluong, gia, maloai, chitiet, nameimg);
//					}
//				}
//				
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			
//			String tab = request.getParameter("tab");
//			String mafood = request.getParameter("mf");
//			foodbo fbo = new foodbo();
//			if(tab!=null && tab.equals("xoa")) {
//				fbo.Xoafood(request.getParameter("mf"));
//			}
//			else {
//				if(tab!=null && tab.equals("chon")) {
//					request.setAttribute("mf", mafood);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			response.setCharacterEncoding("utf-8");
//			request.setCharacterEncoding("utf-8");
//			foodbo fbo = new foodbo();
//			request.setAttribute("dsfood", fbo.getfood());
//			RequestDispatcher rd = request.getRequestDispatcher("adminfood.jsp");
//			rd.forward(request, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			foodbo fbo = new foodbo();
			request.setAttribute("dsfood", fbo.getfood());
			String tab = request.getParameter("tab");
			String mf = request.getParameter("txtmafood");
			String tenfood = request.getParameter("txttenfood");
			String soluong = request.getParameter("txtsoluong");
			String gia = request.getParameter("txtgia");
			String maloai = request.getParameter("txtmaloai");
			String chitiet = request.getParameter("txtchitiet");
			String anh = request.getParameter("txtanh");
			/*
			 * Long soluong = Long.parseLong("txtsoluong"); Long gia =
			 * Long.parseLong("txtgia");
			 */
			
			ArrayList<foodbean> ds = fbo.getfood();
			if(request.getParameter("butadd")!=null) {
				fbo.themfood(mf, (new String(tenfood.getBytes("ISO-8859-1"),"utf-8")), Long.parseLong(soluong), Long.parseLong(gia), maloai,  (new String(chitiet.getBytes("ISO-8859-1"),"utf-8")), anh);
			}else 
				if(request.getParameter("butupdate")!=null) {
					fbo.CapNhapfood(mf, (new String(tenfood.getBytes("ISO-8859-1"),"utf-8")), Long.parseLong(soluong), Long.parseLong(gia), maloai,  (new String(chitiet.getBytes("ISO-8859-1"),"utf-8")),anh);
				}else {
					String mafood = request.getParameter("mf");
					if(tab != null && tab.equals("xoa"))
						fbo.Xoafood(mafood);
					else
						if(tab != null && tab.equals("chon")) {
							request.setAttribute("mf", mafood);
//							request.setAttribute(tenfood, fbo.themfood(mf, tenfood, 0, 0, chitiet, anh));
						}
				}
			request.setAttribute("dsfood", fbo.getfood());
			RequestDispatcher rd = request.getRequestDispatcher("adminfood.jsp");
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
