
$(document).ready(function () {


    datalist();
});
$("#search").click(function () {

    // console.log(123);
    
    
    datalist();
});





//全部+收尋
function datalist() {
    var url = "http://localhost:8080/travel/products";
    if ($("#travelTown").val() != "") {
         
        url += "?town=" + $("#travelTown").val()
        // console.log(url)
    }

    $.ajax({
        type: "GET",
        url: url,
        dataType: 'json',
        contentType: "application/json ; charset=utf-8",
        success: function (data) {

            // console.log(data);
            Info(data);


        },
        error: () => {



        }
    });
}
//
function Info(data) {
    $("#dataList").empty();
    // console.log(data)
    var html = ""
    $.each(data, function (index, item) {


          console.log(item)



        html = `
<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s"
style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
<div class="package-item">
    <div class="overflow-hidden">
        <img src="${item.picture}" class="img-fluid" alt="">
    </div>
    <div class="d-flex border-bottom">
        <small class="flex-fill text-center border-end py-2"><i
                class="fa fa-map-marker-alt text-primary me-2"></i>
            <span>${item.town}</span></small>

        <small class="flex-fill text-center border-end py-2"><i
                class="fa fa-map-marker-alt text-primary me-2"></i>
            <span id="travelvalue">${item.name}</span></small>
        <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>
            <span>${item.id}</span></small>
    </div>
    <div class="text-center p-4">
        <h3 class="mb-0">
            <span>${item.ticket}</span>
        </h3>
        <div class="mb-3">
            <small class="fa fa-star text-primary"></small>
            <small class="fa fa-star text-primary"></small>
            <small class="fa fa-star text-primary"></small>
            <small class="fa fa-star text-primary"></small>
            <small class="fa fa-star text-primary"></small>
        </div>
        <p1><span class="overflow-auto">${item.introduce}</span></p1>
        <div class="d-flex justify-content-center mb-2">
            <button onclick="myFunction(${item.id})" class="btn btn-sm btn-primary px-3 border-end"
                style="border-radius: 30px 0 0 30px;">購買
            </button>
        </div>
    </div>
</div>
</div>


</div>
</div>`
        $("#dataList").append(html);
    });
}

