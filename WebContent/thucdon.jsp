<%@page import="bo.giohangbo"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="bo.foodbo"%>
<%@page import="bean.foodbean"%>
<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<html >
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style >
  	
	
	
	li .dropdown{
		display: inline-block;
	}
	.dropdown-content{
		display: none;
		position: absolute;
		background-color: white;
		min-width:200px;
		box-shadow: 0 8px 16px 0px rgba(0,0,0,0.2);
		z-index:1;
	}
	.dropdown-content a{
		color: black;
		padding: 12px 16px;
		text-decoration: none;
		display: block;
		text-align: left;
	}
	.dropdown-content a:hover{
		background-color: #f1f1f1;
	}]
	.dropdown:hover .dropdown-content{
		display: block;
	}
	
	.row{
		display:flex;
		flex-wrap: wrap;
	}
	.q{
		padding:10px;
	}
	.ng-star-inserted{
		height:180px;
	}
	.text{
		height: 100px;
		font-size:20px;
		padding: 5px;
	    text-align: center;
	    color:black
	}
	.bottom{
		width:100%;
		display:inline-block;
		background-color: black;
		display: flex;
		align-items: center;
		justify-content: center;
		padding:20px 0;
	}
	.sec{
		width:1000px;
		
	}
	.menu{
		
		display:flex;
	}
  	.menu1{
  		width:200px;
  		align-content: left;
  		padding-left:8px;
  		color: #ababab;
  		
  	}
  	h5{
  		font-size: 16px;
  		color: white;
  	}
  	
  	.list li{
  		
  		font-size: 7px;
  		
  		
  	}
  	ul, li{
  		list-style-type: none;
  	}
  	ul{
  		padding-inline-start: 0px;
  	}
  	
  	hr {
	    margin-top: 1.28571429rem;
	    margin-bottom: 1.28571429rem;
	    border: 0;
	    border-top: 1px solid rgba(0,0,0,.1);
	}
	.botbot{
		color:white;
		width:495px;
		pading:5px;
	}
	.q1{
		width:222px;
    	margin: 3px;
	}
	a{
		text-decoration: none;
		color:black;
	}
	.a{
		padding:18px 15px 30px;
		background-color: #EEEEEE;
	}	
	p{
		height:60px;
		font:15px;
		margin: 0 0 15px;
	}
	.buy{
		text-align:center;
		width: 192px;
	}
  </style>
  
</head>


<body>

<%giohangbo b = (giohangbo)session.getAttribute("gh"); %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="" href="foodController" ><img src="Kfc_logo.png" style="height:50px;"></a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="foodController">Thực đơn</a></li>
      <li><a href="htgioController">Giỏ hàng</a></li>
      <li><a href="xacnhanController">Thanh toán</a></li>
      <li><a href="lichsuController">Lịch sử mua hàng</a></li>
      <li class="dropdown">
      	<a class="dropdown-toggle" data-toggle="dropdown" href="#">Danh mục
          <span class="caret"></span></a>	
            <ul class="dropdown-menu">
              <% 
			 	ArrayList<loaibean> dsloai =(ArrayList<loaibean>) request.getAttribute("dsloai");
			 	
			 	for(loaibean loai: dsloai){
			 	%>
			 
			 	<li><a href = "foodController?ml=<%=loai.getMaloai() %>"><%=loai.getTenloai() %></a></li>
			 	
			 	<%} %>
            </ul>
      </li>
    </ul>
    <form class="navbar-form navbar-left" action="foodController" method = "post">	
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name = "txttim">
      </div>
      <button type="submit" class="btn btn-default" style="background-color:#99FFFF">Submit</button>
    </form>
    
    <ul class="nav navbar-nav navbar-right">
      	<li><a href="" data-toggle="modal" data-target="#myModal1"><span class="glyphicon glyphicon-user"></span>Đăng ký</a></li>
      	<%if(session.getAttribute("dn")!=null){%>
      <li><a class = "nav-link" href = "" style ="line-height: 24px">Xin chao: <%=session.getAttribute("tendn") %></a></li>
		<%}else{ %>
      	<li><a href="" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
      	<% }%>
        <li><a href="dangxuatController"><span class="glyphicon glyphicon-log-in"></span> Đăng xuat</a></li>
    </ul>       
  </div>
</nav>

<!-- ---------------------------------------------------------------------------------------------------------------------- -->
<div class="modal" id="myModal1">
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Dang Ky</h4>
      </div>
      <!-- Modal body -->
      <div class="modal-body">
        <form method = "POST" action = "dangkyController">
    		<div class="form-group" style = "width: 100%;">
				Un: <input type='text' name='t2' class="form-control" placeholder="Nhập username"><br>
				Pass: <input type='password' name='txtpass2' class="form-control"><br>
				Email: <input type='text' name='email' class="form-control" placeholder="Nhập email"><br>
				Hoten: <input type='text' name='ht' class="form-control" placeholder="Nhập họ tên"><br>
				SDT: <input type='text' name='sdt' class="form-control" placeholder="Nhập số điện thoại"><br>
				Dia chi: <input type='text' name='dc' class="form-control" placeholder="Nhập địa chỉ"><br>
 			<input type="submit" name="b1" class="btn btn-default" value="Đăng ký"> <br>
      		</div>
		</form>
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Đóng</button>
      </div>
    </div>
  </div>
</div>
</div>

