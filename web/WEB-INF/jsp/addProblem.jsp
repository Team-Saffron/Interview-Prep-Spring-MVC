<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Add Problem</h2>
  
  <p><b>Notice: </b>Problem added can be discarded by the admin, Posting irrelevant problems might block your Id</p>
  
  <form class="form-horizontal" role="form" style = "margin-top:3%;"  method = "post" action="/InterviewPrep/problems/add.htm">
    <div class="form-group">
        
      <label class="control-label col-sm-2" for="pid">Problem ID:</label>
      <div class="col-sm-10">
        <input name = "id" required type="text" class="form-control" id="pid" placeholder="Enter a unique Problem ID">
      </div>
      
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Problem Heading:</label>
      <div class="col-sm-10">          
        <input name = "name" required type="text" class="form-control" id="pwd" placeholder="Enter problem heading">
      </div>
    </div>
      
    <div class="form-group">
        <label for="comment">Problem Description:</label>
        <textarea name = "description" class="form-control" rows="5" id="comment">Problem Statement</textarea>
    </div>
    
    <div class="form-group">
        <label for="comment">Problem Input:</label>
        <textarea name = "input" class="form-control" rows="5" id="comment">Problem Inputs to be tested on</textarea>
    </div>
    
    <div class="form-group">
        <label for="comment">Problem Output:</label>
        <textarea name = "output" class="form-control" rows="5" id="comment">Corresponding Output</textarea>
    </div>
      
     <div class="form-group">
        <label for="comment">Samples:</label>
        <textarea name = "samples" class="form-control" rows="5" id="comment">Sample Testcases</textarea>
    </div>
      
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary"  style = "float:right">Submit</button>
      </div>
    </div>
  </form>
  
  <p>${ErrorMessage}</p>
</div>

</body>
</html>
