$(document).ready(function(){
    Info()
});

function getCookie(name) {
    var value = "; " + document.cookie;
    var parts = value.split("; " + name + "=");
    if (parts.length == 2) return parts.pop().split(";").shift();
}
function Info(){

    var cookies;

    cookies = getCookie("total2");
    
    var html=""
 
      html=
      `
         <label for="price">Total</label>
         <input type="text" id="price" name="price" value="${cookies}">
         <label for="currency">Currency</label>
         <input type="text" id="currency" name="currency" value="TWD">
         <label for="method">Payment Method</label>
         <input type="text" id="method" name="method" value="paypal">
         <label for="intent">Intent</label>
         <input type="text" id="intent" name="intent" value="sale">
         <label for="description">Payment Description</label>
         <input type="text" id="description" name="description" value="testing"></input>
       `
       $("#paypalmenu").append(html);

}