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
        url: "http://localhost:8080/travel/users/" + data.email + "/orders",
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

    
  
  

    var html = ""  

    // $.each(data, function (index, item) {
        
    //     console.log(item[0])
    //    html= `
    //     <span>${item.orderId}</span>
        
    //     `
        
        
        
        




   

    
        
        // <span>${data.total}</span>
        // <span>${data.results[i].orderItemList[i].name}</span>
        //<span>${data.results[0].totalAmount}</span>
        
        // <span>${data.results[0].createdDate}</span>
      
        for(i=0;i<=data.total;i++){
            html = 
            `
            <div>
              <span>${data.results[i].orderId}</span>
              <span>${data.results[i].email}</span>        
              <span>${data.results[i].createdDate}</span>
              <span>${data.results[i].totalAmount}</span>
            </div>
            `
            $("#selectItemOrder").append(html);
          
            for(s=0;s<data.results[i].orderItemList.length;s++){
              html = `<div>
                      <span>${data.results[i].orderItemList[s].name}</span>
                      <span>${data.results[i].orderItemList[s].town}</span>
                      <span>${data.results[i].orderItemList[s].tickets}</span>
                      </div>`
              $("#selectItemOrder").append(html);
            }
          }

            }
    

       
  
 
