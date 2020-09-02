<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="authenticated.investment-round.form.label.title" path="title" />
	<acme:form-textbox code="authenticated.investment-round.form.label.ticker" path="ticker" />
	<acme:form-url code="authenticated.investment-round.form.label.additionalInfo" path="additionalInfo" />
	<acme:form-moment code="authenticated.investment-round.form.label.creationDate" path="creationDate" />
	<acme:form-select code="authenticated.investment-round.form.label.roundKind" path="roundKind">>
		<acme:form-option code="authenticated.investment-round.form.label.kind.angel" value="ANGEL" />
		<acme:form-option code="authenticated.investment-round.form.label.kind.seeed" value="SEED" />
		<acme:form-option code="authenticated.investment-round.form.label.kind.sa" value="SERIES-A" />
		<acme:form-option code="authenticated.investment-round.form.label.kind.sb" value="SERIES-B" />
		<acme:form-option code="authenticated.investment-round.form.label.kind.sc" value="SERIES-C" />
		<acme:form-option code="authenticated.investment-round.form.label.kind.bridge" value="BRIDGE" />
	</acme:form-select>
	<acme:form-money code="authenticated.investment-round.form.label.amount" path="amount" />
	<acme:form-textarea code="authenticated.investment-round.form.label.description" path="description" />
	<a href="<jstl:url value="/authenticated/activity/list">
	<jstl:param name = "roundId" value = "${id}"/>
	</jstl:url>"><h1 style="color:DodgerBlue;"><acme:message code="authenticated.investment-round.form.workProgramme"/></h1></a>
	
	<acme:form-return code="authenticated.investment-round.form.button.return"/>
</acme:form>