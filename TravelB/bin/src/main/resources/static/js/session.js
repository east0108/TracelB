$(document).ready(function(){
 
  Checklogin();
});
function Checklogin() {
  $.ajax({
    url: "http://localhost:8080/travel/index/checklogin",
    success:function() {
	
	
		var html='<div  id="toMember" class="nav-item dropdown">'
                  +  '<a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><img src="images/person.png"></a>'
                  +  '<span class="dropdown-menu m-0">'
                  +	 '<a href="" class="dropdown-item">購買紀錄</a>'
                  +  '<a href="memberCentre" class="dropdown-item">會員中心</a>'
                  +  '<a href="http://localhost:8080/travel/logout" class="dropdown-item">登出</a>'
                  + '</span>'
                  + '</div>';
		
				$("#navbarCollapse").append(html);
    },error:function (){
		var html=' <div id="toLogin">'
					+	'<a  href="register" class="nav-item nav-link" >註冊</a>'
               		+	'</div>'
          			+	'<div>'
          			+	'<a  href="login" class="btn btn-primary rounded-pill py-2 px-4">登入</a>'
					+	'</div>'	
		$("#navbarCollapse").append(html);
    }
  });
}