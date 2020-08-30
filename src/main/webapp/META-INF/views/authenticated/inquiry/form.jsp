<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="authenticated.inquiry.form.label.title" path="title" />
	<acme:form-textbox code="authenticated.inquiry.form.label.contactEmail" path="contactEmail" />
	<acme:form-moment code="authenticated.inquiry.form.label.deadline" path="deadline" />
	<acme:form-moment code="authenticated.inquiry.form.label.creationDate" path="creationDate" />
	<acme:form-money code="authenticated.inquiry.form.label.minMoney" path="minMoney" />
	<acme:form-money code="authenticated.inquiry.form.label.maxMoney" path="maxMoney" />
	<acme:form-textarea code="authenticated.inquiry.form.label.description" path="description" />
	
	
	
	<acme:form-return code="authenticated.inquiry.form.button.return"/>
</acme:form>