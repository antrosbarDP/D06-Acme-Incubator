<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:list readonly="false">
	<acme:list-column code="entrepreneur.application.list.label.investmentRound" path="investmentRound.title" width="20%" />
	<acme:list-column code="entrepreneur.application.list.label.ticker" path="ticker" width="20%" />
	<acme:list-column code="entrepreneur.application.list.label.creationDate" path="creationDate" width="60%" />
</acme:list>