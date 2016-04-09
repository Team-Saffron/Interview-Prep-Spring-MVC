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
  
  <form class="form-horizontal" role="form" style = "margin-top:3%;">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Proble ID:</label>
      <div class="col-sm-10">
        <input required type="email" class="form-control" id="email" placeholder="Enter a unique Problem ID">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Problem Heading:</label>
      <div class="col-sm-10">          
        <input required type="text" class="form-control" id="pwd" placeholder="Enter password">
      </div>
    </div>
      
     <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Problem Description:</label>
      <div class="col-sm-10">          
        <input required type="file" class="form-control" id="pwd">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Problem Input:</label>
      <div class="col-sm-10">          
        <input required type="file" class="form-control" id="pwd">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Problem Ouput:</label>
      <div class="col-sm-10">          
        <input required type="file" class="form-control" id="pwd">
      </div>
    </div>
      
     <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Samples:</label>
      <div class="col-sm-10">          
        <input required type="file" class="form-control" id="pwd">
      </div>
    </div>
      
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
  
  <p>${ErrorMessage}</p>
</div>

</body>
</html>
