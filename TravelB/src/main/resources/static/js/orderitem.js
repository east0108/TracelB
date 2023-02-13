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

function deleteOrderId(data){
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/travel/user/" + data + "/delectOrder",
        dataType: 'json',
        contentType: "application/json ; charset=utf-8",
        success: function () {

            location.reload()
            

        },
        error: () => {



        }
    });
}




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
      
        for(i=0;i<=data.results.length;i++){
            html = 

              
            `
           <style>
           table, th, td {
             border:1px solid black;
             border-collapse: collapse;
   	         width: 100%; 	
        	 /*自動斷行*/
   	         word-wrap: break-word;
   	         table-layout: fixed;
           }
           </style>


            <table style="width:100%">     
            <tr>
                <th>訂單編號</th>             
                <th>創建時間</th>
                <th>訂單總額</th>
                <th>刪除</th>
            </tr>
            
            <tr>
                <td>${data.results[i].orderId}</td>                      
                <td>${data.results[i].createdDate}</td>
                <td>${data.results[i].totalAmount}</td>
                <td><button onclick="deleteOrderId(${data.results[i].orderId})">確定刪除</button></td>
              </tr>
            </table>
            `
            $("#selectItemOrder").append(html);
          
            for(s=0;s<data.results[i].orderItemList.length;s++){
              html = `
                      <table style="width:100%">
                       
                      <tr>
                         <th>景點名稱</th>
                         <th>景點地區</th>
                         <th>景點地址</th>
                         <th>門票價格</th>
                      </tr>

                      
                      <tr>
                        <td>${data.results[i].orderItemList[s].name}</td>
                        <td>${data.results[i].orderItemList[s].town}</td>
                        <td>${data.results[i].orderItemList[s].address}</td>
                        <td>${data.results[i].orderItemList[s].tickets}</td>
                      </tr>
                      </table>
                      `
              $("#selectItemOrder").append(html);
            }
          }

            }
    

       
  
 
