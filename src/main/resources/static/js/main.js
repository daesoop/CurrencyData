var info = "";
$(".currencyCalculate button[type='submit']").on('click', currency);
function currency(e) {
    e.preventDefault();
    console.log("prevent is working");

   var obj = test();

    var url = $(".currencyCalculate").attr("action");
    console.log(url);

    $.ajax({
        type : 'post',
        url : url,
        data : obj,
        dataType : 'json',
        contentType : 'application/json',
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

    function test () {
            var data = this. $(".currencyCalculate").serializeArray();
            var object  = {};

            for (var i = 0; i < data.length; i++) {
                object[data[i].name] = data[i].value;
            }

            return JSON.stringify(object);
        };
}
