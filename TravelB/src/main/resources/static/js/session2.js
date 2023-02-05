//要丟，使用者的ID，跟我所購買商品的編號和數量
function myFunction() {
	
	
	
	
    $.ajax({
    url: "http://localhost:8080/travel/index/checklogin",
    success:function(data) {
	
		clickEmail(data);
		console.log(data.email);
		
    },error:function (){
		document.location.href = "http://localhost:8080/travel/login";
    }
  });
}

function clickEmail(data) {
	
	
		
 	$.ajax({
    url: "http://localhost:8080/travel/users/" + data.email + "/orders",
    type: "POST",
  
    
    success:function() {
	
		console.log("ok2");
		
    },error:function (){
		console.log("no");
    }
  });
 	
 	


}

