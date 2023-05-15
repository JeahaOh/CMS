(() => {
    'use strict'
    $("#join_form").on("submit", (event) => {
        event.preventDefault();
        const data = new FormData(document.getElementById('join_form'));
        console.log(`data : `, data);
        const param = JSON.stringify(Object.fromEntries(data));
        console.log(`param : `, param);

        $.ajax({
            url : '/auth/join',
            type : 'POST',
            data : param,
            contentType: 'application/json; charset=UTF-8'
        }).done((response, textStatus, xhr) => {
            console.log('response : ', response, 'textStatus : ', textStatus, 'xhr : ', xhr);
            alert(response);
            location.href = '/login';
        }).fail((xhr, textStatus, error) => {
            console.error('xhr : ', xhr, 'textStatus : ', textStatus, 'error : ', error);
            alert(xhr.responseText);
        });
    });
})();
