<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:list readonly="false">
	<acme:list-column code="administrator.notice.list.label.title" path="title" width="20%" />
	<acme:list-column code="administrator.notice.list.label.header" path="header" width="20%" />
	<acme:list-column code="administrator.notice.list.label.deadline" path="deadline" width="60%" />
</acme:list>


<a href="<jstl:url value="/administrator/notice/create"/>"><h1 style="color:DodgerBlue;"><acme:message code="administrator.notice.form.button.create"/></h1></a>