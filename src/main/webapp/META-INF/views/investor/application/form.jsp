<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="investor.application.form.label.investmentRound" path="investmentRound.title" />
	<acme:form-textbox code="investor.application.form.label.ticker" path="ticker" />
	<acme:form-url code="investor.application.form.label.investor" path="investor.firmName" />
	<acme:form-moment code="investor.application.form.label.creationDate" path="creationDate" />
	<acme:form-money code="investor.application.form.label.offer" path="offer" />
	
	<acme:form-return code="investor.application.form.button.return"/>
</acme:form>