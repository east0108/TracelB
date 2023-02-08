$.ajax({
    method: "get",
    url: "/travel/findList",
    success: function (data) {
        // console.log(data);
        getInfo(data);
    }
});

function getInfo(data) {
    var html = "";
    var html2 = "";
    var html3 = "";
    var html4 = "";
    for (let i = 1; i < 4; i++) {
        const item = data[i];
        console.log(item);

        // $.each(data, function (index, item) {
        // console.log(item);
        html += `
            <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s"
                 style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
            <div class="package-item">
                <div class="overflow-hidden">
                    <img class="img-fluid" src="${item.picture}" alt="">
                </div>
                <div class="d-flex border-bottom">
                    <small class="flex-fill text-center border-end py-2"><i
                            class="fa fa-map-marker-alt text-primary me-2"></i>
                            <span> ${item.town}</span></small>

                    <small class="flex-fill text-center border-end py-2"><i
                            class="fa fa-map-marker-alt text-primary me-2"></i>
                            <span>${item.address}</span></small>
                    <small  class="flex-fill text-center py-2"><i
                            id="travelvalue"
                            class="fa fa-user text-primary me-2"></i>    
                            <span>${item.id}</span></small>
                </div>
                <div class="text-center p-4">
                    <h3 class="mb-0"><span>${item.ticket}</span></h3>
                    <div class="mb-3">
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                    </div>
                    <p1><span class="overflow-auto">${item.introduce}</span></p1>
                    <div class="d-flex justify-content-center mb-2">
                        <button onclick="myFunction()"  class="btn btn-sm btn-primary px-3 border-end"
                           style="border-radius: 30px 0 0 30px;">購買
                            </button>
                    </div>
                </div>
            </div>
            </div>`;
    }
    $("#info").append(html);
    for (let i = 11; i < 14; i++) {
        const item = data[i];
        console.log(item);

        // $.each(data, function (index, item) {
        // console.log(item);
        html2 += `
            <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s"
                 style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
            <div class="package-item">
                <div class="overflow-hidden">
                    <img class="img-fluid" src="${item.picture}" alt="">
                </div>
                <div class="d-flex border-bottom">
                    <small class="flex-fill text-center border-end py-2"><i
                            class="fa fa-map-marker-alt text-primary me-2"></i>
                            <span> ${item.town}</span></small>

                    <small class="flex-fill text-center border-end py-2"><i
                            class="fa fa-map-marker-alt text-primary me-2"></i>
                            <span>${item.address}</span></small>
                    <small  class="flex-fill text-center py-2"><i
                            id="travelvalue"
                            class="fa fa-user text-primary me-2"></i>    
                            <span>${item.id}</span></small>
                </div>
                <div class="text-center p-4">
                    <h3 class="mb-0"><span>${item.ticket}</span></h3>
                    <div class="mb-3">
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                    </div>
                    <p1><span class="overflow-auto">${item.introduce}</span></p1>
                    <div class="d-flex justify-content-center mb-2">
                        <button onclick="myFunction()"  class="btn btn-sm btn-primary px-3 border-end"
                           style="border-radius: 30px 0 0 30px;">購買
                            </button>
                    </div>
                </div>
            </div>
            </div>`;
    }
    $("#info2").append(html2);
    for (let i = 21; i < 24; i++) {
        const item = data[i];
        console.log(item);

        // $.each(data, function (index, item) {
        // console.log(item);
        html3 += `
            <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s"
                 style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
            <div class="package-item">
                <div class="overflow-hidden">
                    <img class="img-fluid" src="${item.picture}" alt="">
                </div>
                <div class="d-flex border-bottom">
                    <small class="flex-fill text-center border-end py-2"><i
                            class="fa fa-map-marker-alt text-primary me-2"></i>
                            <span> ${item.town}</span></small>

                    <small class="flex-fill text-center border-end py-2"><i
                            class="fa fa-map-marker-alt text-primary me-2"></i>
                            <span>${item.address}</span></small>
                    <small  class="flex-fill text-center py-2"><i
                            id="travelvalue"
                            class="fa fa-user text-primary me-2"></i>    
                            <span>${item.id}</span></small>
                </div>
                <div class="text-center p-4">
                    <h3 class="mb-0"><span>${item.ticket}</span></h3>
                    <div class="mb-3">
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                    </div>
                    <p1><span class="overflow-auto">${item.introduce}</span></p1>
                    <div class="d-flex justify-content-center mb-2">
                        <button onclick="myFunction()"  class="btn btn-sm btn-primary px-3 border-end"
                           style="border-radius: 30px 0 0 30px;">購買
                            </button>
                    </div>
                </div>
            </div>
            </div>`;
    }
    $("#info3").append(html3);
    for (let i = 21; i < 24; i++) {
        const item = data[i];
        console.log(item);

        // $.each(data, function (index, item) {
        // console.log(item);
        html4 += `
            <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s"
                 style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
            <div class="package-item">
                <div class="overflow-hidden">
                    <img class="img-fluid" src="${item.picture}" alt="">
                </div>
                <div class="d-flex border-bottom">
                    <small class="flex-fill text-center border-end py-2"><i
                            class="fa fa-map-marker-alt text-primary me-2"></i>
                            <span> ${item.town}</span></small>

                    <small class="flex-fill text-center border-end py-2"><i
                            class="fa fa-map-marker-alt text-primary me-2"></i>
                            <span>${item.address}</span></small>
                    <small  class="flex-fill text-center py-2"><i
                            id="travelvalue"
                            class="fa fa-user text-primary me-2"></i>    
                            <span>${item.id}</span></small>
                </div>
                <div class="text-center p-4">
                    <h3 class="mb-0"><span>${item.ticket}</span></h3>
                    <div class="mb-3">
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                        <small class="fa fa-star text-primary"></small>
                    </div>
                    <p1><span class="overflow-auto">${item.introduce}</span></p1>
                    <div class="d-flex justify-content-center mb-2">
                        <button onclick="myFunction()"  class="btn btn-sm btn-primary px-3 border-end"
                           style="border-radius: 30px 0 0 30px;">購買
                            </button>
                    </div>
                </div>
            </div>
            </div>`;
    }
    $("#info4").append(html4);
}