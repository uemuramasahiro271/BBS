function loadPostPage() {
    console.log("loadPostPage");
    var title = window.sessionStorage.getItem(['bbs_title']);
    setTitle(title);
    
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

function setTitle(title) {
    $("#bbs_title").text(title);
}

function addItem(contributor, date, text, addItemSuccess) {
    var id = window.sessionStorage.getItem(['bbs_id']);
    var data = {
        id:id,
        contributor:contributor,
        date:date,
        text:text
    };
    let json = JSON.stringify(data);
    console.log("addItem : " + json);
    ajaxPost("/addPostItem", json, function(data) { addItemSuccess(data); });
}

function deleteItem(no, deleteItemSuccess) {
    var id = window.sessionStorage.getItem(['bbs_id']);
    var data = {
        id:id,
        no:no
    };
    let json = JSON.stringify(data);
    console.log("deleteItem : " + json);
    ajaxPost("/deletePostItem", json, function(data) { deleteItemSuccess(data); });
}

function editItem(no, contributor, date, text, editItemSuccess) {
    var id = window.sessionStorage.getItem(['bbs_id']);
    var data = {
        id:id,
        no:no,
        contributor:contributor,
        date:date,
        text:text
    };
    let json = JSON.stringify(data);
    console.log("editItem : " + json);
    ajaxPost("/editPostItem", json, function(data) { editItemSuccess(data); });
}