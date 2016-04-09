<!DOCTYPE html>
<html lang="en">
<head>
  <title>dashboard</title>
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
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Status', 'Submissions'],
          ['Accepted',     11],
          ['Wrong Answer',      2],
          ['Time Limit Exceeded',  2],
          ['Compilation Error', 2],
        ]);

        var options = {
          title: 'Effectiveness',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
    </script>
</head>
<body>

<div class="container-fluid">
  
   <div class="row content">
    <div class="col-sm-2 sidenav">
      <h4>John's Blog</h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="dashboard.htm">Home</a></li>
        <li><a href="#section3">Aptitude</a></li>
        <li><a href="discuss.htm">Discuss</a></li>
        <li><a href="#section3">Ranking</a></li>
        <li><a href="problems/view.htm">Problems</a></li>
        <li><a href="problems/add.htm">Add Problem</a></li>
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
  
 
       <div class = "col-md-9" style = "margin-left:5%;">
             <div class="well well-sm"  style="margin-top:3%;">
                 <a href="dashboard.htm">Profile</a>
                 <a href="status.htm" style = "float:right;">Submissions</a>
                 <a href="account.htm" style = "float:right;margin-right:5px">   Account</a>
             </div>
           
            <div class = "row">
                <div class = "col-md-4" style ="margin-top:8%;">
                    <img src ="https://en.opensuse.org/images/0/0b/Icon-user.png" >
                    <br>
                    <b>Archit Jain</b><br>
                    <b>Delhi Colledge Of Engineering</b>
                </div>
                <div class = "col-md-8">
                        <div id="donutchart" style="width: 100%; height: 400px;"></div>
                </div>
            </div>
           
           <div class="row" style="margin-left:10%;margin-top:3%;">
               <h4>Problems Solved: 192</h4>
               <h4>Total Submission: 1024</h4>
           </div>
           
           <div class="row" style=";margin-top:3%;">
               <center><h4>Problems Solved</h4></center>
           </div>
           
           <div class="row" style=";margin-top:3%;">
               
           </div>
           
           
           <div class="row" style=";margin-top:3%;">
               <center><h4>ToDO List of Classical Problems</h4></center>
           </div>
       </div>
        
       </div>
    
 
    
</div>

</body>
</html>
