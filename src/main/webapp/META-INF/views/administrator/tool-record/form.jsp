<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="administrator.tool-record.form.label.title" path="title" />
	<acme:form-textbox code="administrator.tool-record.form.label.inventor" path="inventor" />
	<acme:form-textbox code="administrator.tool-record.form.label.activitySector" path="activitySector" />
	<acme:form-integer code="administrator.tool-record.form.label.stars" path="stars" />
	<acme:form-url code="administrator.tool-record.form.label.contactEmail" path="contactEmail" />
	<acme:form-textbox code="administrator.tool-record.form.label.website" path="website" />
	<acme:form-checkbox code="administrator.tool-record.form.label.openSource" path="openSource" />
	<acme:form-textarea code="administrator.tool-record.form.label.description" path="description" />
	
	<acme:form-submit test="${command == 'create' }" code="administrator.tool-record.form.button.create" 
	action = "/administrator/tool-record/create"/>
	<acme:form-submit test="${command == 'show' }" code="administrator.tool-record.form.button.update" 
	action = "/administrator/tool-record/update"/>
	<acme:form-submit test="${command == 'show' }" code="administrator.tool-record.form.button.delete" 
	action = "/administrator/tool-record/delete"/>
	<acme:form-submit test="${command == 'update' }" code="administrator.tool-record.form.button.update" 
	action = "/administrator/tool-record/update"/>
	<acme:form-submit test="${command == 'delete' }" code="administrator.tool-record.form.button.delete" 
	action = "/administrator/tool-record/delete"/>
	<acme:form-return code="administrator.tool-record.form.button.return"/>
</acme:form>