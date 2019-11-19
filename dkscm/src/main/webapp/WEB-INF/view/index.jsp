<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>DK采购系统</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">    
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <script src="assets/js/chart-master/Chart.js"></script>
    <script type="text/javascript">
    	function oneFrom(url, menuIcon, menuText, childMenuMenuText) {
			$("#menuIcon").attr("class", menuIcon);
			$("#menuText").html(menuText);
			$("#childMenuMenuText").html(childMenuMenuText);
						
			var height = $("#content").parent().innerHeight();
			
			var iframe = "<iframe src='"+url+"' style='border : 0px; width: 100%; height:"+height+"px;' onscroll='true'></iframe>";
			$("#content").html(iframe);
		}
    </script>
  </head>

  <body>

  <section id="container" >
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <a href="index.html" class="logo"><b>DK采购系统</b></a>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="#">退出系统</a></li>
            	</ul>
            </div>
        </header>
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              	  <p class="centered"><a href="profile.html"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">主页</h5>
                  <c:forEach var="menu" items="${menusist }">
                  	<li class="sub-menu">
                      <a href="#" >
                          <i class="${menu.menuIcon }"></i>
                          <span>${menu.menuText }</span>
                      </a>
                      <ul class="sub">
                          <c:forEach var="childMenu" items="${menu.childList }">
                          	<li>
                          		<a  href="javascript:oneFrom('${childMenu.menuUrl }', '${menu.menuIcon }', '${menu.menuText }', '${childMenu.menuText }')">
                          			<i class="${childMenu.menuIcon }"></i>
                          			${childMenu.menuText }
                          		</a>
                          	</li>
                          </c:forEach>
                      </ul>
                  </li>
                  </c:forEach>
              </ul>
          </div>
      </aside>
  	</section>
    <section id="main-content">
    	<section class="wrapper">
    		<div class="content">
    			<h1>DK采购系统</h1>
    			<ol class="breadcrumb">
	      			<li>
	      				<a href="#">
	      					<i id="menuIcon"></i> 
	      					<span id="menuText"></span>
     					</a>
    				</li>
				    <li class="active">
				      <span id="childMenuMenuText"></span>
				    </li>
				 </ol>
    		</div>
    	</section>
    	<section id="content" class="content"></section>
    </section>

    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/jquery-1.8.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="assets/js/jquery.sparkline.js"></script>
    <script src="assets/js/common-scripts.js"></script>
    <script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javacript" src="assets/js/gritter-conf.js"></script>
    <script src="assets/js/sparkline-chart.js"></script>    
	<script src="assets/js/zabuto_calendar.js"></script>	
	
	
	<script type="application/javascript">
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    </script>
  </body>
</html>
