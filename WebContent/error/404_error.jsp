<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">

<title>요청 페이지 오류</title>

</head>
<body>
	<div class="content-wrapper" style="min-height: 1592.4px;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>404 에러 발생</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="javascript:history.go(-1)">돌아가기</a></li>
              <li class="breadcrumb-item active">404에러 페이지</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="error-page">
        <h2 class="headline text-warning"> 404</h2>

        <div class="error-content">
          <h3><i class="fas fa-exclamation-triangle text-warning"></i> 해당 페이지를 찾을수 없습니다.</h3>

          <p>
            	올바른 페이지를 요청하여주세요.<br/>
            서비스 이용에 감사드립니다. <a href="javascript:history.go(-1)">이전 화면으로 이동하기</a>
          </p>

          <form class="search-form">
            <div class="input-group">
<!--               <input type="text" name="search" class="form-control" placeholder="Search"> -->

              <div class="input-group-append">
<!--                 <button type="submit" name="submit" class="btn btn-warning"><i class="fas fa-search"></i> -->
<!--                 </button> -->
              </div>
            </div>
            <!-- /.input-group -->
          </form>
        </div>
        <!-- /.error-content -->
      </div>
      <!-- /.error-page -->
    </section>
    <!-- /.content -->
  </div>
  
  <script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/demo.js"></script>
  
</body>
</html>