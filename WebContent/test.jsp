<!DOCTYPE html>
<html lang="en">
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
        <title>SO question 4112686</title>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
            <script>
            $(document).on("click", "#somebutton", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
                $.get("hello", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                    $("#somediv").html(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                });
            });
        </script>
    </head>
    <body>
        <button id="somebutton">press here</button>
        <div id="somediv">${hello}</div>
    </body>

</html>