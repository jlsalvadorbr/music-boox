<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Music Boox - Pieces Demo</title>

<script language="JavaScript">
	function play() 
    {
    	document.MidiPlayerApplet.play();
    }
	function stop() 
    {
    	document.MidiPlayerApplet.stop();
    }
</script>
        
</head>
<body>

<h1>Music b<font color="red">OO</font>x</h1>

<h2>Demo:</h2>

<applet name="MidiPlayerApplet" code="applet.MidiPlayerApplet.class" codebase="/music-boox/applet" archive="music-boox.jar" height="300" width="300">
</applet>

<input type="button" value="play" onclick="javascript:play();"/>
<input type="button" value="stop" onclick="javascript:stop();"/>

	
<hr/>

Go to <a href="${pageContext.request.contextPath}/pieces">Available pieces</a>

</body>
</html>