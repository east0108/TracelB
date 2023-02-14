
// *****************************************
// Triggers / Events
// *****************************************
// Add item


var cartArray ;

function displayCart() {
    cartArray = shoppingCart.listCart();
    var output = "";
    for (var i in cartArray) {
        output += "<tr>"
            + "<td>" + cartArray[i].name + "</td>"
            + "<td>(" + cartArray[i].price + ")</td>"
            + "<td><div class='input-group'><button class='minus-item input-group-addon btn btn-primary' data-name=" + cartArray[i].name + ">-</button>"
            + "<input type='number' class='item-count form-control' data-name='" + cartArray[i].name + "' value='" + cartArray[i].count + "'>"
            + "<button class='plus-item btn btn-primary input-group-addon' data-name=" + cartArray[i].name + ">+</button></div></td>"
            + "<td><button id='' class='delete-item btn btn-danger' data-name=" + cartArray[i].name + "   >X</button></td>"
            + " = "
            + "<td>" + cartArray[i].total + "</td>"
            + "</tr>";
    }
    $('.show-cart').html(output);
    $('.total-cart').html(shoppingCart.totalCart());
    $('.total-count').html(shoppingCart.totalCount());
    // console.log(cartArray);

}

// $.getScript("js/session2.js", function(){
//     document.write(myFunction(cartArray));
// });
// Delete item button

$('.show-cart').on("click", ".delete-item", function (event) {
    var name = $(this).data('name')
    shoppingCart.removeItemFromCartAll(name);
    displayCart();
})


// -1
$('.show-cart').on("click", ".minus-item", function (event) {
    var name = $(this).data('name')
    shoppingCart.removeItemFromCart(name);
    displayCart();
})
// +1
$('.show-cart').on("click", ".plus-item", function (event) {
    var name = $(this).data('name')
    shoppingCart.addItemToCart(name);
    displayCart();
})

// Item count input
$('.show-cart').on("change", ".item-count", function (event) {
    var name = $(this).data('name');
    var count = Number($(this).val());
    shoppingCart.setCountForItem(name, count);
    displayCart();
});



// Clear items
$('.clear-cart').click(function() {
    shoppingCart.clearCart();
    displayCart();
});

displayCart();
myFunction(cartArray);
//要丟，使用者的ID，跟我所購買商品的編號和數量

function myFunction(traveldata) {
	
    
  // console.log(traveldata);
	
	
	
    $.ajax({ 
    url: "http://localhost:8080/travel/index/checklogin",
        async:false,
    success:function(data) {
      
    // console.log(traveldata);
		clickEmail(data,traveldata);
		
    },error:function (){
		document.location.href = "http://localhost:8080/travel/login";
    }
  });
}

function clickEmail(data,traveldata) {

    var createOrderRequest ={
        "buyItemList": []
    }
    for(i=0;i<traveldata.length;i++){
        var OrderRequest ={
            "productId":traveldata[i].id,
            "quantity":traveldata[i].count
        }
        createOrderRequest.buyItemList.push(OrderRequest)
    }

    console.log(createOrderRequest);



  var createOrderRequest ={
    "buyItemList": []
  }
  for(i=0;i<traveldata.length;i++){
    var OrderRequest ={
      "productId":traveldata[i].id,
      "quantity":traveldata[i].count
    }
    createOrderRequest.buyItemList.push(OrderRequest)
  }
  console.log(createOrderRequest);

	$.ajax({
    url: "http://localhost:8080/travel/user/" + data.email + "/orderitem",
    type: "POST",
    dataType : 'json',
    contentType: "application/json ; charset=utf-8",
  	data: JSON.stringify(createOrderRequest),
   
    success:function(data) {
     //var a = document.getElementById("travelvalue").innerHTML
      // var a = $("#travelvalue+span");
        shoppingCart.clearCart();
		 console.log(data);
        location.reload();
    },
	  error:function (){
		console.log("no");
    }
});
		
}

