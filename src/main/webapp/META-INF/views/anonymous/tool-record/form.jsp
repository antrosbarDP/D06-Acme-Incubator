<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="anonymous.tool-record.form.label.title" path="title" />
	<acme:form-textbox code="anonymous.tool-record.form.label.inventor" path="inventor" />
	<acme:form-textbox code="anonymous.tool-record.form.label.activitySector" path="activitySector" />
	<acme:form-integer code="anonymous.tool-record.form.label.stars" path="stars" />
	<acme:form-textbox code="anonymous.tool-record.form.label.contactEmail" path="contactEmail" />
	<acme:form-url code="anonymous.tool-record.form.label.website" path="website" />
	<acme:form-checkbox code="anonymous.tool-record.form.label.openSource" path="openSource" />
	<acme:form-textarea code="anonymous.tool-record.form.label.description" path="description" />
	
	
	<acme:form-return code="anonymous.tool-record.form.button.return"/>
</acme:form>