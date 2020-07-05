// window.onload = function() {
//     var id = window.sessionStorage.getItem(['bbs_id']);
//     console.log("window.onload");
//     console.log(id);
//     loadPostPage(id);
// }

function loadPostPage() {
    console.log("loadPostPage");
    var id = window.sessionStorage.getItem(['bbs_id']);
    var data = {id:id};
    let json = JSON.stringify(data);
    ajaxPost("/loadPostPage", json, function(data) { loadSuccess(data); });
}

function loadSuccess(dataArray) {
    console.log("loadSuccess");
    console.log("dataArray.length = " + dataArray.length);

    for (let index = 0; index < dataArray.length; index++) {
        const data = dataArray[index];
        console.log(data);
        addPostItem(data.no, data.contributor, data.date, data.text);
    }
}