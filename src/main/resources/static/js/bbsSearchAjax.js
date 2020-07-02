window.onload = function() {
    load();
}

function load() {
    ajaxGet("/load", function(data) { loadSuccess(data); });
}

function loadSuccess(dataArray) {
    console.log("loadSuccess");

    for (let index = 0; index < dataArray.length; index++) {
        const data = dataArray[index];
        console.log(data);
        addBbsItem(data.id, data.title);
    }
}

function addBbsItem(id, title) {
    var $li = $("<li></li>", {

    });
    var $a = $("<a></a>", {
    	id: "bbs_item" + id,
        text: title,
        href: "javascript:void(0);",
        onClick: `clickBbsItem(${id})`
    });

    $li.append($a);
    $("#bbs_list").append($li);
}

function clickBbsItem(id) {
    //$.post("/postPage", `id=${id}`);
    location.href = "/postPage";
}