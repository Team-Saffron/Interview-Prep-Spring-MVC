<html>
    
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
  <style>
/* CSS Document */

body {
    width:100px;
	height:100px;
  background: -webkit-linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* Chrome 10+, Saf5.1+ */
  background:    -moz-linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* FF3.6+ */
  background:     -ms-linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* IE10 */
  background:      -o-linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* Opera 11.10+ */
  background:         linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* W3C */
font-family: 'Raleway', sans-serif;
}

p {
	color:#CCC;
}

.spacing {
	padding-top:7px;
	padding-bottom:7px;
}
.middlePage {
	width: 680px;
    height: 500px;
    position: absolute;
    top:0;
    bottom: 0;
    left: 0;
    right: 0;
    margin: auto;
}

.logo {
	color:#CCC;
}
  </style>
  <link href='http://fonts.googleapis.com/css?family=Raleway:500' rel='stylesheet' type='text/css'>
  
  <script>
      function login(){
  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      testAPI();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
     FB.login(function(response) {
    if (response.authResponse) {
     console.log('Welcome!  Fetching your information.... ');
     FB.api('/me?fields=id,name,email', function(response) {
       console.log('Good to see you, ' + response.name + '.');
     });
    } else {
     console.log('User cancelled login or did not fully authorize.');
    }
});
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
     window.alert("Please Log into Facebook");
    }
  }
  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }
  window.fbAsyncInit = function() {
  FB.init({
    appId      : '1002941833111016',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.5' // use graph api version 2.5
  });
  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.
  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });
  };
  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));
  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me?fields=name, picture, email,id', function(response) {
      console.log('Successful login for: ' + response.name + response.id); //fetched user info move to next page
    
       
        
         document.getElementById("username").value = response.id;
         document.getElementById("password").value = response.name;
         
         //console.log(document.getElementById("username"));
         document.getElementById("fbForm").action = "/InterviewPrep/login/fb";
         document.getElementById("fbForm").submit();
         
    
    });
  }
}
      </script>
</head>

<body>
   
<body>
<div class="middlePage">
<div class="page-header">
  <h1 class="logo">Interview Prep <small>Welcome to our place!</small></h1>
</div>

<div class="panel panel-info">
  <div class="panel-heading">
    <h3 class="panel-title">Please Sign In</h3>
  </div>
  <div class="panel-body">
  
  <div class="row">
  
<div class="col-md-5" >
   
        <button onclick = "login()"><img src="http://i.stack.imgur.com/pZzc4.png"  style = "width:100%;padding:0;"/></button><br/>
    
<br>
<form action = "/InterviewPrep/login/signup.htm" method = "get"> 
    <button type="submit" class="btn btn-danger btn-lg" style = "width:100%" >Register</button> 
</form>

</div>
     
      
     
    <div class="col-md-7" style="border-left:1px solid #ccc;height:160px">
<form class="form-horizontal" action = "/InterviewPrep/login.htm" method = "post" id = "fbForm" name = "fbForm">
<fieldset>
   
    
  <input  type="text" placeholder="Enter User Name" class="form-control input-md" id = "username" name = "username" value = ""/>
  <div class="spacing"></div>
  <input   type="password" placeholder="Enter Password" class="form-control input-md" id = "password" name = "password" value ="">
  <div class="spacing"><a href="#"><small> Forgot Password?</small></a><br/></div>
  <button id="singlebutton" name="singlebutton" class="btn btn-info btn-sm pull-right">Sign In</button>


</fieldset>
</form>
</div>
</div>
    
</div>
</div>

      <h5 style = "color:white;">${ERROR}</h5>
    
</div>
   
    
 
    
</body>
</html>