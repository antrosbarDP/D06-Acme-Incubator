<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:list readonly="false">
	<acme:list-column code="administrator.technology-record.list.label.title" path="title" width="20%" />
	<acme:list-column code="administrator.technology-record.list.label.inventor" path="inventor" width="20%" />
	<acme:list-column code="administrator.technology-record.list.label.activitySector" path="activitySector" width="20%" />
	<acme:list-column code="administrator.technology-record.list.label.stars" path="stars" width="40%" />
</acme:list>


<a href="<jstl:url value="/administrator/technology-record/create"/>"><h1 style="color:DodgerBlue;"><acme:message code="administrator.technology-record.form.button.create"/></h1></a>