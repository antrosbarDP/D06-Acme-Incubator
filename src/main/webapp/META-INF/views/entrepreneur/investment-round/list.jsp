<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:list readonly="false">
	<acme:list-column code="entrepreneur.investment-round.list.label.title" path="title" width="20%" />
	<acme:list-column code="entrepreneur.investment-round.list.label.ticker" path="ticker" width="20%" />
	<acme:list-column code="entrepreneur.investment-round.list.label.creationDate" path="creationDate" width="60%" />
</acme:list>


<a href="<jstl:url value="/entrepreneur/investment-round/create"/>"><h1 style="color:DodgerBlue;"><acme:message code="entrepreneur.investment-round.form.button.create"/></h1></a>