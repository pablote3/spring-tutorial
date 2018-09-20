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
    function renderArtists(data) {
    	// Display the data in raw form
    	alert (JSON.stringify(data));
      // Make sure we have an array
  	  var list = data == null ? [] : data;
  	  console.log(list);
  	  // Remove all the list elements from the artist list    
      $('#allArtists li').remove();
      // Iterate over the returned items, and add the artist for each one to the artists list
      $.each(list, function(index, item) {
        $('#allArtists').append('<li>' + item.artist + '</li>');
      });
    }
  </script>  
  
  <script>
$( document ).ready(function() {  
  // Handler that uses ajax() to invoke a REST resource
  $('#getAllButton').click( function() {
	  $.ajax({
		  url:'${pageContext.request.contextPath}/rest/items',
		  dataType: 'json',
		  success: renderArtists, 
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
	        function(item) {
	    	// Display the item in raw form
    	    alert (JSON.stringify(item));
		     content = '<p>' + item.title + ' | ' + item.artist + '</p>';
		      $('#ajaxContent').html(content);
	  	}, 
                'json' );
	});  
});	
  </script>  
</head>
<body>

  <p>
    <button id="getOneButton" type="button">GET One Button</button>
  </p>
  
  <div id="ajaxContent">
  </div>  

  <p>
    <button id="getAllButton" type="button">GET All Button</button>
  </p>

   <ul id="allArtists"></ul>
    




</body>
</html>