// // Preload Images
// img1 = new Image(16, 16);
// img1.src = "images/spinner.gif";

// img2 = new Image(220, 19);
// img2.src = "images/ajax-loader.gif";

// When DOM is ready
$(document).ready(function() {

    // when the form is submitted
    $('#status > form').submit(function() {

        $('#notification_error').hide();

        var email_pattern = /^[A-Z0-9._%+-]+@([A-Z0-9-]+\.)+[A-Z]{2,4}$/i;
        var email = $('input[name=email]').val();
        var password = $('input[name=password]').val();
        var invalid = [];

        // check if email is valid
        if (!email_pattern.test(email)) {
            invalid.push(true);
            $('p#email_error').slideDown();
            // clear login form
            resetForm($('#login'));
        } else {
            $('p#email_error').hide();
        }//end check valid email

        // check if password is valid
        // if (password === '' || password.length < 6 || password.length > 12) {
        //   invalid.push(true);
        //   $('p#passwor_error').slideDown();
        //   // clear login form
        //   resetForm($('#login'));
        // } else {
        //   $('p#passwor_error').hide();
        // }

// if all field are valid, then post info to sever
        if (invalid.length == 0) {
          $('#login_button').hide();

            // show Gif Spinning Rotator
            // $('#ajax.loading').show();

            //'this' refors to the current submitted form
            var str = $(this).serialize();
            // console.log(str);
            //-- Start AJAX Call
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/takebus-test/api/user/login",
                // data: {
                // "email": "dean@gmail.com",
                // "password": "123456"
                // },
                data: str,
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                dataType: "json", //return data type
                success: function(res) {
                    // console.log(res);
                    // alert("data:" + res);
                    // Show 'Login' Button
                    $('#login_button').show();

                    // Hide Gif Spinning Rotator
                    // $('#ajax_loading').hide();

                    // console.log(Object.keys(res).length === 0);
                    // console.log(res);
                    // debugger;
                    // LOGIN success?
                    // To check if login is successful.If so, server would return a non-empty object
                    // otherwise, it returns a empty objcet
                    // For ECMAScript5 (not supported in all browsers yet though)
                    // you can use Object.keys(res).length === 0 to check if it's empty

                    // if login fails
                    if (Object.keys(res).length === 0) {
                        // window.location = 'Login.html';
                        // show error info
                        // var login_response = '<div id="notification_error">The login info is not correct.</div>';
                        // $('#login_response').html(login_response);
                        $('div#notification_error').show();
                        // clear login form
                        resetForm($('#login'));
                    } else {
                        // // if (res == 'success') {
                        // var login_response = '<div id="logged_in">' +
                        //     '<div style="width: 350px; float: left; margin-left: 70px;">' +
                        //     '<div style="width: 40px; float: left;">' +
                        //     '<img style="margin: 10px 0px 10px 0px;" align="absmiddle" src="images/ajax-loader.gif">' +
                        //     '</div>' +
                        //     '<div style="margin: 10px 0px 0px 10px; float: right; width: 300px;">' +
                        //     "You are successfully logged in! <br /> Please wait while you're redirected...</div></div>";

                        // $('a.modalCloseImg').hide();

                        // $('#simplemodal-container').css("width", "500px");
                        // $('#simplemodal-container').css("height", "120px");

                        // // Refers to Pending page
                        // // $(this).html(login_response);
                        // $('#login_form').modal();
                        // $('#simplemodal-container').html(login_response);
                        // self.html(login_response);

                        // After 3 seconds redirect to home page
                        // setTimeout('go_to_private_page()', 3000);
                        go_to_private_page();
                    }
                }
            }); // end AJAX Call
        }
        // cancel the default action of the link by returning false
        return false;
    }); // end submit event

    $('#register_button').click(function() {
        window.location = 'Register.html';
    });

});

function go_to_private_page() {
    window.location = 'index.html'; // Members Area
};

function resetForm($form) {
    $form.find('input:text, input:password, input:file, select, textarea').val('');
    $form.find('input:radio, input:checkbox')
        .removeAttr('checked').removeAttr('selected');
};