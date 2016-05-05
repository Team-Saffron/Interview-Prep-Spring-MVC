<!DOCTYPE html>
<html lang="en">
<head>
  <title>InterviewPrep</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
  <script src="//d1n0x3qji82z53.cloudfront.net/src-min-noconflict/ace.js"></script>
  <script src = "test.js"></script>
 
  <style>
textarea {
 background: url(http://i.stack.imgur.com/ynxjD.png) repeat-y;
 width: 70%;
 height: 300px;
 font: normal 14px verdana;
 line-height: 25px;
 padding: 2px 10px;
 border: solid 1px #ddd;
}
</style>
  <script>



 function getInput(){
      document.getElementById("inputForm").action = "/InterviewPrep/problems/view/problemId/"+${problem.id}+"/download";
      document.getElementById("inputForm").submit();
 }

 function submitSolution(){
     
        var x = document.getElementById("txtArea").value;
        
        console.log(x);
    //    document.getElementById("holder").value = document.getElementById("txtArea").value;
        document.getElementById("sendOutput").action = "/InterviewPrep/problems/view/problemId/"+${problem.id}+"/output";
        document.getElementById("sendOutput").submit();
        

 }
</script>
</head>

<body>
    <p id =" test"/>
  <!--Code for navigation bar-->
     <nav class="navbar navbar-default">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>                        
          </button>
          <a class="navbar-brand" href="#myPage">InterviewPrep</a>
        </div>
      </div>
    </nav>
  
  
  <div class ="container">
       
      <p style = "color:green;"><b> ${status} </b></p>
    
        <div class ="row">
            <center><h1>${problem.name}</h1></center>
        </div>
     
            <div class ="row" style = "margin: 2%;">
         
            
                <form id = "inputForm" method = "GET">
                <button  onclick = "getInput()" class="btn btn-primary" type="submit" style = "margin:2px;float: right;">Input</button>
                </form>
   
    
               <button  onclick = "submitSolution()" class="btn btn-primary" type="submit" style = "margin:2px;float:right;">Submit</button>
            </div>
            
             <div class ="row" style = "margin: 2%;">
                
                 <form id = "sendOutput" method = "POST">
                  <textarea name="output"  id ="txtArea" data-editor="cpp" data-gutter="1" rows="15" cols = "150"></textarea>
                 </form>
             </div>

        <div class ="row" style = "margin-top: 5%;">

           
            <div class ="col-md-12">
                <b><p>${problem.description}</p>
                </b></div>
            
        </div>
         
         
        <div class ="row" style = "margin-top: 5%;">
         
            
            <div class ="col-md-12">
                <b><p><b>Sample Input: </b>${problem.samples}</p>
                </b></div>
            
        </div>
        
                    
         
        <div class ="row" style = "margin-top: 2%;">
         
            
            <div class ="col-md-12">
                <b><p><b>Output: </b>${problem.output}</p>
                </b></div>
            
        </div>
                
     
 
  </div>
  
</body>
</html>
