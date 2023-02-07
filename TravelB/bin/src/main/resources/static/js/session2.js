//要丟，使用者的ID，跟我所購買商品的編號和數量
function myFunction() {
	
	
	
	
	
    $.ajax({
    url: "http://localhost:8080/travel/index/checklogin",
    success:function(data) {
	
		clickEmail(data);
		
    },error:function (){
		document.location.href = "http://localhost:8080/travel/login";
    }
  });
}

function clickEmail(data) {
	var createOrderRequest = {
    "buyItemList": [
        {
            "productId": 11
        }
    ]
};

	
	$.ajax({
    url: "http://localhost:8080/travel/users/" + data.email + "/orders",
    type: "POST",
    dataType : 'json',
    contentType: "application/json ; charset=utf-8",
  	data: JSON.stringify(createOrderRequest),
   
    success:function() {
		console.log("ok2");
    },
	error:function (){
		console.log("no");
    }
});
		
}

