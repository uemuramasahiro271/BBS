function loadBbs() {
    ajaxGet("/loadBbs", function(data) { createBbsList(data); });
}

function createBbsList(dataArray) {
    console.log("createBbsList");

    var elements = "";
    for (let index = 0; index < dataArray.length; index++) {
        const data = dataArray[index];
        console.log(data);
        var item = createBbsItem(index + 1, data.id, data.title, data.postCount);
        elements = elements + item.prop("outerHTML");
    }
    $("#bbs_list").append(elements);
}

function clearBbsList() {
    $("#bbs_list").empty();
}

function createBbsItem(no, id, title, postCount) {
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

    return $li;
}

function addBbsItem(no, id, title, postCount) {
    var item = createBbsItem(no, id, title, postCount);
    $("#bbs_list").append(item);
}

function createBbs() {
    var title = $("#bbs_title_textarea").val();
    console.log(`createBbs() : title`);
    var data = {title:title};
    let json = JSON.stringify(data);
    ajaxPost("/createBbs", json, function(data) { 
        console.log(`data`);
        var count = $("#bbs_list li").length + 1;
        addBbsItem(count, data.id, data.title, data.postCount);
        $("#bbs_title_textarea").val("");
        closeModal('.bbs_create_btn')
    });
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

function setBbsDeleteTitleList() {
    ajaxGet("/getBbsList", function(dataArray) { 
        console.log(dataArray);

        var addElements = "";

        for (let index = 0; index < dataArray.length; index++) {
            const data = dataArray[index];

            var $li = $("<li></li>");
            var $label = $("<label></label>", {
                for: data.title,
                text: data.title
            });
            var $checkbox = $("<input>", {
                type: 'checkbox',
                id: data.title,
                value: data.id,
                name: "chk[]"
            });

            $li.append($checkbox);
            $li.append($label);
    
            addElements = addElements + $li.prop("outerHTML");
        }

        console.log(addElements);

        $("#bbs_delete_list").append(addElements);
     });
}

function addEvent() {
    // 1. 「全選択」する
    $('#check_all').on('click', function() {
        $("input[name='chk[]']").prop('checked', this.checked);
    });
    // 2. 「全選択」以外のチェックボックスがクリックされたら、
    $("input[name='chk[]']").on('click', function() {
        if ($('#bbs_delete_list :checked').length == $('#bbs_delete_list :input').length) {
            // 全てのチェックボックスにチェックが入っていたら、「全選択」 = checked
            $('#check_all').prop('checked', true);
        } else {
            // 1つでもチェックが入っていたら、「全選択」 = checked
            $('#check_all').prop('checked', false);
        }
    });
}

function deleteBbs() {
    var ids = new Array();
    $("input[name='chk[]']").each(function() {
        console.log(`id = ${$(this).attr('id')}, value = ${$(this).attr('value')}`);
        if($(this).prop('checked') === true) {
            var id = {id: $(this).attr('value')}
            ids.push(id);
        }
    });
    let json = JSON.stringify(ids);
    console.log(`json = ${json}`);
    ajaxPost("/deleteBbs", json, function(dataArray) { 


        closeModal('.bbs_delete_btn');
    });
}