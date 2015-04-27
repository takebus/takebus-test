var user = 'dean@gmail.com',
    // log = false,
    log = true,
    Curstomer = {
      'email':'',
        'firstName': '',
        "lastName": "",
        "address": "",
        "city": "",
        "state": "",
        "country": "",
        "zip": "",
        "phoneNumber": ""
    },
    personalInfo = Object.create(Curstomer);
    personalInfo.email = user;

function init() {
    if (log == true) {
        $('.headMenu label').text("Welcome, " + user);
        $('.logout').toggle();
        $('.logReg').toggle();
    }
};

$(window).ready(function() {
    init();
});