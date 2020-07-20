<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="anonymous.rosado-bulletin.form.label.author" path="author" />
	<acme:form-textarea code="anonymous.rosado-bulletin.form.label.text" path="text" />
	
	
	
	<acme:form-submit code="anonymous.rosado-bulletin.form.button.create" action="/anonymous/rosado-bulletin/create/" />
	<acme:form-return code="anonymous.rosado-bulletin.form.button.return"/>
</acme:form>