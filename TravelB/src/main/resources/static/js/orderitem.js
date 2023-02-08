$(document).ready(function () {

    checkuser()

});


function checkuser(){
    $.ajax({
        url: "http://localhost:8080/travel/index/checklogin",
        success: function (data) {


            selectorderitem(data);


        }, error: function () {
            document.location.href = "http://localhost:8080/travel/login";
        }
    });
}



function selectorderitem(data) {


    $.ajax({
        type: "GET",
        url: "http://localhost:8080/travel/user/" + data.email + "/orderitem",
        dataType: 'json',
        contentType: "application/json ; charset=utf-8",
        success: function (data) {

      
            Info(data);
           

        },
        error: () => {



        }
    });
}
//
function Info(data) {
    console.log(data);
    $("#selectItemOrder").empty();

    var a = data.orderItemList;
  
  

    var html = ""  


    for(i=0;i<a.length;i++){
        
    

        html =
            `           
            <div>
            <span>${data.orderItemList[i].orderItemId}</span>
            <span>${data.orderItemList[i].name}</span>
            <span>${data.orderItemList[i].town}</span>
            <span>${data.orderItemList[i].tel}</span>
            <span>${data.orderItemList[i].amount}</span>
            <span>${data.createdDate}</span>
            </div>
              
            `
            $("#selectItemOrder").append(html);
    }




       
  
}
