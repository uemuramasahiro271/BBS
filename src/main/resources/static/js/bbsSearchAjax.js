
function loadBbs() {
    ajaxGet("/loadBbs", function(data) { createBbsList(data); });
}

function createBbsList(dataArray) {
    console.log("createBbsList");

    for (let index = 0; index < dataArray.length; index++) {
        const data = dataArray[index];
        console.log(data);
        addBbsItem(index + 1, data.id, data.title, data.postCount);
    }
}

function clearBbsList() {
    $("#bbs_list").empty();
}

function addBbsItem(no, id, title, postCount) {
    var $li = $("<li></li>");
    var $div = $("<div></div>");
    var $a = $("<a></a>", {
    	id: "bbs_item" + id,
        text: `${no}. ${title}`,
        href: "javascript:void(0);",
        onClick: `clickBbsItem(${id}, '${title}')`
    });
    var $postCount = $("<span></span>", {
        text: ` (${postCount}件)`
    });
    
    $div.append($a);
    $div.append($postCount);
    $li.append($div);
    $("#bbs_list").append($li);
}

function clickSearchBtn() {
    console.log(`clickSearchBtn`);
    var titleCondition = $("#input_text").val();
    var data = {titleCondition:titleCondition};
    let json = JSON.stringify(data);
    ajaxPost("/searchBbs", json, function(data) { 
        clearBbsList();
        createBbsList(data);

        $("#searchResultCount_area").removeClass("collapse");
        $("#searchResultCount_area p").text("検索結果：" + data.length + "件");
    });
}

function clickBbsItem(id, title) {
    console.log(`clickBbsItem`);
    console.log(`title = ${title}`);
    window.sessionStorage.setItem(['bbs_id'],[id]);
    window.sessionStorage.setItem(['bbs_title'],[title]);
    location.href = "/postPage";
}