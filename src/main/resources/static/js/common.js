function initView(onLoaded) {
    // $('#header').load('parts/header.html');
    $('#main_frame').load('parts/mainFrame.html', function() {
        onLoaded();
    });
    
    // $('#footer').load('parts/footer.html');
}

function closeModal(className) {
    $(className).modaal('close');
}