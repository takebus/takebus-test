// add customer info
var user = 'dean@gmail.com',
    // log = false,
    log = true,
    Curstomer = {
        'email': '',
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

var Search = {
    "type": "", // or round
    "start": "",
    "end": "",
    "goDate": "",
    "returnDate": "",
};

function search(op) {
    var target = Object.create(Search);

    target.type = op;
    target.start = $('input[name=from]').val();
    target.end = $('input[name=to]').val();
    target.goDate = $('input[name=go_date]').val();
    target.returnDate = $('input[name=re_date]').val();

    console.log(target);
    window.location.href = "booking.html";

    /*
 $.ajax({
  type: "POST",
  url: "" ,
  data: target ,
  datatype: "jason",
  success: function(res){
    alert(res.callback);
    window.location.href= "2-2.html" ;
  },
  error: function(res){
    alert("Sorry, Search Failed!");
  }
 });
*/

};
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