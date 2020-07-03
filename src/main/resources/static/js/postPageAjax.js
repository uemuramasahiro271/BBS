window.onload = function() {
    var id = window.sessionStorage.getItem(['bbs_id']);
    alert(id);
}

function load() {
    ajaxGet("/loadPostItem", function(data) { loadSuccess(data); });
}

function loadSuccess(dataArray) {
    console.log("loadSuccess");

    for (let index = 0; index < dataArray.length; index++) {
        const data = dataArray[index];
        console.log(data);
        addBbsItem(data.id, data.title);
    }
}