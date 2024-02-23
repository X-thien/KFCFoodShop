<%@page import="bo.giohangbo"%>
<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <style>
  		.txt{
  			
  			float:right;
  		}
  		hr{
  			margin-top: 5px;
    		margin-bottom: 5px;
  		}
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li><a href="AdminloaiController">Quản lý loại</a></li>  
      <li><a href="AdminfoodController">Quản lý  food</a></li>     
      <li><a href="AdminxacnhanController">Xác nhận hóa đơn</a></li>
      <li><a href="AdmindanhsachController">Khách hàng đã chuyển tiền</a></li>
    </ul>
    
  </div>
</nav>


<%if(request.getAttribute("ml")!=null){ 
		ArrayList<loaibean> ds =(ArrayList<loaibean>)request.getAttribute("dsloai");
		int n = ds.size();
		for(int i=0; i<n; i++){
			if(ds.get(i).getMaloai().equals(request.getAttribute("ml"))){%>
			
			<form action="AdminloaiController" method="post" style="width:280px; height:120px">
				Mã loại: 	<input name="txtmaloai" type= "text" class="txt" value="<%=ds.get(i).getMaloai() %>"><hr>
				Tên loại: 	<input name="txttenloai" type="text" class="txt" value="<%=ds.get(i).getTenloai()%>"><hr>
			<input name="butadd" type="submit" value="Add">
			<input name="butupdate" type="submit" value ="Update">
			</form>
			<%} %>
		<%} %>



<%} else { %>		
<form style="width:280px; height:120px" action="AdminloaiController" method="post">
	Mã loại: 	<input name="txtmaloai" type= "text" class="txt"><hr>
	Tên loại: 	<input name="txttenloai" type="text" class="txt"><hr>
	<input name="butadd" type="submit" value="Add">
	<input name="butupdate" type="submit" value ="Update">
</form>
<%} %>
<h2>Danh sách loại</h2><br>
<table class="table table-hover">
<tr>
	<td>Mã loại</td>
	<td>Tên loại</td>
	<td>Chức năng</td>
</tr>
<%
	ArrayList<loaibean> ds = (ArrayList<loaibean>)request.getAttribute("dsloai");
	for(loaibean loai: ds){
%>
<tr>
	<td><%=loai.getMaloai() %></td>
	<td><%=loai.getTenloai() %></td>
	<td><a href ="AdminloaiController?ml=<%=loai.getMaloai()%>&tab=chon">Select</a></td>
	<td><a href ="AdminloaiController?ml=<%=loai.getMaloai()%>&tab=xoa">Delete</a></td>
</tr>

<%} %>
</table>
</body>
</html>