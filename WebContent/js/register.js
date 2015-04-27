$(document).ready(function() {
    $("form#register").submit(function() {
        // check if all fields are correct
        var firstname = $("#firstname").val();
        var lastname = $("#lastname").val();
        var email = $("#email").val();
        var password = $("#password").val();
        var cpassword = $("#cpassword").val();
        // var pattern = new RegExp(/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i);
        var email_pattern = /^[A-Z0-9._%+-]+@([A-Z0-9-]+\.)+[A-Z]{2,4}$/i;
        var invalid = [];

        if (firstname == '' || lastname == '' || email == '' || password == '' || cpassword == '') {
            invalid.push(true);
            $('p#unfinished').show();
        } else {
            $('p#unfinished').hide();
        }
        if (!email_pattern.test(email)) {
            invalid.push(true);
            $('p#email_error').slideDown();
        } else {
            $('p#email_error').hide();
        }
        if (password.length < 6) {
            invalid.push(true);
            $('p#password_error').slideDown();
        } else {
            $('p#password_error').hide();
        }
        if (password === cpassword) {
            $('p#match_error').hide();
        } else {
            invalid.push(true);
            $('p#match_error').slideDown();
        }

        //'this' refors to the current submitted form
        var str = $(this).serialize();

        // if all field are correct, then post all field to server
        if (invalid.length === 0) {
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/takebus-test/api/user/register",
                data: str,
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                dataType: "text", //return data type
                success: function(res) {
                    alert("data:" + res);
                }
            }); // end ajax call
        } else {
            // clear register form
            resetForm($('#register'));
        }


        return false;
    });
});

function resetForm($form) {
    $form.find('input:text, input:password, input:file, select, textarea').val('');
    $form.find('input:radio, input:checkbox')
        .removeAttr('checked').removeAttr('selected');
};