// $('#dt').DataTable({});
var data;
$.ajax({
    /*本代碼已拔除授權代碼將無效化，請使用自身帳號授權碼*/
    url: "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-6D6E3EBB-4341-41D6-8B23-CD090A3355DB&format=JSON&locationName=&elementName=",
    method: "GET",
    dataType: "json",
    success: function (re) {
        console.log(re); //先測試拿到了什麼
        // data=re;  //透過 chrome.f12.console 輸入 data 確認內容
        // data = re.cwbopendata.dataset.location; //簡化擷取的節點
    }
}).done(function (re) {
    data = re.records.location;
    console.log(data)
    var hourtext = new Array();
    hourtext[0] = "凌晨";
    hourtext[6] = "白天";
    hourtext[12] = "下午";
    hourtext[18] = "晚上";

    date1 = new Date(data[0].weatherElement[0].time[0].startTime); //轉 date format
    date2 = new Date(data[0].weatherElement[0].time[1].startTime); //轉 date format
    date3 = new Date(data[0].weatherElement[0].time[2].startTime); //轉 date format
    var print =`    <div class="container">
                        <div class="text-center">
                            <h6 class="section-title bg-white text-center text-primary px-3">Weather</h6>
                            <h1 class="mb-5">36H 全台天氣預報!!!</h1>
                        </div>
                        <div class="row owl-carousel testimonial-carousel position-relative">
                        `;
    for (let i = 0; i < data.length; i++) {
        row = data[i];
        print += `
        <div class="row testimonial-item bg-white text-center border p-4">
            <h5 class="mb-0">${row.locationName}</h5>
            <img class="bg-white rounded-circle shadow p-1 mx-auto mb-3" src="img-Weather/icon-${row.weatherElement[0].time[0].parameter.parameterValue}.svg"
                style="width: 80px; height: 80px;">
            <p>${date1.getFullYear()}-${date1.getMonth() + 1}-${date1.getDate()} ${hourtext[date1.getHours()]}</p>
            <p class="mb-0">${row.weatherElement[0].time[0].parameter.parameterName} | 
            溫度 ${row.weatherElement[2].time[0].parameter.parameterName} ~ ${row.weatherElement[4].time[0].parameter.parameterName} ℃</p>
            <div class="col-lg-6">
                <img class="bg-white rounded-circle shadow p-1 mx-auto mb-3" src="img-Weather/icon-${row.weatherElement[0].time[1].parameter.parameterValue}.svg"
                    style="width: 80px; height: 80px;">
                <p>${date2.getFullYear()}-${date2.getMonth() + 1}-${date2.getDate()} ${hourtext[date2.getHours()]}</p>
                <p class="mb-0">${row.weatherElement[0].time[1].parameter.parameterName} | 
                溫度 ${row.weatherElement[2].time[1].parameter.parameterName} ~ ${row.weatherElement[4].time[1].parameter.parameterName} ℃</p>
            </div>
            <div class="col-lg-6">
                <img class="bg-white rounded-circle shadow p-1 mx-auto mb-3" src="img-Weather/icon-${row.weatherElement[0].time[2].parameter.parameterValue}.svg"
                    style="width: 80px; height: 80px;">
                <p>${date3.getFullYear()}-${date3.getMonth() + 1}-${date3.getDate()} ${hourtext[date3.getHours()]}</p>
                <p class="mb-0">${row.weatherElement[0].time[2].parameter.parameterName} | 
                溫度 ${row.weatherElement[2].time[2].parameter.parameterName} ~ ${row.weatherElement[4].time[2].parameter.parameterName} ℃</p>
            </div>
        </div>`;
    }
    print+=`
            </div>
        </div>`;
    $('#dt').html(print);
});