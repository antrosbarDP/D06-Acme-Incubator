<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:list readonly="false">
	<acme:list-column code="anonymous.technology-record.list.label.title" path="title" width="20%" />
	<acme:list-column code="anonymous.technology-record.list.label.inventor" path="inventor" width="20%" />
	<acme:list-column code="anonymous.technology-record.list.label.activitySector" path="activitySector" width="20%" />
	<acme:list-column code="anonymous.technology-record.list.label.stars" path="stars" width="40%" />
</acme:list>