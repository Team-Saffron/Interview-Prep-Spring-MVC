<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <h4>${session.username}</h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="/InterviewPrep/dashboard.htm">Home</a></li>
        <li><a href="#section3">Aptitude</a></li>
        <li><a href="/InterviewPrep/discuss.htm">Discuss</a></li>
        <li><a href="#section3">Ranking</a></li>
        <li><a href="/InterviewPrep/problems/view">Problems</a></li>
        <li><a href="/InterviewPrep/problems/add.htm">Add Problem</a></li>
      </ul><br>
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search Blog..">
        <span class="input-group-btn">
          <button class="btn btn-default" type="button">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </span>
      </div>
    </div>
      
    <div class="col-sm-9">
      
      
        
        <div class ="row">
            <center><h1>${comment.heading}</h1></center>
        </div>
     

        <div class ="row" style = "margin-top: 5%;">
         
           
            <div class ="col-md-12">
                <center><b><p>${comment.content}</p>
                </b></div></center>
            
        </div>
      
      
      
      <br>
      <br>
      

      <h4>Ask Query:</h4>
      
      <h4>${errorMessage}</h4>
      <form role="form" method = "post" action = "/InterviewPrep/discuss.htm">
          
        <div class="form-group">
            <label for="commentHeading">Heading:</label>
            <input type="text" required class="form-control" id="commenHeading" name = "heading">
        </div>
          
        <div class="form-group">
          <label for="content">Query:</label>
          <textarea class="form-control" rows="15" required id = "content" name = "content"></textarea>
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
      </form>
      <br><br>
     
    </div>

    
  </div>
</div>

</body>
</html>



