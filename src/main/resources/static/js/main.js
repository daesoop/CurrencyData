var info = "";
$(".currencyCalculate button[type='submit']").on('click', currency);
function currency(e) {
    e.preventDefault();
    console.log("prevent is working");
//    var information = new Object;
//    information.send = "send";
//    information.receive = "receive";
//    information.sendMoney = 11;

    var queryString = $(".currencyCalculate").serialize();

    var url = $(".currencyCalculate").attr("action");
    console.log(url);

    $.ajax({
        url : url,
        data : queryString,
        dataType : 'json',
        error : function(xhr) {
            alert("error");
            console.log(xhr);
        },
        success : function(data) {
            console.log("success");
            console.log(data);
            alert(data);
        }
    })
}
