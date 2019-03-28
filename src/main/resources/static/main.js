var info = "";
$(".currencyCalculate button[type='submit']").on('click', currency);

$("#send").on("change",sendRate);
$("#receive").on("change",receiveRate);
$("select[name=send]").val();
$(function(){

    $("#send").change(function receiveRate(e) {
        e.preventDefault();
        alert("변경");
        console.log("receive is working");
    }
    })
})

function sendRate(e) {
    e.preventDefault();
    alert("변경");
    console.log("send is working");
}

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
        dataType : 'json',
        contentType : 'application/json',
        error : function(xhr) {
            alert("error");
            console.log(xhr);

        },
        success : function(data) {
            console.log("success");
            console.log(data);
            if(data.valid == false) {
                alert(data.errorMessage);
            }
            $(".value").html(data.value);
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
