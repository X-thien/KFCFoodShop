<%@page import="bean.loaibean"%>
<%@page import="bo.giohangbo"%>
<%@page import="bean.lichsubean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
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
        <form method = "POST" action = "dangkiController">
    		<div class="form-group" style = "width: 100%;">
				Un: <input type='text' name='t2' class="form-control" placeholder="Nhap username"><br>
				Pass: <input type='password' name='txtpass2' class="form-control"><br>
				Email: <input type='text' name='email' class="form-control" placeholder="Nhap email"><br>
				Hoten: <input type='text' name='ht' class="form-control" placeholder="Nhap ho ten"><br>
				SDT: <input type='text' name='sdt' class="form-control" placeholder="Nhap so dien thoai"><br>
				Dia chi: <input type='text' name='dc' class="form-control" placeholder="Nhap dia chi"><br>
 			<input type="submit" name="b1" class="text" value="Dang ky"> <br>
      		</div>
		</form>
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
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
                  <form role="form">
                    <div class="form-group">
                      <label for="usrname"><span class="glyphicon glyphicon-user"></span> Tên đăng nhập</label>
                      <input type="text" class="form-control" id="usrname" placeholder="Enter email">
                    </div>
                    <div class="form-group">
                      <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Mật khẩu</label>
                      <input type="password" class="form-control" id="psw" placeholder="Enter password">
                    </div>
                    <div class="checkbox">
                      <label><input type="checkbox" value="" checked>Lưu mật khẩu</label>
                    </div>
                      <a href = "dangnhapController" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Đăng nhập</a>
                  </form>
                </div>
                <div class="modal-footer">
                  <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                  <p>Chưa có tài khoản? <a href="#">Đăng ký</a></p>
                  <p>Quên mật khẩu <a href="#">Password?</a></p>
                </div>
              </div>
            </div>
          </div> 
<!-- ---------------------------------------------------------------------------------------------------------------------- -->
<table class ="table">
	<tr>
		<th>	Ma Food	</th>
		<th>	Ten Food	</th>
		<th>	So Luong Mua	</th>
		<th>	Ngay Mua	</th>
 		<th>	Gia</th>
		<th>	Da Mua	</th>
		<th>	Thanh Tien	</th>
		<th>	Ma Khach Hang	</th>
		
		</tr>
	<%

		ArrayList<lichsubean> ds =(ArrayList<lichsubean>)request.getAttribute("dslichsu"); 
		int n = ds.size();
		long makh = (long)session.getAttribute("makh");

		for(int i = 0; i<n; i++ ){
		
			lichsubean s = ds.get(i);
 			
			%>
			<tr>
			<% if(s.getMakh()==makh){ %>
				<td><%=s.getMafood() %></td>
				<td><%=s.getTenfood() %></td>
				<td><%=s.getSoluongmua() %></td>
				<td><%=s.getNgaymua() %></td>
				<td><%=s.getGia() %></td>
				<td><%=s.getDamua() %></td>
				<td><%=s.getThanhtien() %></td>
				<td><%=s.getMakh() %></td>
				</tr>
				<%} %>
				<% }%> 
 		</table>
</body>
</html>