var info = "";
$("#currencyTest").on('click', currency);
function currency(e) {
    e.preventDefault();
    console.log("prevent is working");

    var endpoint = 'live'
    var access_key = 'c1bc6519e38a10b07baed0373c279c94'

    var url = 'http://apilayer.net/api/' + endpoint + '?access_key=' + access_key

    $.ajax({
        url : url,
        dataType : 'jsonp',
        success : function(json) {
               info = json;
               console.log(info);
               alert(json.quotes.USDGBP);

                    // source currency is stored in json.source
               alert(json.source);

                    // timestamp can be accessed in json.timestamp
               alert(json.timestamp);
        }
    })
}
