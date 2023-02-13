//要丟，使用者的ID，跟我所購買商品的編號和數量
function myFunction(traveldata) {
	
    
  console.log(traveldata);
	
	
	
    $.ajax({ 
    url: "http://localhost:8080/travel/index/checklogin",
    success:function(data) {
      
    console.log(traveldata);
		clickEmail(data,traveldata);
		
    },error:function (){
		document.location.href = "http://localhost:8080/travel/login";
    }
  });
}

function clickEmail(data,traveldata) {
	
  var createOrderRequest = {
    "buyItemList": [
        {
            "productId": traveldata
        }
    ]
  };
	
	$.ajax({
    url: "http://localhost:8080/travel/user/" + data.email + "/orderitem",
    type: "POST",
    dataType : 'json',
    contentType: "application/json ; charset=utf-8",
  	data: JSON.stringify(createOrderRequest),
   
    success:function(data) {
     //var a = document.getElementById("travelvalue").innerHTML
      // var a = $("#travelvalue+span");
		 console.log(data);
   
    },
	  error:function (){
		console.log("no");
    }
});
		
}

