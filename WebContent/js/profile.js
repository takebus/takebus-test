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

function displayInfo() {
    console.log('displayInfo');
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/takebus-test/api/user/' + user,
        dataType: "json",
        success: function(res) {
            $('#user').text(res[0].email);
            $('input[name=fname]').val(res[0].firstName);
            $('input[name=lname]').val(res[0].lastName);
            $('input[name=addr]').val(res[0].address);
            $('input[name=city]').val(res[0].city);
            $('input[name=state]').val(res[0].state);
            $('input[name=country]').val(res[0].country);
            $('input[name=zip]').val(res[0].zip);
            $('input[name=phone]').val(res[0].phoneNumber);

        }
    });
};

function getPersonalInfo() {
    var fname = $('input[name=fname]').val(),
        lname = $('input[name=lname]').val(),
        sex = $('input[name=sex]:checked').val(),
        bod = $('input[name=bod]').val(),
        addr = $('input[name=addr]').val(),
        city = $('input[name=city]').val(),
        state = $('input[name=state]').val(),
        country = $('input[name=country]').val(),
        zip = $('input[name=zip]').val(),
        phone = $('input[name=phone]').val();

    personalInfo.firstName = fname;
    personalInfo.lastName = lname;
    personalInfo.address = addr;
    personalInfo.city = city;
    personalInfo.country = country;
    personalInfo.state = state;
    personalInfo.zip = zip;
    personalInfo.phoneNumber = phone;
};

function updateProfile() {
  // console.log("post to host");
  // debugger;
        getPersonalInfo();
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/takebus-test/api/user/update",
            data: personalInfo,
            dataType: "json",
            success: function(res) {
                alert(res.callback);
            }
        });
};

// function init(page) {
//     loadIn(page);
// };
function init() {
    loadIn();
};
//  Paying page
// function loadIn(page) {
function loadIn() {
    if (log == true) {
        $('.headMenu label').text("Welcome, " + user);
        $('.logout').toggle();
        $('.logReg').toggle();
    }
    displayInfo();
    // switch (page) {
    //     case 'Viewprofile':
    //         displayInfo();
    //         break;
    //     case 'paying':
    //         showMoney();
    //         break;
    //     default:
    //         break;
    // }
};

function logout() {
    log = false;
    user = "";
    loadIn();
};


$(document).ready(function() {

    // var self = this;

    init();

    // displayInfo();

    // when update button is clicked, update user's profile
    // $('#update').click(updateProfile());
    $('#update').click(function() {
        updateProfile();
    });
});