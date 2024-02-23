<%@page import="bo.giohangbo"%>
<%@page import="bean.xacnhanbean"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>

<%@page import="bean.loaibean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  

</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li><a href="AdminloaiController">Quản lý loại</a></li>  
      <li><a href="AdminfoodController">Quản lý food</a></li>     
      <li><a href="AdminxacnhanController">xác nhận hóa đơn</a></li>
      <li><a href="AdmindanhsachController">Khách hàng đã chuyển tiền</a></li>
    </ul>  
  </div>
</nav>


 <table style="width:100%">
 		<td width="200px" valign="top"> <h2>Danh Sách Hóa Đơn Cần Xác Nhận</h2>
 			<table class="table table-hover">
 			<tr>
 				<td>Họ tên</td>
 				<td>Tên food</td>
 				<td>Giá</td>
 				<td>Số lượng mua</td>
 				<td>Thành tiền</td>
 			</tr>
 			<% 
		 	ArrayList<xacnhanbean> dshoadon =(ArrayList<xacnhanbean>)request.getAttribute("dshoadon");
		 	
		 	for(xacnhanbean xn: dshoadon){
		 	%>
		 	<tr>
		 	<td><%=xn.getHoten() %></td>
		 	<td><%=xn.getTenfood() %></td>
		 	<td><%=xn.getGia() %></td>
		 	<td><%=xn.getSoluongmua() %></td>
		 	<td><%=xn.getThanhtien() %></td>
		 	<td><a href="AdminxacnhanController?mact=<%=xn.getMachitiethd()%>"> xacnhan</a></td>
		 	</tr>
		 	
		 	<%} %>
		 	</table>
		</td>
</table>
</body>
</html>

	