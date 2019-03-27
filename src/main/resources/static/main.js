var info = "";
$(".currencyCalculate button[type='submit']").on('click', currency);
function currency(e) {
    e.preventDefault();
    console.log("prevent is working");

   var countryInformation = parseData();

    var url = $(".currencyCalculate").attr("action");
    console.log(url);
    $.ajax({
        type : 'post',
        url : url,
        data : countryInformation,
        dataType : 'text',
        contentType : 'application/json',
        error : function(xhr) {
            alert("error");
            console.log(xhr);

        },
        success : function(data) {
            console.log("success");
            console.log(data);
            alert(data);
         //   data.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
         //   console.log(data);
        }
    })

    function parseData() {
            var data = this.$(".currencyCalculate").serializeArray();
            var dataObject  = {};

            for (var i = 0; i < data.length; i++) {
                dataObject[data[i].name] = data[i].value;
            }

            return JSON.stringify(dataObject);
    };
}
