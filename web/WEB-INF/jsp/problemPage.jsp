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
  <link rel="stylesheet" type="text/css" href="textcss">
  <script>
      $(function() {
  $('textarea[data-editor]').each(function() {
    var textarea = $(this);
    var mode = textarea.data('editor');
    var editDiv = $('<div>', {
      position: 'absolute',
      width: textarea.width(),
      height: textarea.height(),
      'class': textarea.attr('class')
    }).insertBefore(textarea);
    textarea.css('visibility', 'hidden');
    var editor = ace.edit(editDiv[0]);
    editor.renderer.setShowGutter(textarea.data('gutter'));
    editor.getSession().setValue(textarea.val());
    
    //editor.getSession().setMode("ace/mode/" + mode);
    //editor.setTheme("ace/theme/idle_fingers");
    editor.setTheme("ace/theme/monokai");
    editor.getSession().setMode("ace/mode/java");
    // copy back to textarea on form submit...
    textarea.closest('form').submit(function() {
      textarea.val(editor.getSession().getValue());
    })
  });
});
</script>
</head>

<body onload = "startTime()">
  
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
     <textarea name="my-xml-editor" data-editor="cpp" data-gutter="1" rows="20" cols = "150"></textarea>
  </div>
  
</body>
</html>
