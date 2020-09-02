<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:list readonly="false">
	<acme:list-column code="authenticated.activity.list.label.title" path="title" width="50%" />
	<acme:list-column code="authenticated.activity.list.label.ticker" path="budget" width="50%" />
</acme:list>

<a href="<jstl:url value="/authenticated/investment-round/show">
<jstl:param name = "id" value = "${tsw}"/>
</jstl:url>"><h1 style="color:DodgerBlue;"><acme:message code="authenticated.activity.list.round"/></h1></a>