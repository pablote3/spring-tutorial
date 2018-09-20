<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Test of REST</title>

  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.js">
  </script>
  
  <script>
$( document ).ready(function() {  
  // Handler that uses ajax() to invoke a REST resource
  $('#getAllButton').click( function() {
	  $.ajax({
		  url:'${pageContext.request.contextPath}/rest/items',
		  dataType: 'text',
		  success: function(responseData) {
		    $('#ajaxContent').html(responseData);
		  }, 
		    error: function( xhr, status, errorThrown ) {
		        alert( "Sorry, there was a problem!" );
		        console.log( errorThrown );
		        console.log( "Status: " + status );
		        console.dir( xhr );
		    }
	  });
	});
	
	// Handler that uses get() to invoke a REST resource
	$('#getOneButton').click( function() {
	  $.get('${pageContext.request.contextPath}/rest/items/1',
	        function(responseData) {
		      $('#ajaxContent').html(responseData);
	  	}, 
                'text' );
	});  
});	
  </script>  
</head>
<body>
  <p>
    <button id="getAllButton" type="button">GET All Button</button>
  </p>

  <p>
    <button id="getOneButton" type="button">GET One Button</button>
  </p>
  
  <div id="ajaxContent">
  </div>

</body>
</html>