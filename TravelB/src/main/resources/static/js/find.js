var city = "";
var limit;
var pages;

//購物車JS(Shopping Cart API)










//----------------------------------------------------
//搜尋按下後觸發
$("#search").click(function () {


    //把Cookie 帶到搜尋頁面
    setCookie("city", $("#travelTown").val(), 365);
    // console.log(city);
    document.location.href = "http://localhost:8080/travel/find";

    datalist();

});

//設置Cookie
function setCookie(cname, cvalue, exdays) {
    const d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    let expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}
//得到Cookie
function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for (let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

var cookies;

//全部+搜尋
var url = "http://localhost:8080/travel/products?";
function datalist() {

    //從Cookie中 尋找city的Value值後進行搜尋
    cookies = getCookie("city");
    console.log(cookies);
    if (getCookie("city") != "") {
        url += "town=" + cookies;

    }

    $.ajax({
        type: "GET",
        url: url,
        dataType: 'json',
        contentType: "application/json ; charset=utf-8",
        success: function (data) {
            console.log(data);
            Info(data);
            setPage(Math.ceil(data.total / data.limit))
        },
        error: () => {


            document.location.href = "http://localhost:8080/travel/NO"


        }
    });

}
//輸出頁碼
function setPage(pageCount) {
    //var pageCount = data.pageCount;
    var pageHtml = '';
    var start, end;
    if (listPage < 6) {
        start = 1;
    } else {
        start = listPage - 5;
    }
    if (listPage > pageCount - 5) {
        end = pageCount;
    } else {
        end = listPage + 5;
    }

    if (listPage > 1) {
        pageHtml += '<span>上一頁</span>';
    }
    for (var i = start, page_cur = ''; i <= end; i++) {
        if (listPage == i) {
            page_cur = 'page_cur active';
        } else {
            page_cur = '';
        }
        pageHtml += '<span class="' + page_cur + '">' + i + '</span>';
    }
    if (listPage < pageCount) {
        pageHtml += '<span>下一頁</span>';
    }
    $('.page_show').empty().append(pageHtml);
}
//切換頁面
$('body').on('click', '.page_show span', function () {
    var $this = $(this);
    if ($this.hasClass('page_cur')) {
        return;
    }
    var page = $this.html();
    if (page == '上一頁') {
        listPage = listPage - 1;
        changePage(listPage);
    } else if (page == '下一頁') {
        listPage = listPage + 1;
        changePage(listPage);
    } else {
        listPage = parseInt(page);
        changePage(listPage);
    }
    //根據頁碼獲取當前頁列表數據
    setPage(pages)
});

var listPage = 1;

function changePage(page) {
    var offset = limit * (page - 1);

    $.ajax({
        type: "GET",
        url: url + "&offset=" + offset,
        success: function (data) {
            Info(data);
        },
        error: () => {
            document.location.href = "http://localhost:8080/travel/NO"
        }
    })
}
//得到後端值 進行append到頁面上
function Info(data) {
    $("#dataList").empty();
    //商品資訊
    var result = data.result;
    limit = data.limit;
    pages = Math.ceil(data.total / data.limit);

    var html2 = `<a style="font-size: 35px;">${data.result[0].town}</a>`;
    $("#titlefont").empty();
    $("#titlefont").append(html2);
    var html = ``;
    $.each(result, function (index, item) {
        

        html = `
<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s"
style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
<div class="package-item">
    <div class="overflow-hidden">
        <img type="button" src="${item.picture}" class="img-fluid" data-bs-toggle="modal" alt="" data-bs-target="#exampleModal">
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
<!--            <button onclick="myFunction()" class="btn btn-sm btn-primary px-3 border-end"-->
<!--                style="border-radius: 30px 0 0 30px;">購買-->
         
<!--            </button>-->
            
            <a data-id= ${item.id} data-name=${item.name} data-price=${item.ticket}   class="add-to-cart btn btn-primary" >購買</a>
        </div>
    </div>
</div>
</div>


</div>
</div>`
        $("#dataList").append(html);



    });


    // $('.add-to-cart').click(function(event) {
    //     event.preventDefault();
    //     var name = $(this).data('name');
    //     var price = Number($(this).data('price'));
    //     shoppingCart.addItemToCart(name, price, 1);
    //     displayCart();
    // });

    $('.add-to-cart').click(function(event) {
        event.preventDefault();
        var name = $(this).data('name');
        var price = Number($(this).data('price'));
        var id = $(this).data(`id`);
        shoppingCart.addItemToCart(name, price,1,id);
        displayCart();
    });
    displayCart();





}


//按下圖片後到搜尋畫面，並搜尋各縣市


function goToTainan() {
    setCookie("city", "台南", 365);
    document.location.href = "http://localhost:8080/travel/find";
    datalist();
}

function goToTaichung() {
    setCookie("city", "台中", 365);
    document.location.href = "http://localhost:8080/travel/find";
    datalist();
}
function goToTaoyuan() {
    setCookie("city", "桃園", 365);
    document.location.href = "http://localhost:8080/travel/find";
    datalist();
}
function goToYunlin() {
    setCookie("city", "雲林", 365);
    document.location.href = "http://localhost:8080/travel/find";
    datalist();
}

// $('.package-item').click(function () {
//     var item = $(this).data('item');
//     $('#exampleModalLabel').text(item.name);
//     $('.modal-body img').attr('src', item.picture);
//     $('.modal-body #travelvalue').text(item.town);
//
//     $('#exampleModal').modal('show');
// });


