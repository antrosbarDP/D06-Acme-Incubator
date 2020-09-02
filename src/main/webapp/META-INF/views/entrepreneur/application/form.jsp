<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="entrepreneur.application.form.label.investmentRound" path="investmentRound.title" />
	<acme:form-textbox code="entrepreneur.application.form.label.ticker" path="ticker" />
	<acme:form-url code="entrepreneur.application.form.label.investor" path="investor.firmName" />
	<acme:form-moment code="entrepreneur.application.form.label.creationDate" path="creationDate" />
	<acme:form-money code="entrepreneur.application.form.label.offer" path="offer" />
	
	<acme:form-return code="entrepreneur.application.form.button.return"/>
</acme:form>