<!-- ---------------------------------------------------------------------------------------------------------------------- -->
           <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

              <!-- Modal content-->
              <div class="modal-content">
                <div class="modal-header" style="padding:35px 50px; background:#99FFFF;">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 style=" font-weight:bold"><span class="glyphicon glyphicon-lock" ></span> Đăng nhập</h4>
                </div>
                <div class="modal-body" style="padding:40px 50px;">
                  <form role="form" action = "dangnhapController" action = "post" >
                    <div class="form-group">
                      <label for="usrname"><span class="glyphicon glyphicon-user"></span> Tên đăng nhập</label>
                      <input type="text" class="form-control"  placeholder="Enter email" name = "t1">
                    </div>
                    <div class="form-group">
                      <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Mật khẩu</label>
                      <input type="password" class="form-control" id="psw" placeholder="Enter password" name ="txtpass">
                    </div>
                    <div class="checkbox">
                      <label><input type="checkbox" value="" checked>Lưu mật khẩu</label>
                    </div>
                      <input type = "submit"  class="btn btn-success btn-block" value = "Dang nhap">
                  </form>
                </div>
                <div class="modal-footer">
                  <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                  <p>Chưa có tài khoản? <a href="dangkyController">Đăng ký</a></p>
                  <p>Quên mật khẩu <a href="#">Password?</a></p>
                </div>
              </div>

            </div>
          </div> 

<div class="cuon" style="width:100%">
  <!--  h2>Carousel Example</h2> --> 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <!-- <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      
    </ol> -->

    <!-- Wrapper for slides -->
    <div class="carousel-inner" >
      <div class="item active">
        <img src="https://static.kfcvietnam.com.vn/images/content/home/carousel/lg/Homde-phase2.webp?v=38BDR4" alt="" style="width:100%;">
      </div>

      <div class="item">
        <img src="https://static.kfcvietnam.com.vn/images/content/home/carousel/lg/buatruavuive.webp?v=38BDR4" alt="" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="https://static.kfcvietnam.com.vn/images/content/home/carousel/lg/gacuon.jpg?v=38BDR4" alt="" style="width:100%;">
      </div>
      
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<div class="container ">
	 <div class="row">
	 <%
		response.setCharacterEncoding("utf-8");
 		request.setCharacterEncoding("utf-8");
 		foodbo fbo= new foodbo();
 		ArrayList<foodbean> ds =(ArrayList<foodbean>)request.getAttribute("dsfood");
 				int n = ds.size();
 				Locale locale = new Locale("vi", "VN");
 				NumberFormat giavn = NumberFormat.getCurrencyInstance(locale);
 				for(int i =0; i<n; i++){
 					foodbean f = ds.get(i);
 	%>
 		<div class="q1">
 			<div><img src="imagefood/<%=f.getAnh()%>" class="ng-star-inserted"></div>
			
			<div class="a">
				<div class="text">
					<div><a href = "foodController?mf<%= f.getMafood()%>"><%= f.getTenfood() %></a></div>				
					<div>Giá: <%=giavn.format(f.getGia()) %></div>
				</div>
				
				<p><%=f.getChitiet() %></p>
					
				<div class="buy">
					<a href="gioController?mf=<%=f.getMafood()%>&tf=<%=f.getTenfood()%>&chitiet=<%=f.getChitiet()%>&gia=<%=f.getGia()%>&sl=<%=f.getSoluong()%>&tf=
					<%=f.getTenfood()%>&anh=<%=f.getAnh()%>&ml=<%=f.getMaloai()%>"><img src ="mua.jpg"> <br></a>				
				</div>
			</div>
		</div>	
		<%} %> 
	</div>
		
</div>

<!-- ---------------------------------------------------------------------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------------------------------- -->

<div class="bottom">
<section class="sec">
	<div class="menu row"> 
		<div class="menu1">
			<div class="tt1"><h5><b>Danh muc mon an</b></h5></div>
			<div class="li">
				<ul>
					<li>COMBO 1 NGUOI</li>
					<li>COMBO NHOM</li>
					<li>GA RAN - GA QUAY</li>
					<li>BURGER - COM - MY Y</li>
					<li>THUC AN NHE</li>
					<li>THUC UONG & TRANG MIENG</li>
				</ul>
			</div>
			</div>
			<div class="menu1">
			<div class="tt1"><h5><b>Ve KFC</b></h5></div>
			<div class="li">
				<ul>
					<li>Câu Chuyện Của Chúng Tôi</li>
					<li>Tin Khuyến Mãi</li>
					<li>Tin tức KFC</li>
					<li>Tuyển dụng</li>
					<li>Đặt tiệc Sinh nhật</li>										
				</ul>
			</div>
			</div>
			<div class="menu1">
			<div class="tt1"><h5><b>Lien he KFC</b></h5></div>
				<div class="li">
					<ul>
						<li>Theo dõi đơn hàng</li>
						<li>Hệ Thống Nhà Hàng</li>
						<li>Liên hệ KFC</li>				
					</ul>
				</div>
			</div>
			<div class="menu1">
			<div class="tt1"><h5><b>Chinh sach</b></h5></div>
			<div class="li">
				<ul>
					<li>Chính sách hoạt động</li>
					<li>Chính sách và quy định</li>
					<li>Chính sách bảo mật thông tin</li>
				</ul>
			</div>
			</div>
			<div class="tt1"><h5><b>Download App</b></h5></div>
	</div>
	
	<hr style="color:white; background-color: white; ">
	
	<div class="botbot">
			<h2>CÔNG TY LIÊN DOANH TNHH KFC VIỆT NAM</h2>
			<div class="txt">Số 292 Bà Triệu, P. Lê Đại Hành, Q. Hai Bà Trưng, TP. Hà Nội.</div>
			<div class="txt">Điện thoại: (028) 38489828</div>
			<div class="txt">Email: lienhe@kfcvietnam.com.vn</div>
			<div class="txt">Mã số thuế: 0100773885</div>
			<div class="txt">Ngày cấp: 29/10/1998 - Nơi cấp: Cục Thuế Thành Phố Hà Nội</div>
	</div>
</section>
</div>
</body>
</html>