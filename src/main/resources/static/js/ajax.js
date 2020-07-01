function error(XMLHttpRequest, textStatus, errorThrown) {
    console.log("error" + XMLHttpRequest);
    console.log("status" + textStatus);
    console.log("thrown" + errorThrown);
}

function ajaxGet(url, successFuction) {
    $.ajax({
        type     : "GET",
        url      : url,
        dataType : "json",
        success  : successFuction,
        error    : function(XMLHttpRequest, textStatus, errorThrown) { error(XMLHttpRequest, textStatus, errorThrown); }
    });
}

function ajaxPost(url, data, successFuction) {
    $.ajax({
        type     : "POST",
        url      : url,
        contentType: 'application/json',
        dataType : "json",
        data     : data,
        success  : successFuction,
        error    : function(XMLHttpRequest, textStatus, errorThrown) { error(XMLHttpRequest, textStatus, errorThrown); }
    });
}