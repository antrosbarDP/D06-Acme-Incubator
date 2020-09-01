<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="administrator.technology-record.form.label.title" path="title" />
	<acme:form-textbox code="administrator.technology-record.form.label.inventor" path="inventor" />
	<acme:form-textbox code="administrator.technology-record.form.label.activitySector" path="activitySector" />
	<acme:form-integer code="administrator.technology-record.form.label.stars" path="stars" />
	<acme:form-textbox code="administrator.technology-record.form.label.contactEmail" path="contactEmail" />
	<acme:form-url code="administrator.technology-record.form.label.website" path="website" />
	<acme:form-checkbox code="administrator.technology-record.form.label.openSource" path="openSource" />
	<acme:form-textarea code="administrator.technology-record.form.label.description" path="description" />
	
	<acme:form-submit test="${command == 'create' }" code="administrator.technology-record.form.button.create" 
	action = "/administrator/technology-record/create"/>
	<acme:form-submit test="${command == 'show' }" code="administrator.technology-record.form.button.update" 
	action = "/administrator/technology-record/update"/>
	<acme:form-submit test="${command == 'show' }" code="administrator.technology-record.form.button.delete" 
	action = "/administrator/technology-record/delete"/>
	<acme:form-submit test="${command == 'update' }" code="administrator.technology-record.form.button.update" 
	action = "/administrator/technology-record/update"/>
	<acme:form-submit test="${command == 'delete' }" code="administrator.technology-record.form.button.delete" 
	action = "/administrator/technology-record/delete"/>
	<acme:form-return code="administrator.technology-record.form.button.return"/>
</acme:form>