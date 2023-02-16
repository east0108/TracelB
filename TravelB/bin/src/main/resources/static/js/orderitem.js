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

            console.log(data)
            Info(data);
          

        },
        error: () => {



        }
    });
}

function deleteOrderId(data){
    console.log(data)
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
    console.log(data.results[0].orderId);
    $("#selectItemOrder").empty();

    
  
  

     var html = ""  

    //  $.each(data, function (index, item) {
        
    //     console.log(item[0])
        
    //     <span>${item.orderId}</span>
        

    //     
              
    //     `
       
        

        // <span>${data.total}</span>
        // <span>${data.results[i].orderItemList[i].name}</span>
        //<span>${data.results[0].totalAmount}</span>
        
        // <span>${data.results[0].createdDate}</span>
      

       
        // for(i=0;i<=data.results.length;i++){
        //     html = 

        // for(i=0;i<=data.results.length;i++){

            
        //     html = 


              
        //     `
        //    <style>
        //    table, th, td {
        //      border:1px solid black;
        //      border-collapse: collapse;
   	    //      width: 100%; 	
        // 	 /*自動斷行*/
   	    //      word-wrap: break-word;
   	    //      table-layout: fixed;
        //    }
        //    </style>


        //     <table style="width:100%">     
        //     <tr>
        //         <th>訂單編號</th>             
        //         <th>創建時間</th>
        //         <th>訂單總額</th>
        //         <th>刪除</th>
        //     </tr>
            
        //     <tr>
        //         <td>${data.results[i].orderId}</td>                                 
        //         <td>${data.results[i].createdDate}</td>
        //         <td>${data.results[i].totalAmount}</td>
        //         <td><button onclick="deleteOrderId(${data.results[i].orderId})">確定刪除</button></td>
        //       </tr>
        //     </table>
        //     `
        //     $("#selectItemOrder").append(html);
            
          
        //     for(s=0;s<data.results[i].orderItemList.length;s++){
        //       html = 
        //             `
        //               <table style="width:100%">
                       
        //               <tr>
        //                  <th>景點名稱</th>
        //                  <th>景點地區</th>
        //                  <th>景點地址</th>
        //                  <th>門票價格</th>
        //                  <th>門票張數</th>
        //               </tr>

                      
                     //<tr>
                       // <td>${data.results[i].orderItemList[s].name}</td>
                       // <td>${data.results[i].orderItemList[s].town}</td>
                      //  <td>${data.results[i].orderItemList[s].address}</td>
                        //<td>${data.results[i].orderItemList[s].tickets}</td>
                      //</tr>
                    //  </table>
//                       `
//               $("#selectItemOrder").append(html);
//             }
//           }
        
//         });
//     }
// =======
//         //               <tr>
//         //                 <td>${data.results[i].orderItemList[s].name}</td>
//         //                 <td>${data.results[i].orderItemList[s].town}</td>
//         //                 <td>${data.results[i].orderItemList[s].address}</td>
//         //                 <td>${data.results[i].orderItemList[s].tickets}</td>
//         //                 <td>${data.results[i].orderItemList[s].quantity}</td>
//         //               </tr>
//         //               </table>
//         //               `
        //       $("#selectItemOrder").append(html);
        //     }
        //   }

html=`
<div class="dashboard-box">
    <h2 class="dashbord-title">購買紀錄</h2>
</div>

`
$("#selectItemOrder").append(html);  

for(i=0;i<=data.results.length;i++){
html=
`
<div id="content" class="section-padding">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-8 col-lg-9">
                <div class="page-content">
                    <div class="inner-box">
                      
                        <div class="dashboard-wrapper">
                            <nav class="nav-table">
                            </nav>
                            <table class="table dashboardtable tablemyads">
                                <thead>
                                <tr>    
                                    <th></th>                                                         
                                    <th>訂單編號</th>             
                                    <th>創建時間</th>
                                    <th>訂單總額</th>
                                    <th>刪除</th>  
                                </tr>

                              
                                </thead>
                                <tbody>


                                <tr data-category="active">
                                    <td>
                                        <a class="btn btn-primary" data-bs-toggle="collapse" href="#collapseExample"
                                           role="button" aria-expanded="false" aria-controls="collapseExample">
                                            商品詳細
                                        </a>
                                    </td>
                                    
                                    <td>${data.results[i].orderId}</td>
                                    <td>${data.results[i].createdDate}</td>
                              
                                    <td data-title="Title">
                                        <h3>${data.results[i].totalAmount}</h3>
                                    </td>
                                    <td data-title="Action">
                                        <div class="btns-actions">                            
                                            <button onclick="deleteOrderId(${data.results[i].orderId})" class="btn-action btn-delete"><i class="lni-trash">刪除清單</i></button>
                                        </div>
                                    </td>
                                   
                                 
                                 
                                </tr>

                                </tbody>
                            </table>
                            `
                            $("#selectItemOrder").append(html);  
                            for(s=0;s<data.results[i].orderItemList.length;s++){
                                     html = 
                                            `

                                 
                                <div class="collapse" id="collapseExample">
                                    <div class="card card-body">
                                                
                                                  <table style="width:100%">
                                                   
                                                  <tr>
                                                     <th>景點名稱</th>
                                                     <th>景點地區</th>
                                                     <th>景點地址</th>
                                                     <th>門票價格</th>
                                                     <th>門票張數</th>
                                                   </tr>
                            
                                                  
                                                  <tr>
                                                  <td>${data.results[i].orderItemList[s].name}</td>
                                                  <td>${data.results[i].orderItemList[s].town}</td>
                                                  <td>${data.results[i].orderItemList[s].address}</td>
                                                  <td>${data.results[i].orderItemList[s].tickets}</td>
                                                  <td>${data.results[i].orderItemList[s].quantity}</td>
                                                  </tr>
                                                  </table>
                                                   
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
`
$("#selectItemOrder").append(html);  

                            }
                        }
                    }
              


                    
            
            // var html = ""
            
            // html =` 
            // <div id="content" class="section-padding">
            // <div class="container">
            //     <div class="row">
            //         <div class="col-sm-12 col-md-8 col-lg-9">
            //             <div class="page-content">
            //                 <div class="inner-box">
            //                     <div class="dashboard-box">
            //                         <h2 class="dashbord-title">購買紀錄</h2>
            //                     </div>
            //                     <div class="dashboard-wrapper">
            //                         <nav class="nav-table">
            //                         </nav>
            //                         <table class="table dashboardtable tablemyads">
            //                             <thead>
            //                             <tr>
            //                                 <th>
            //                                 </th>
            //                                 <th>照片</th>
            //                                 <th>標題</th>
            //                                 <th>類別</th>
            //                                 <th>商品</th>
            //                                 <th>價格</th>
            //                                 <th>狀態</th>
            //                             </tr>
            //                             </thead>
            //                             <tbody>
        
        
            //                             <tr data-category="active">
            //                                 <td>
            //                                     <a class="btn btn-primary" data-bs-toggle="collapse" href="#collapseExample"
            //                                        role="button" aria-expanded="false" aria-controls="collapseExample">
            //                                         商品詳細
            //                                     </a>
            //                                 </td>
            //                               <!--購物車-->
            //                                 <td class="photo"><img class="img-fluid" src=""
            //                                                        alt=""></td>
            //                                 <td data-title="Title">
            //                                     <h3>HP Laptop 6560b core i3 3nd generation</h3>
            //                                 </td>
            //                                 <td data-title="Category"><span class="adcategories">Laptops & PCs</span>
            //                                 </td>
            //                                 <td data-title="Ad Status"><span
            //                                         class="adstatus adstatusactive">active</span></td>
            //                                 <td data-title="Price">
            //                                     <h3>139$</h3>
            //                                 </td>
            //                                <!--按鈕-->
            //                                 <td data-title="Action">
            //                                     <div class="btns-actions">
            //                                         <a class="btn-action btn-view" href="#"><i class="lni-eye">顯示</i></a>
            //                                         <a class="btn-action btn-delete" href="#"><i class="lni-trash">刪除</i></a>
            //                                     </div>
            //                                 </td>
            //                             </tr>
        
            //                             </tbody>
            //                         </table>
                                   
            //                             </div>
            //                     </div>
            //                 </div>
            //             </div>
            //         </div>
            //     </div>
            // </div>
            
            // `
            
            
          
    


 

        
       
  
    
    
    

