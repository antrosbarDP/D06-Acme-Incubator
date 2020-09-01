<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="administrator.notice.form.label.title" path="title" />
	<acme:form-textbox code="administrator.notice.form.label.header" path="header" />
	<acme:form-moment code="administrator.notice.form.label.deadline" path="deadline" />
	<jstl:if test="${command != 'create' }">
	<acme:form-moment code="administrator.notice.form.label.creationDate" path="creationDate" readonly="true" />
	</jstl:if>
	<acme:form-textarea code="administrator.notice.form.label.body" path="body" />
	<acme:form-textarea code="administrator.notice.form.label.links" path="links" />
	
	<acme:form-checkbox code="administrator.notice.form.label.confirm" path="confirm" />
	
	<acme:form-submit test="${command == 'create' }" code="administrator.notice.form.button.create" 
	action = "/administrator/notice/create"/>
	<acme:form-return code="administrator.notice.form.button.return"/>
</acme:form>