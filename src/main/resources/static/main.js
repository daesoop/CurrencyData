$(".currencyCalculate button[type='submit']").on('click', currency);

$('#send').change(sendRate=function(){
    var dataObject = new Object();
    dataObject.send = $("select[name=send]").val();
    dataObject.receive = $("select[name=receive]").val();
    $.ajax({
        type : 'post',
        url:'/crossRate',
        data: JSON.stringify(dataObject),
        dataType:'text',
        contentType : 'application/json',
        error : function(xhr) {
            console.log(xhr);
        },
        success:function(data){
            $(".crossRate").html(data);
        },
    });
});



$('#receive').change(receiveRate=function(){
    var receiveCountry = $("select[name=receive]").val();
    var dataObject = new Object();
        dataObject.send = $("select[name=send]").val();
        dataObject.receive = $("select[name=receive]").val();
        $.ajax({
            type : 'post',
            url:'/crossRate',
            data: JSON.stringify(dataObject),
            dataType:'text',
            contentType : 'application/json',
            error : function(xhr) {
                console.log(xhr);
            },
            success:function(data){
                $(".crossRate").html(data);
            },
        });
});

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
