var log = new Boolean(false),
   log = true ,
    user = "richard@gmail.com",
    
    amount = new Number(11.5),
    tax = new Number(amount* 0.087),
    total = amount+tax,
    PAY = {
        "amount": "",
        "firstName" : "" ,
        "lastName" : "" , 
        "type": "",
        "cardNumber" : "",
        "sid" : "" ,
        "expire" : "",
        "shippingAddress" : "",
        "billingAddress" : "",
        "billingCity" : "",
        "billingState" : "",
        "billingZip": "" , 
        "billingCountry" : "",       
      };  
var payInfo = Object.create(PAY);
 
 function init(page){
  loadIn(page);
 }
 //  Paying page                       
 function loadIn(page){
  if(log == true){
    $(".headMenu label").text("welcome, "+ user);
    $('.logout').toggle();
    $(".logReg").toggle();
  }
  switch(page){
    case 'updateProfile' :
        displayInfo(); 
        break;
    case 'paying' :
        showMoney();
        break;
    default :
        break;
  }
};
function login(){
  // merge here;
  log = true;
  user = "xxxx";
};

function logout(){
  log = false;
  user = "";
  loadIn();
};

function showMoney(){
  $('#amount').html("$"+ amount.toFixed(2));
  $('#tax').html("$"+ tax.toFixed(2) );
  $('#total').html("$"+ total.toFixed(2) );
};
function getPayInfo (){
   var fname = $('input[name=fname]').val(), 
       lname = $('input[name=lname]').val(), 
       type = $('select').val();
       cardNum = $('input[name=cardNum]').val(), 
       sid = $('input[name=sid]').val(), 
       expire = $('input[name=expire]').val(), 
       shipAddr =$('input[name=shipAddr]').val(),
       billAddr = $('input[name=billAddr]').val(), 
       city = $('input[name=city]').val(), 
       state = $('input[name=state]').val(), 
       zip = $('input[name=zip]').val();
       country = $('input[name=country]').val();
      
   if( isNum(cardNum)&&isNum(sid) && fname && lname && type && expire ){
        payInfo.firstName = fname;
        payInfo.lastName = lname;                     
        payInfo.type = type;
        payInfo.cardNumber = cardNum;
        payInfo.sid = sid;
        payInfo.expire = expire;
        payInfo.shippingAddress = shipAddr;
        payInfo.billingAddress = billAddr;
        payInfo.billingCity = city;
        payInfo.billingState = state;
        payInfo.billingZip = zip;
        payInfo.billingCountry = country;
      $('p.type-error').html("");
  console.log( payInfo );
        return true;
   }else{
      $('p.type-error').html("Your input is incomplete or the format is incorrect. Please try again.");
      return false;
   }
};
   
 function placeOrder ( method ) {
  payInfo.amount = total.toFixed(2); 

  if ( method == 'card') {
      if( getPayInfo() ==false ){
          return  ;
      } 
      // if get false , not apply ajax  --------modify
  }else{
      console.log( "you will go to paypal");
  }
   $.ajax({
      type: "POST",
      url: "http://localhost:8080/takebus-test/api/payment/pay",
/*      url: "http://54.201.20.120:8080/takebus-test/api/payment/pay" ,
*/      data: payInfo,
      contentType: "application/x-www-form-urlencoded; charset=utf-8",
      dataType: "json",
      success:function(res){
        alert("Thank you for your Booking tickets at TakeBus!");
        console.log(res+" \n"+payInfo);
  window.location.href= "final.html" ;
      }
   }); 
};

function isNum(s){
  if(s!=null){
     var r,re;
     re = /\d*/i; //\d means num, * means marching multiple nums
     r = s.match(re);
    return (r==s)?true:false;
  }
    return false;
};
