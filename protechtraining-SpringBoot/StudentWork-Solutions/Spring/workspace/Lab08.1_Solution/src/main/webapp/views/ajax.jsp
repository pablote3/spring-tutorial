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
  function serializeXmlNode(xmlNode) {
	    if (typeof window.XMLSerializer != "undefined") {
	        return (new window.XMLSerializer()).serializeToString(xmlNode);
	    } else if (typeof xmlNode.xml != "undefined") {
	        return xmlNode.xml;
	    }
	    return "";
	}
  </script>
  
  <script>
    function renderArtists(data) {
    	alert (serializeXmlNode(data));
    	  // Remove all the list elements from the artist list    
        $('#allArtists li').remove();
        // Iterate over the items in the XML doc, and add the artist for each one to the artists list
    	$(data).find('item').each(function() {
    		var $item = $(this);
            $('#allArtists').append('<li>' + $item.find('artist').text() + '</li>');
        });
    }
  </script>  
  
  <script>
$( document ).ready(function() {  
  // Handler that uses ajax() to invoke a REST resource
  $('#getAllButton').click( function() {
	  $.ajax({
		  url:'${pageContext.request.contextPath}/rest/items',
		  dataType: 'xml',
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
	        function(itemXML) {
		      alert (serializeXmlNode(itemXML));
 	          var item = $(itemXML).find('item');
		      var title = item.find('title').text();
		      var artist = item.find('artist').text();
		      content = '<p>' + title + ' | ' + artist + '</p>';
		      $('#ajaxContent').html(content);
	  	}, 
                'xml' );
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