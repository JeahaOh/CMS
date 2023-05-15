(() => {
    'use strict'
    $(document).on('click', '#login_btn', $.proxy(() => {
        console.group('#login_btn on click');
        sessionStorage.setItem('memberId', document.getElementById('memberId').value);
        console.groupEnd('#login_btn on click');
    }, this));
})();