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
        <h4>${session.username}</h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="/InterviewPrep/dashboard.htm">Home</a></li>
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
  
 
       <div class = "col-md-9" style = "margin-left:5%;">
             
  <h2>Classical Problems</h2>
   
  
  <table class="table table-condensed" style = "margin-top:5%;">
       <tr class = "success">
        <th>Id</th>
        <th>Problem Name</th>
      </tr>
    <tbody>
      ${table}
    </tbody>
  </table>
<ul class="pager">
  <li><a href="#">Previous</a></li>
  <li><a href="#">Next</a></li>
</ul>
       </div>
        
       </div>
    
 
    
</div>

</body>
</html>


