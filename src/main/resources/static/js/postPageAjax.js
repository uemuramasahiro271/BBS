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

function addItem(contributor, date, text) {
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

function addItemSuccess(data) {
    console.log(data);
    addPostItem(data.no, data.contributor, data.date, data.text);
}

function deleteItem(no) {
    var id = window.sessionStorage.getItem(['bbs_id']);
    var data = {
        id:id,
        no:no
    };
    let json = JSON.stringify(data);
    console.log("deleteItem : " + json);
    ajaxPost("/deletePostItem", json, function(data) { addItemSuccess(data); });
}

function deleteItemSuccess(data) {
    console.log(data);
}

function editItem() {
    var id = window.sessionStorage.getItem(['bbs_id']);
    var data = {
        id:id,
        contributor:contributor,
        date:date,
        text:text
    };
    let json = JSON.stringify(data);
    console.log("editItem : " + json);
    ajaxPost("/editPostItem", json, function(data) { editItemSuccess(data); });
}

function editItemSuccess(data) {
    console.log(data);
}