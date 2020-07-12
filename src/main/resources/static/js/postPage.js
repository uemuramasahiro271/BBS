var postCount = 1;
var editId;

class PostItemCreator {

    constructor(no, contributor, date, text) {
        this.no = no;
        this.contributor = contributor;
        this.date = date;
        this.text = text;
    }

    create() {
        var no = this.no;
        var id = `content_${no}`;
        var date = this.date;
        var contributor = this.contributor;
        var text = this.text;
        $("#contents_area").append(`<article id="${id}"></article>`);
        console.log("create");
        $(`#${id}`).load("parts/postItem.html", function() {
            console.log("postItem load");
            // 各IDを設定
            $('#v_item').attr('id', `item${no}`)
            $('#v_post_no').attr('id', `post_no${no}`);
            $('#v_date').attr('id', `data${no}`);
            $('#v_contributor').attr('id', `contributor${no}`);
            $('#v_text').attr('id', `text${no}`);
            $('#v_edit_btn').attr('id', `edit_btn${no}`);
            $('#v_delete_btn').attr('id', `delete_btn${no}`);

            // 投稿内容設定
            $(`#post_no${no}`).text(`No：${no}`);
            $(`#data${no}`).text(date);
            $(`#contributor${no}`).text(`${contributor}`);
            $(`#text${no}`).text(`${text}`);
        });
    }
}

function addPostItem(no, contributor, date, text) {
    console.log("addPostItem");
    var creator = new PostItemCreator(no, contributor, date, text);
    creator.create();
}

function post() {
    var contributor = $("#contributor_input").val();
    var date = new Date().toLocaleString("ja");
    var text = $("#contributor_textarea").val();

    addItem(contributor, date, text, function(data){
        console.log(data);
        addPostItem(data.no, data.contributor, data.date, data.text);
    });

    $("#contributor_input").val("");
    $("#contributor_textarea").val("");
}

function postEdit(id) {
    var contributor = $(`#${id}`).parents('.item').find(".contributor").text();
    var text = $(`#${id}`).parents('.item').find(".text").text();
    $("#edit_contributor_input").val(contributor);
    $("#edit_contributor_textarea").val(text);

    editId = $(`#${id}`).parents('.item_container').parent().attr("id");
}

function editComplete() {
    var no = $(`#${editId}`).find('.post_no').text().replace("No：", "");
    var contributor = $("#edit_contributor_input").val();
    var date = $(`#${editId}`).find(`#data${no}`).text();
    var text = $("#edit_contributor_textarea").val();

    editItem(no, contributor, date, text, function(data) {
        console.log(data);
        editPostItem(data.contributor, data.text);
        closeModal();
    });
}

function editCancel() {
    closeModal();
}

function editPostItem(contributor, text) {
    console.log("editPostItem : contributor = " + contributor);
    console.log("editPostItem : text = " + text);
    console.log("editPostItem : editId = " + editId);
    $(`#${editId}`).find(".contributor").text(contributor);
    $(`#${editId}`).find(".text").text(text);
}

function closeModal() {
    console.log("closeModal()");
    $(".modal_edit_button").modaal('close');
    editId = "";
}

function postDelete(id) {
    var $itemContainer = $(`#${id}`).parents('.item_container');
    var no = $itemContainer.find('.post_no').text().replace("No：", "");
    console.log("postDelete : no = " + no);

    deleteItem(no, function(data) {
        console.log(data);
        deletePostItem(data.no);
    });
}

function deletePostItem(no) {
    $(`#item${no}`).parent().remove();
}