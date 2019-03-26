var info = "";
$(".currencyCalculate button[type='submit']").on('click', currency);
function currency(e) {
    e.preventDefault();
    console.log("prevent is working");

   var obj = test();

    var url = $(".currencyCalculate").attr("action");
    console.log(url);
    console.log(obj)
    $.ajax({
        type : 'post',
        url : url,
        data : obj,
        dataType : 'json',
        contentType : 'application/json',
        error : function(xhr, data) {
            alert("error");
            console.log(data.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")

            console.log(xhr);
        },
        success : function(data) {
            console.log("success");
            console.log(data);
            alert(data);
            data.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")
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
