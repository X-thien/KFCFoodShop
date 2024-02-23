<%@page import="bean.foodbean"%>
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
      <li><a href="AdminfoodController">Quản lý food</a></li>     
      <li><a href="AdminxacnhanController">xác nhận hóa đơn</a></li>
      <li><a href="AdmindanhsachController">Khách hàng đã chuyển tiền</a></li>
    </ul>
         
  </div>
</nav>
<%
response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");
	if(request.getAttribute("mf")!=null){ 
		ArrayList<foodbean> ds =(ArrayList<foodbean>)request.getAttribute("dsfood");
		int n = ds.size();
		for(int i=0; i<n; i++){
			if(ds.get(i).getMafood().equals(request.getAttribute("mf"))){%>
				<form action="AdminfoodController" method="post" style="width:300px; height:280px">
					Mã food: 	<input class="txt" name="txtmafood" type= "text" value = "<%=ds.get(i).getMafood() %>"><hr>
					Tên food: 	<input class="txt" name="txttenfood" type="text" value = "<%=ds.get(i).getTenfood() %>"><hr>
					Số lượng: 	<input class="txt" name="txtsoluong" type="text" value = "<%=ds.get(i).getSoluong()%>"><hr>
					Giá: 		<input class="txt" name="txtgia" type="text" value = "<%=ds.get(i).getGia()%>"><hr>
					Chi tiết: 	<input class="txt" name="txtchitiet" type="text" value = "<%=ds.get(i).getChitiet()%>"><hr>
					Mã Loại: 	<input class="txt" name="txtmaloai" type="text" value = "<%=ds.get(i).getMaloai() %>"><hr>
					Ảnh:	 	<input class="txt" name="txtanh" type="file" value = "<%=ds.get(i).getAnh() %>"><hr>
					<input name="butadd" type="submit" value="Add">
					<input name="butupdate" type="submit" value ="Update">
				</form>
			<%} %>
		<%} %>



<%} else { %>

<form action="AdminfoodController" method="post" style="width:300px; height:280px">
	Mã food: 	<input class="txt" name="txtmafood" type= "text"><hr>
	Tên food: 	<input class="txt" name="txttenfood" type="text"><hr>
	Số lượng: 	<input class="txt" name="txtsoluong" type="text"><hr>
	Giá: 		<input class="txt" name="txtgia" type="text"><hr>
	Chi tiết: 	<input class="txt" name="txtchitiet" type="text"><hr>
	Mã Loại: 	<input class="txt" name="txtmaloai" type="text"><hr>
	Ảnh:	 	<input class="txt" name="txtanh" type="file"><hr>
	<input name="butadd" type="submit" value="Add">
	<input name="butupdate" type="submit" value ="Update">
</form>
<%} %>
<h2>Danh sách Food</h2><br>
<table class="table table-hover">
<tr>
	<th>Mã food</th>
	<th>Tên food</th>
	<th>So Luong</th>
	<th>Giá</th>
	<th>Chi tiết</th>
	<th>Mã loại</th>
	<th>Ảnh</th>
	<th>Chức năng</th>
</tr>
<%
	ArrayList<foodbean> ds = (ArrayList<foodbean>)request.getAttribute("dsfood");
	for(foodbean food: ds){
%>
<tr>
	<td><%=food.getMafood() %></td>
	<td><%=food.getTenfood() %></td>
	<td><%=food.getSoluong() %></td>
	<td><%=food.getGia() %></td>
	<td><%=food.getChitiet() %></td>
	<td><%=food.getMaloai() %></td>
	<td><%=food.getAnh() %></td>
	<td><a href ="AdminfoodController?mf=<%=food.getMafood()%>&tab=chon">Select</a></td>
	<td><a href ="AdminfoodController?mf=<%=food.getMafood()%>&tab=xoa">Delete</a></td>
</tr>

<%} %>
</table>
</body>
</html>